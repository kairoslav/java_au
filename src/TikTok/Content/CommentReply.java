package TikTok.Content;

public class CommentReply {
    private final String userProfile;
    private final int likes;
    private final String text;

    public CommentReply(String userProfile, int likes, String text) {
        this.userProfile = userProfile;
        this.likes = likes;
        this.text = text;
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

    @Override
    public String toString() {
        return "CommentReply{" +
                "userName='" + userProfile.toString() + '\'' +
                ", likes=" + likes +
                ", text='" + text + '\'' +
                '}';
    }
}
