package TikTok;

import TikTok.Content.*;
import TikTok.BottomBar.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
        return discover.
                getVideosByHashtag()
                .keySet()
                .stream()
                .sorted(Comparator.comparingInt(x -> discover.getVideosByHashtag().get(x).size()).reversed())
                .collect(Collectors.toList());
    }
}
