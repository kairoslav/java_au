package TikTok.Content;

import java.util.List;

public class Profile {
    private String userName;
    private int followingCount;
    private int followersCount;
    private int likesCount;
    private List<Profile> following = null;
    private List<Profile> followers = null;
    private List<Video> userVideos;
    private List<Video> likedVideos;
    private List<Video> privateVideo;

    public Profile(String userName, int followingCount, int followersCount, int likesCount,
                   List<Profile> following, List<Profile> followers,
                   List<Video> userVideos, List<Video> likedVideos, List<Video> privateVideo) {
        this.userName = userName;
        this.followingCount = followingCount;
        this.followersCount = followersCount;
        this.likesCount = likesCount;
        this.following = following;
        this.followers = followers;
        this.userVideos = userVideos;
        this.likedVideos = likedVideos;
        this.privateVideo = privateVideo;
    }

    public String getUserName() {
        return userName;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public List<Profile> getFollowing() {
        return following;
    }

    public List<Profile> getFollowers() {
        return followers;
    }

    public List<Video> getUserVideos() {
        return userVideos;
    }

    public List<Video> getLikedVideos() {
        return likedVideos;
    }

    public List<Video> getPrivateVideo() {
        return privateVideo;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "userName='" + userName + '\'' +
                ", followingCount=" + followingCount +
                ", followersCount=" + followersCount +
                ", likesCount=" + likesCount +
                ", following=" + following.toString() +
                ", followers=" + followers.toString() +
                ", userVideos=" + userVideos.toString() +
                ", likedVideos=" + likedVideos.toString() +
                ", privateVideo=" + privateVideo.toString() +
                '}';
    }
}
