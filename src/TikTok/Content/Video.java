package TikTok.Content;

import java.util.List;

public class Video {
    private final String videoId;
    private final String authorProfile;
    private final String description;
    private final int likes;
    private final List<Comment> comments;
    private final int repliesCount;

    public Video(String videoId, String authorProfile, String description, int likes, List<Comment> comments, int repliesCount) {
        this.videoId = videoId;
        this.authorProfile = authorProfile;
        this.description = description;
        this.likes = likes;
        this.comments = comments;
        this.repliesCount = repliesCount;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getAuthorProfile() {
        return authorProfile;
    }

    public String getDescription() {
        return description;
    }

    public int getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getRepliesCount() {
        return repliesCount;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId='" + videoId + '\'' +
                ", authorProfile='" + authorProfile + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", repliesCount=" + repliesCount +
                '}';
    }
}
