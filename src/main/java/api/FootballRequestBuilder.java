package api;

import com.squareup.okhttp.Request;

public class FootballRequestBuilder {

    private String url;

    public FootballRequestBuilder(String url) {
        this.url = url;
    }

    public Request buildRequest() {
        return new Request.Builder().url(url).build();
    }

}
