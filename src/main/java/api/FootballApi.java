package api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

public class FootballApi {

    OkHttpClient client = new OkHttpClient();

    public <T> T getResponse (FootballRequestBuilder builder) throws Exception {
        Response response = buildResponse(builder);

        Gson gson = new Gson();
        return gson.fromJson(response.body().string().toString(), new TypeToken<List<T>>(){}.getType());
    }

    public <T> T getResponse(FootballRequestBuilder builder, Class<T> genericClass) throws Exception {
        Response response = buildResponse(builder);

        Gson gson = new Gson();
        return gson.fromJson(response.body().string().toString(), genericClass);
    }

    private Response buildResponse(FootballRequestBuilder builder) throws IOException {
        return client.newCall(builder.buildRequest()).execute();
    }

}
