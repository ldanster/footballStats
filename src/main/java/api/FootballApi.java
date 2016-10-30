package api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class FootballApi {

    OkHttpClient client = new OkHttpClient();

    public <T> T getResponse(FootballRequestBuilder builder, Class<T> model) throws Exception {
        Response response = buildResponse(builder);

        Gson gson = new Gson();
        return gson.fromJson(response.body().string().toString(), model);
    }

    private Response buildResponse(FootballRequestBuilder builder) throws IOException {
        return client.newCall(builder.buildRequest()).execute();
    }

}
