package chap5;

import java.io.Serializable;

public class Article implementes Serializable {

    private static final long serialVersionUID = 1L;
    public String title;
    public String url;
    public transient boolean expired;

    public Article(String title, String url) {
        this.titile = title;
        this.url = url;
        this.expired = expired;
    }

}
