package TikTok.BottomBar;

import TikTok.Content.Profile;
import TikTok.Content.Video;

import java.util.List;

public class MyProfile extends Profile{
    private Profile myProfile;

    public MyProfile(String userName,
                     int followingCount,
                     int followersCount,
                     int likesCount,
                     List<Profile> following,
                     List<Profile> followers,
                     List<Video> userVideos,
                     List<Video> likedVideos,
                     List<Video> privateVideo) {
        super(userName, followingCount, followersCount, likesCount, following, followers, userVideos, likedVideos, privateVideo);
    }
}
