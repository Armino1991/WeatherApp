package service;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import repository.CurrentRepository;

import java.io.IOException;

public class HttpService {
    private static final String BASE_URL = "http://api.weatherstack.com";
    private static final String ACCESS_KEY = "22f972b8e72a81d190e4092c7dd6c1bd";

    public String requestAPI (String nameOfCity) throws IOException {
    OkHttpClient client = new OkHttpClient();

    HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + "/current").newBuilder();
        urlBuilder.addQueryParameter("access_key", ACCESS_KEY);
        urlBuilder.addQueryParameter("query", nameOfCity);

    String url = urlBuilder.build().toString();

    Request request = new Request.Builder().url(url).build();
    Response response = client.newCall(request).execute();
    String responseString = response.body().string();
       // System.out.println(responseString);
    return responseString;

    }
}
