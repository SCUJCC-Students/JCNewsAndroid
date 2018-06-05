package com.example.lenovo.test5;


import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNewsList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mview;
        TextView newsTitle;
        TextView newsTime;
        TextView newsAuthor;
        ImageView newsPhotos;

        public ViewHolder(View view) {
            super(view);
            mview =view;
            newsTitle = (TextView) view.findViewById(R.id.news_item_title);
            newsTime = (TextView) view.findViewById(R.id.news_item_time);
            newsAuthor = (TextView) view.findViewById(R.id.news_item_author);
            newsPhotos = (ImageView) view.findViewById(R.id.news_item_photos);
        }
    }

    public NewsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent, false);
        ViewHolder holder  = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( NewsAdapter.ViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.newsTitle.setText(news.getTitle());
        holder.newsTime.setText(news.getTime());
        holder.newsTime.setText(news.getAuthor());
        holder.newsPhotos.setImageResource(news.getPhotos());
        holder.mview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context= v.getContext();
                Intent intent = new Intent(context,Main2Activity.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }


}
