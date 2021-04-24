package com.example.githubclient;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageTemplateVerifierTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void verifyCommitName() {
        // LEETCODE-\\d+\\.?\\d?-\\d+ (Added|Fixed|Refactored|Moved).*
        String wrongCommit = "Fixed solution";
        assertFalse(MessageTemplateVerifier.verifyCommitName(wrongCommit));
        wrongCommit = "LEETCODE-100-1 Solution";
        assertFalse(MessageTemplateVerifier.verifyCommitName(wrongCommit));
        String rightCommit = "LEETCODE-202.1-20 Added Solution";
        assertTrue(MessageTemplateVerifier.verifyCommitName(rightCommit));
        rightCommit = "LEETCODE-201-58 Fixed Solution";
        assertTrue(MessageTemplateVerifier.verifyCommitName(rightCommit));

    }

    @Test
    public void verifyPullRequestName() {
        // LEETCODE-\\d+\\.?\\d?-\\d+ .*
        String wrongPR = "LEETCODE Solution 228";
        assertFalse(MessageTemplateVerifier.verifyPullRequestName(wrongPR));
        String rightPR = "LEETCODE-202.1-20 Solution";
        assertTrue(MessageTemplateVerifier.verifyPullRequestName(rightPR));
    }
}