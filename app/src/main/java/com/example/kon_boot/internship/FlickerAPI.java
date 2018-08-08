package com.example.kon_boot.internship;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class FlickerAPI {




    private static final String url = "https://api.flickr.com/services/rest/";

    public static RetrofitInter postService = null;

    public static RetrofitInter getPostService() {

        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();

            postService = retrofit.create(RetrofitInter.class);
        }
        return postService;
    }
    public interface RetrofitInter {


        @GET("?method=flickr.photos.getRecent&api_key=6f102c62f41998d151e5a1b48713cf13&format=json&nojsoncallback=1&extras=url_s")
        Call<Autocomplete> getPhotos1();

    }


}