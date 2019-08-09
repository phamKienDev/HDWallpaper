package com.hlub.dev.assandroidnet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.hlub.dev.assandroidnet.adapter.LatestAdapter;
import com.hlub.dev.assandroidnet.adapter.TestAdapter;
import com.hlub.dev.assandroidnet.model.Post;
import com.hlub.dev.assandroidnet.retrofit.PostRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFavoritesActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridView gridviewFavorite;
    LatestAdapter latestAdapter;
    List<String> linkImageFavoriteList;
    List<Post> favoriteList;
TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_favorites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        gridviewFavorite = (GridView) findViewById(R.id.gridviewFavorite);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        favoriteList = new ArrayList<>();
        linkImageFavoriteList = new ArrayList<>();
        getImageFavoriteInData();
//        List<String> list = new ArrayList<>();
//        list.add("1");
//        list.add("1");
//        list.add("1");
//        testAdapter = new TestAdapter(list, MyFavoritesActivity.this);
//        gridviewFavorite.setAdapter(testAdapter);
//        testAdapter.notifyDataSetChanged();
    }

    public void getImageFavoriteInData() {
        PostRetrofit.getInstance().getLatest().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                favoriteList.addAll(response.body());
                for (int i = 0; i < favoriteList.size(); i++) {
                    Post post = favoriteList.get(i);
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
                            linkImageFavoriteList.add(w);
                        }
                    }

                }
                latestAdapter = new LatestAdapter(linkImageFavoriteList, MyFavoritesActivity.this);
                gridviewFavorite.setAdapter(latestAdapter);
                latestAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_lateset) {
            Intent intent = new Intent(MyFavoritesActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_cate) {
            Intent intent = new Intent(MyFavoritesActivity.this, CateActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gifs) {

        } else if (id == R.id.nav_favorite) {
            //Intent intent = new Intent(MyFavoritesActivity.this, MyFavoritesActivity.class);
            //startActivity(intent);
        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(MyFavoritesActivity.this, AboutUsActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
