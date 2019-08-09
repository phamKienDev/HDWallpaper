package com.hlub.dev.assandroidnet.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hlub.dev.assandroidnet.ImageActivity;
import com.hlub.dev.assandroidnet.ImageDetailActivity;
import com.hlub.dev.assandroidnet.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LatestAdapter extends BaseAdapter {
    private List<String> texts;
    Context context;

    public LatestAdapter(List<String> texts, Context context) {
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
        convertView = layoutInflater.inflate(R.layout.item_content_main, null);


        TextView tvViewItemMain = (TextView) convertView.findViewById(R.id.tvViewItemMain);
        TextView tvFavoriteItemMain = (TextView) convertView.findViewById(R.id.tvFavoriteItemMain);
        CardView cardViewItemImage = (CardView) convertView.findViewById(R.id.cardViewItemImage);
        ImageView imgItemView = convertView.findViewById(R.id.imgItemView);


        cardViewItemImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageActivity.class);
                intent.putExtra("linkImage",texts.get(position));
                context.startActivity(intent);
            }
        });
        tvViewItemMain.setText("10");
        tvFavoriteItemMain.setText("10");
        Picasso.get()
                .load(texts.get(position))
                .error(R.drawable.app_icon)
                .into(imgItemView);


        return convertView;
    }
}
