package TikTok;

import TikTok.BottomBar.Discover;
import TikTok.BottomBar.Home;
import TikTok.Content.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private final static int bound = 10000;
    private static final Random random = new Random();

    private static String randomHashtag() {
        switch (random.nextInt(7)) {
            case 0: return VideoHashtags.FYP.getHashtag();
            case 1: return VideoHashtags.LONER.getHashtag();
            case 2: return VideoHashtags.PAIN.getHashtag();
            case 3: return VideoHashtags.SMH.getHashtag();
            case 4: return VideoHashtags.TEENAGER.getHashtag();
            case 5: return VideoHashtags.TIKTOKFANFEST.getHashtag();
            case 6: return VideoHashtags.VIRGINGANG.getHashtag();
            default: return null;
        }
    }

    private static String generateCommentText() {
        switch (random.nextInt(9)) {
            case 0: return "Lmao what a loser";
            case 1: return "You so cute huh";
            case 2: return "Girls, I think that he is my new crush";
            case 3: return "I am so tired from doing this homework";
            case 4: return "No way mate!!";
            case 5: return "Ahahahhahahah";
            case 6: return "By the way it reminds me a joke about jew russian and american";
            case 7: return "WTF";
            case 8: return "I LOVE YOU";
            default: return null;
        }
    }

    private static CommentReply generateCommentReply() {
        return new CommentReply(
                "user" + random.nextInt(bound),
                random.nextInt(30),
                generateCommentText()
        );
    }

    private static List<CommentReply> generateCommentReplies() {
        List<CommentReply> cr = new LinkedList<>();
        for (int i = 0; i <= random.nextInt(2); i++) {
            cr.add(generateCommentReply());
        }
        return cr;
    }

    private static Comment generateComment() {
        return new Comment(
                "user" + random.nextInt(bound),
                random.nextInt(30),
                generateCommentText(),
                generateCommentReplies()
        );
    }

    private static List<Comment> generateComments() {
        List<Comment> comments = new LinkedList<>();
        for (int i = 0; i <= random.nextInt(5) + 5; i++) {
            comments.add(generateComment());
        }
        return comments;
    }

    private static String generateDescription() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i <= random.nextInt(5) + 5; i++) {
            s.append(randomHashtag()).append(" ");
        }
        return s.toString();
    }

    private static Video generateVideo() {
        return new Video(
                "video" + random.nextInt(bound),
                "user" + random.nextInt(bound),
                generateDescription(),
                random.nextInt(bound),
                generateComments(),
                random.nextInt(bound)
        );
    }

    // this method is redundant
    private static List<Video> generateVideos() {
        List<Video> videos = new LinkedList<>();
        for (int i = 0; i < random.nextInt(10) + 5; i++) {
            videos.add(generateVideo());
        }
        return videos;
    }


    // this method is redundant
    public Profile generateProfile() {
        return new Profile(
                "user" + random.nextInt(bound),
                random.nextInt(bound),
                random.nextInt(bound),
                random.nextInt(bound),
                null,
                null,
                generateVideos(),
                generateVideos(),
                generateVideos()
        );
    }


    public static Map<String, List<Video>> generateDiscoverMap() {
        Map<String, List<Video>> videosByHashtag = new LinkedHashMap<>();
        for (int i = 0; i < random.nextInt(5) + 5; i++) {
            videosByHashtag.put(randomHashtag(), generateVideos());
        }
        return videosByHashtag;
    }

    private static final Home home = new Home(generateVideos(), generateVideos());
    private static final Discover discover = new Discover(generateDiscoverMap());
    public static final Video video = generateVideo();


    public static void main(String[] args) {
        System.out.println("Videos from recommendations sorted by likes:");
        List<Video> lv = InstrumentsOfAnalytics.getTopNVideosFromYourFollowingsSortedByLikes(3, home);
        for (Video v : lv) {
            System.out.println(v.toString());
        }
        System.out.println("\nVideos from recommendations sorted by amount of comments");
        List<Video> videosByComments = InstrumentsOfAnalytics.getTopNVideosFromYourFollowingByAmountOfComments(3, home);
        for (Video v : videosByComments) {
            System.out.println("Video{authorName='" + v.getAuthorProfile()
                    + ", commentCount=" + v.getComments().size()
                    + "', comments=[" + v.getComments() + "]");
        }
        System.out.println("\nAll hashtags:");
        for (String hashtag : discover.getVideosByHashtag().keySet()) {
            System.out.println("Hashtag= " + hashtag + ", count= " + discover.getVideosByHashtag().get(hashtag).size());
        }
        System.out.println("\nThe most popular hashtags now:");
        List<String> topHashtags = InstrumentsOfAnalytics.getTopNMostPopularHashtagAtTheMoment(3, discover);
        for (String v : topHashtags) {
            System.out.println(v);
        }
        System.out.println("\nThe most replied comment from video=" + video.toString() + "\n" + InstrumentsOfAnalytics.getTheMostRepliedCommentFromVideo(video));
        System.out.println("\nThe most liked comment for each video:");
        List<Video> videos = generateVideos();
        Map<String, Comment> sc = InstrumentsOfAnalytics.forEachVideoGetMostLikedComment(videos);
        for (Map.Entry<String, Comment> a : sc.entrySet()) {
            System.out.println(a.getKey() + " likes=" + a.getValue().getLikes() + " comment=" + a.getValue().getText());
        }
    }
}
