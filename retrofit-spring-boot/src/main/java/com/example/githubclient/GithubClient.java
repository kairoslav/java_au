package com.example.githubclient;

import com.example.githubclient.models.PRComment;
//import org.eclipse.egit.github.core.*;
import com.example.githubclient.models.*;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GithubClient {
    static final String API_BASE_URL = "https://api.github.com/";
    static final String API_VERSION_SPEC = "application/vnd.github.v3+json";
    static final String JSON_CONTENT_TYPE = "application/json";

    private String accessToken;
    private final GithubApiInterface service;

    public GithubClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GithubApiInterface.class);
        this.accessToken = "token " + System.getenv("github-token");
        System.out.println(this.accessToken);
    }


    public List<Repository> getRepositories() throws IOException {
        Call<List<Repository>> retrofitCall = service.listRepos(accessToken, API_VERSION_SPEC);

        Response<List<Repository>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }


    public String getPullRequests(String owner, String repository_name) throws  IOException {
        Call<List<PullRequest>> retrofitCall = service.listPulls(accessToken, API_VERSION_SPEC, owner, repository_name);

        Response<List<PullRequest>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        String error_string = "";
        List<PullRequest> pulls = response.body();
        if (pulls == null) {
            return "No pulls\n\n";
        }
        for (PullRequest pull: pulls) {
            if (MessageTemplateVerifier.verifyPullRequestName(pull.getTitle())) {
                error_string += "PR title=<" + pull.getTitle() + "> is ok!\n\n";
            }
            else {
                error_string += "PR title=<" + pull.getTitle() + "> is NOT ok!\n\n";
            }

        }
        return error_string;
    }

    public String getPullRequestCommits(String owner, String repository_name, int number) throws IOException {
        Call<List<Commit>> retrofitCall = service.listPullRequestCommits(accessToken, API_VERSION_SPEC, owner, repository_name, number);

        Response<List<Commit>> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        // TODO: check only the last 2 commits
        String error_string = "";
        List<Commit> commits = response.body();
        if (commits == null) {
            return "No commits\n\n";
        }
        for (Commit comm: commits) {
            if (comm == null) {
                error_string += "NULL\n\n";
            }
            else {
                String commMessage = comm.getNodeMessage();
                if (commMessage == null) {
                    error_string += "NULL\n\n";
                }
                else {
                    if (MessageTemplateVerifier.verifyPullRequestName(commMessage)) {
                        error_string += "Commit message=<" + commMessage + "> is ok!\n\n";
                    } else {
                        error_string += "Commit message=<" + commMessage + "> is NOT ok!\n\n";
                    }
                }
            }
        }

//        PRComment comm = new PRComment.Builder().withBody("Hello/n").build();
//        createCommentToPullRequest(comm, repository_name, owner, number);
//        Comment comm = new Comment();
//        comm.setBody("Hello");
//        createCommentToPullRequest(comm, repository_name, owner, number);
        return error_string;
//        return response.body();
    }

    public Repository createRepository(Repository repo) throws IOException {
        Call<Repository> retrofitCall = service.createRepo(repo, accessToken, API_VERSION_SPEC, JSON_CONTENT_TYPE);

        Response<Repository> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public Comment createCommentToPullRequest(Comment comm, String repoName, String owner, int pull_number) throws IOException {
        Call<Comment> retrofitCall = service.addCommentToPullRequest(comm, accessToken, API_VERSION_SPEC, repoName, owner, pull_number);

        Response<Comment> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }

        return response.body();
    }

    public Comment createIssueComment(Comment comm, String owner, String repoName, int issue_number) throws IOException {
        Call<Comment> retrofitCall = service.addIssueComment(comm, accessToken, API_VERSION_SPEC, owner, repoName, issue_number);

        Response<Comment> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

    public PRComment createIssueComment2(PRComment comm, String owner, String repoName, int issue_number) throws IOException {
        Call<PRComment> retrofitCall = service.addIssueComment2(comm, accessToken, API_VERSION_SPEC, owner, repoName, issue_number);

        Response<PRComment> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null
                    ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }

//    public DeletePayload deleteRepository(String owner, String repoName) throws IOException {
//        Call<DeletePayload> retrofitCall = service.deleteRepo(accessToken, API_VERSION_SPEC, repoName, owner);
//
//        Response<DeletePayload> response = retrofitCall.execute();
//
//        if (!response.isSuccessful()) {
//            throw new IOException(response.errorBody() != null
//                    ? response.errorBody().string() : "Unknown error");
//        }
//
//        return response.body();
//    }
}