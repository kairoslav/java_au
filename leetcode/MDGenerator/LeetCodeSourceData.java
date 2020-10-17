package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;

public class LeetCodeSourceData {
    private final String title;
    private final String leetcodeLink;
    private final String solution;

    public LeetCodeSourceData(String txtFilePath) throws Throwable {
        List<String> data = ReadWriteUtils.read(txtFilePath);

        if (data.isEmpty()) {
            throw new FileNotFoundException("Txt file hasn't found");
        } else {
            this.title        = data.get(0).replaceFirst("[0-9]*. ", "");
            this.leetcodeLink = data.get(1);

            StringBuilder solution_with_newlines = new StringBuilder();

            for (String line : data.subList(2, data.size() - 1)) {
                solution_with_newlines.append(String.format("%s\n", line));
            }

            this.solution = solution_with_newlines.toString();
        }
    }

    private static String firstCharUpper(String s) {
        StringBuilder str = new StringBuilder(s);

        str.setCharAt(0, s.charAt(0));

        return str.toString();
    }

    public void writeToMDFile(String mdFilePath) throws IOException {
        String commentMDLink   = "[MDLink]: <>";
        String commentSolution = "[Solution]: <>";

        if (!Files.exists(Path.of(mdFilePath)) || (Files.size(Path.of(mdFilePath)) == 0)) {
            String finalResult = String.format("# %s\n\n%s\n\n%s\n\n## %s\n\n%s\n\n```java\n%s```\n\n%s",
                                               firstCharUpper(mdFilePath.replace(".md", "")),
                                               getMDSolutionLink(),
                                               commentMDLink,
                                               title,
                                               leetcodeLink,
                                               solution,
                                               commentSolution);

            ReadWriteUtils.write(mdFilePath, finalResult);
        } else {
            List<String>  MDFile      = ReadWriteUtils.read(mdFilePath);
            StringBuilder finalResult = new StringBuilder();

            for (String line : MDFile) {
                if (line.equals(commentMDLink)) {
                    finalResult.append(getMDSolutionLink()).append("\n\n").append(commentMDLink).append("\n");
                } else if (line.equals(commentSolution)) {
                    finalResult.append(String.format("## %s", title)).append("\n\n");
                    finalResult.append(leetcodeLink).append("\n\n");
                    finalResult.append("```java\n").append(solution);
                    finalResult.append("```").append("\n\n");
                    finalResult.append(commentSolution);
                } else {
                    finalResult.append(line).append("\n");
                }
            }

            ReadWriteUtils.write(mdFilePath, finalResult.toString());
        }
    }

    private String getMDSolutionLink() {
        return String.format("+ [%s](#%s)", title, title.toLowerCase().replace(' ', '-'));
    }
}
