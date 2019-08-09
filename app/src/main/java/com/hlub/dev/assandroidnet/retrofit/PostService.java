package com.hlub.dev.assandroidnet.retrofit;

import com.hlub.dev.assandroidnet.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    //http://asian.dotplays.com/wp-json/wp/v2/posts?_embed
    @GET("wp-json/wp/v2/posts?_embed")
    Call<List<Post>> getLatest();
}
