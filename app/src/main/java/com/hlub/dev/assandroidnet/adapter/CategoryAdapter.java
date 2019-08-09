package com.hlub.dev.assandroidnet.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hlub.dev.assandroidnet.R;
import com.hlub.dev.assandroidnet.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    Context context;
    List<Post> postList;

    public CategoryAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Post post = postList.get(position);
        List<String> stringList = new ArrayList<>();
        //title
        String title = post.getTitle().getRendered();

        //số lượng bài post

        //ảnh bài post

        String rendered = post.getContent().getRendered();

        String[] words = rendered.split("\\s");

        for (String w : words) {

            if (w.startsWith("http:") && w.endsWith("jpg")) {
                stringList.add(w);
            }
        }

        holder.tvItemCategory.setText(title + " (" + stringList.size() + ")");
        if(stringList.size()>0){
            Picasso.get()
                    .load(stringList.get(0))
                    .error(R.drawable.app_icon)
                    .into(holder.imgItemCate);
        }



    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        private TextView tvItemCategory;
        private ImageView imgItemCate;


        public CategoryHolder(View itemView) {
            super(itemView);
            tvItemCategory = (TextView) itemView.findViewById(R.id.tvItemCategory);
            imgItemCate = itemView.findViewById(R.id.imgItemCate);
        }
    }
}
