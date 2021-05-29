package TikTok.Content;

import java.util.List;

public class Comment {
    private final String userProfile;
    private final int likes;
    private final String text;
    private final List<CommentReply> replies;

    public Comment(String userProfile, int likes, String text, List<CommentReply> replies) {
        this.userProfile = userProfile;
        this.likes = likes;
        this.text = text;
        this.replies = replies;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public int getLikes() {
        return likes;
    }

    public String getText() {
        return text;
    }

    public List<CommentReply> getReplies() {
        return replies;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userName='" + userProfile.toString() + '\'' +
                ", likes=" + likes +
                ", text='" + text + '\'' +
                ", replies=" + replies.toString() +
                '}';
    }
}
