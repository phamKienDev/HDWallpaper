package com.hlub.dev.assandroidnet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDetailActivity extends AppCompatActivity implements Html.ImageGetter  {
    private FloatingActionMenu fab;
    private FloatingActionButton fabFavorites;
    private FloatingActionButton fabShare;
    private FloatingActionButton fabSave;
    private FloatingActionButton fabSetAs;
    private TextView imgView;

    private Drawable empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imgView = (TextView) findViewById(R.id.imgView);
//        fab = (FloatingActionMenu) findViewById(R.id.fab);
//        fabFavorites = (FloatingActionButton) findViewById(R.id.fabFavorites);
//        fabShare = (FloatingActionButton) findViewById(R.id.fabShare);
//        fabSave = (FloatingActionButton) findViewById(R.id.fabSave);
//        fabSetAs = (FloatingActionButton) findViewById(R.id.fabSetAs);


        String source = "<figure><img src=\"http://asian.dotplays.com/wp-content/uploads/2019/07/Ryu-Ji-Hye-Spring-White-Dress-27.jpg\" alt=\"\" data-id=\"327\" data-link=\"http://asian.dotplays.com/?attachment_id=327\" class=\"wp-image-327\" srcset=\"http://asian.dotplays.com/wp-content/uploads/2019/07/Ryu-Ji-Hye-Spring-White-Dress-27.jpg 1000w, http://asian.dotplays.com/wp-content/uploads/2019/07/Ryu-Ji-Hye-Spring-White-Dress-27-300x200.jpg 300w, http://asian.dotplays.com/wp-content/uploads/2019/07/Ryu-Ji-Hye-Spring-White-Dress-27-768x512.jpg 768w\" sizes=\"(max-width: 1000px) 100vw, 1000px\" />";
        Spanned spanned = Html.fromHtml(source, ImageDetailActivity.this, null);
        imgView.setText(spanned);

    }

    @Override
    public Drawable getDrawable(String source) {
        LevelListDrawable d = new LevelListDrawable();
        empty = getResources().getDrawable(R.drawable.app_icon);
        d.addLevel(0, 0, empty);
        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
        new LoadImage().execute(source, d);
        return d;
    }

    class LoadImage extends AsyncTask<Object, Void, Bitmap> {
        private LevelListDrawable mDrawable;

        @Override
        protected Bitmap doInBackground(Object... params) {
            String source = (String) params[0];
            mDrawable = (LevelListDrawable) params[1];
            Log.d("TAG", "doInBackground " + source);
            try {
                InputStream is = new URL(source).openStream();
                return BitmapFactory.decodeStream(is);
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG",e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                BitmapDrawable d = new BitmapDrawable(bitmap);
                mDrawable.addLevel(1, 1, d);
                //mDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                mDrawable.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());
                mDrawable.setLevel(1);
                CharSequence t = imgView.getText();
                imgView.setText(t);
            }
        }
    }
}
