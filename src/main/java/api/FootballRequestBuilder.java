package api;

import com.squareup.okhttp.Request;

public class FootballRequestBuilder {

    private String url;

    private String baseUrl = "http://api.football-data.org/v1/";

    public FootballRequestBuilder(String url) {
        this.url = this.baseUrl + url;
    }

    public Request buildRequest() {
        return new Request.Builder().url(url).build();
    }

}
