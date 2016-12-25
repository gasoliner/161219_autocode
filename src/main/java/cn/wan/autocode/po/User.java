package cn.wan.autocode.po;

/**
 * Created by 万洪基 on 2016/12/24.
 */
public class User {
    private String cookie;
    private String url;

//    setter and getter

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

//    to String

    @Override
    public String toString() {
        return "User{" +
                "cookie='" + cookie + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
