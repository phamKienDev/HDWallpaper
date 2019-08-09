package com.hlub.dev.assandroidnet.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostRetrofit {

    public static PostService postService;

    public static PostService getInstance() {
        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://asian.dotplays.com")
                    .addConverterFactory(GsonConverterFactory.create()).build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }
}
