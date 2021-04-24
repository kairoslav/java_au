package com.example.githubclient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTemplateVerifier {
    public static boolean verifyCommitName(String commitMessage) {
        Pattern pattern = Pattern.compile("LEETCODE-\\d+\\.?\\d?-\\d+ (Added|Fixed|Refactored|Moved).*");
        Matcher matcher = pattern.matcher(commitMessage);
        return matcher.find();
    }

    public static boolean verifyPullRequestName(String pullRequestTitle) {
        Pattern pattern = Pattern.compile("LEETCODE-\\d+\\.?\\d?-\\d+ .*");
        Matcher matcher = pattern.matcher(pullRequestTitle);
        return matcher.find();
    }
}
