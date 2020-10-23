package TikTok.BottomBar;

import TikTok.Content.Profile;
import TikTok.Content.Video;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Home {
    private final List<Video> forYouFeed; // videos based on recommendations
    private final List<Video> followingFeed; // videos from users that you follow

    public Home(List<Video> forYouFeed, List<Video> followingFeed) {
        this.forYouFeed = forYouFeed;
        this.followingFeed = followingFeed;

    }

    public List<Video> getForYouFeed() {
        return forYouFeed;
    }

    public List<Video> getFollowingFeed() {
        return followingFeed;
    }

    @Override
    public String toString() {
        return "Home{" +
                "forYouFeed=" + forYouFeed.toString() +
                ", followingFeed=" + followingFeed.toString() +
                '}';
    }
}
