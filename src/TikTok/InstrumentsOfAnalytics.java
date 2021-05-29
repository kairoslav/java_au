package TikTok;

import TikTok.Content.*;
import TikTok.BottomBar.*;

import java.util.*;
import java.util.stream.Collectors;

public class InstrumentsOfAnalytics {
    public static List<Video> getTopNVideosFromYourFollowingsSortedByLikes(int N, Home home) {
        return home.getFollowingFeed().stream()
            .sorted((x, y) -> y.getLikes() - x.getLikes())
            .limit(N)
            .collect(Collectors.toList());
    }

    public static List<Video> getTopNVideosFromYourFollowingByAmountOfComments(int N, Home home) {
        return home.getFollowingFeed().stream()
                .sorted((x, y) -> (int) ((long) y.getComments().size() - (long) x.getComments().size()))
                .limit(N)
                .collect(Collectors.toList());
    }

    public static List<String> getTopNMostPopularHashtagAtTheMoment(int N, Discover discover) {
        return discover
                .getVideosByHashtag()
                .keySet()
                .stream()
                .sorted(Comparator.comparingInt(x -> discover.getVideosByHashtag().get(x).size()).reversed())
                .collect(Collectors.toList());
    }

    public static String getTheMostRepliedCommentFromVideo(Video video) {
        return Objects.requireNonNull(video
                .getComments()
                .stream().max(Comparator.comparingInt(x -> x.getReplies().size())).orElse(null))
                .getText();
    }

    // 3 DIFFERENT REALISATION OF A FUNCTION
    /*
    public static Map<String, Comment> forEachVideoGetMostLikedCommentWithFOR(List<Video> videos) {
        Map<String, Comment> mostLikedCommentsForVideoId = new HashMap<>();
        for (Video v: videos) {
            int max = 0;
            Comment maxComment = null;
            for (Comment c: v.getComments()) {
                if (c.getLikes() > max) {
                    max = c.getLikes();
                    maxComment = c;
                }
            }
            mostLikedCommentsForVideoId.put(v.getVideoId(), maxComment);
        }
        return mostLikedCommentsForVideoId;
    }

    public static Map<String, Comment> forEachVideoGetMostLikedComment(List<Video> videos) {
        Map<String, Comment> videoIdCommentList = new LinkedHashMap<>();
        videos.forEach(x -> videoIdCommentList.put(x.getVideoId(), x.getComments().stream().max(Comparator.comparingInt(Comment::getLikes)).orElse(null)));
        return videoIdCommentList;
    }
    */
    public static Map<String, Comment> forEachVideoGetMostLikedComment(List<Video> videos) {
        return videos.stream()
                .collect(Collectors.
                        toMap(Video::getVideoId, y -> y.getComments().stream()
                                        .max(Comparator.comparingInt(Comment::getLikes))
                                        .orElse(new Comment(null, 0,null,null))));
    }
}
