package com.example.kon_boot.internship;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FlickerSearchAPI {
    private static final String url = "https://api.flickr.com/services/rest/";

    public static FlickerSearchAPI.RetrofitSearch postService = null;

    public static FlickerSearchAPI.RetrofitSearch getPostService() {

        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            postService = retrofit.create(FlickerSearchAPI.RetrofitSearch.class);
        }
        return postService;
    }
    public interface RetrofitSearch{

        @GET("?method=flickr.photos.search&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
        Call<Autocomplete> getSearch(@Query("text") String text);
    }
}
