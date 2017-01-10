package api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FootballApi {

    OkHttpClient client = new OkHttpClient();

    public <T> T getResponse(String url, Class<T> model) throws Exception {
        Response response = buildResponse(url);

        Gson gson = new Gson();
        return gson.fromJson(response.body().string(), model);
    }

    private Response buildResponse(String url) throws IOException {
        return client.newCall(new Request.Builder().url(url).build()).execute();
    }

}
