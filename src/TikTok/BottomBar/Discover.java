package TikTok.BottomBar;

import TikTok.Content.Video;

import java.util.List;
import java.util.Map;

public class Discover {
    private final Map<String, List<Video>> videosByHashtag;

    public Discover(Map<String, List<Video>> videosByHashtag) {
        this.videosByHashtag = videosByHashtag;
    }

    public Map<String, List<Video>> getVideosByHashtag() {
        return videosByHashtag;
    }

    @Override
    public String toString() {
        return "Discover{" +
                "Hashtag=" + videosByHashtag.toString() +
                '}';
    }
}
