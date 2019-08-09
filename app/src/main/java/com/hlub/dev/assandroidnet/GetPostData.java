package com.hlub.dev.assandroidnet;

import android.util.Log;

import com.hlub.dev.assandroidnet.adapter.LatestAdapter;
import com.hlub.dev.assandroidnet.model.Post;
import com.hlub.dev.assandroidnet.retrofit.PostRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetPostData {

    List<Post> postList;
    List<String> linkImageList;

    public List<String> getImageInData() {
        postList = new ArrayList<>();
        linkImageList = new ArrayList<>();
        PostRetrofit.getInstance().getLatest().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postList.addAll(response.body());
                for (int i = 0; i < postList.size(); i++) {
                    Post post = postList.get(i);
                    String rendered = post.getContent().getRendered();
                    Log.e("rendered", i + "----" + rendered);

                    //tách chuỗi
                    String[] words = rendered.split("\\s");

                    for (String w : words) {
                        Log.e("words", w + "\n");

//                        int vitri1 = w.indexOf("<img");
//                        int vitri2 = w.length();
//                        if (vitri1 >= 0) {
//                            Log.e("sub", w.substring(vitri1, vitri2) + "\n");
//                        }
                        //lấy link image
                        if (w.startsWith("http:") && w.endsWith("jpg")) {
                            Log.e("Content", w);
                            linkImageList.add(w);
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        return linkImageList;
    }
}
