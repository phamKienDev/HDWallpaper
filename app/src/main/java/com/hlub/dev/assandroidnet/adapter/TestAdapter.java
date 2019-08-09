package com.hlub.dev.assandroidnet.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hlub.dev.assandroidnet.ImageActivity;
import com.hlub.dev.assandroidnet.ImageDetailActivity;
import com.hlub.dev.assandroidnet.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class TestAdapter extends BaseAdapter implements Html.ImageGetter {
    private List<String> texts;
    Context context;
    private Drawable empty;
    TextView tvItemTest;
    Spanned spanned;

    public TestAdapter(List<String> texts, Context context) {
        this.texts = texts;
        this.context = context;

    }

    @Override
    public int getCount() {
        return texts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.item_content_test, null);


        tvItemTest = (TextView) convertView.findViewById(R.id.tvItemTest);

        String source = "<figure><img src=\"http://asian.dotplays.com/wp-content/uploads/2019/07/27459977_10208561501034748_387120478026116737_n.jpg\" alt=\"\" class=\"wp-image-385\" srcset=\"http://asian.dotplays.com/wp-content/uploads/2019/07/27459977_10208561501034748_387120478026116737_n.jpg 635w, http://asian.dotplays.com/wp-content/uploads/2019/07/27459977_10208561501034748_387120478026116737_n-198x300.jpg 198w\" sizes=\"(max-width: 635px) 100vw, 635px\" />";
        spanned = Html.fromHtml(source, TestAdapter.this, null);
        tvItemTest.setText(spanned);


        return convertView;
    }

    @Override
    public Drawable getDrawable(String source) {
        LevelListDrawable d = new LevelListDrawable();
        empty = context.getResources().getDrawable(R.drawable.app_icon);
        d.addLevel(0, 0, empty);
        d.setBounds(0, 0, empty.getIntrinsicWidth(), empty.getIntrinsicHeight());

        new LoadImage().execute(source, d);
        return d;
    }

    public class LoadImage extends AsyncTask<Object, Void, Bitmap> {
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
                Log.d("TAG", e.toString());
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
                CharSequence t = tvItemTest.getText();
                tvItemTest.setText(t);
            }
        }
    }
}
