package TikTok.Content;

import java.util.List;

public class Message {
    private final String userProfile;
    private final List<String> conversation;

    public Message(String userProfile, List<String> conversation) {
        this.userProfile = userProfile;
        this.conversation = conversation;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public List<String> getConversation() {
        return conversation;
    }

    @Override
    public String toString() {
        return "Message{" +
                "userName='" + userProfile.toString() + '\'' +
                ", conversation=" + conversation +
                '}';
    }
}
