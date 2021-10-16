package TikTok.Content;

public enum VideoHashtags {
    FYP("#fyp"),
    PAIN("#pain"),
    SMH("#smh"),
    LONER("#loner"),
    VIRGINGANG("#virgingang"),
    TEENAGER("#teenager"),
    TIKTOKFANFEST("#tiktokfanfest");

    private String hashtag;

    VideoHashtags(String hashtag) {
        this.hashtag = hashtag;
    }

    public String getHashtag() {
        return hashtag;
    }
}
