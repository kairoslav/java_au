package TikTok.BottomBar;

import TikTok.Content.CommentReply;
import TikTok.Content.Message;

import java.util.List;

public class Inbox {
    List<CommentReply> replies;
    List<Message> messages;

    public Inbox(List<CommentReply> replies, List<Message> messages) {
        this.replies = replies;
        this.messages = messages;
    }

    public List<CommentReply> getReplies() {
        return replies;
    }

    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public String toString() {
        return "Inbox{" +
                "replies=" + replies.toString() +
                ", messages=" + messages.toString() +
                '}';
    }
}
