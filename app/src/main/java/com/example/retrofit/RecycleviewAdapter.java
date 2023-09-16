package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHolder> {
    Context context ;
    List<Post> posts ;

    public RecycleviewAdapter(List<Post>posts ){
        //this.context = context ;
        this.posts = posts ;
        notifyDataSetChanged();


    }



//    public RecycleviewAdapter(List<Post> postList) {
//    }


    //public  class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewViewHolder>{
//        ArrayList<News> news;
//        public NewsAdapter (ArrayList<News>news) {
//            this.news = news;
//        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.
                            layout.list_itm, parent, false);

            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.tv1.setText(posts.get(position).getUserId());
           holder.tv2.setText(posts.get(position).getId());
           holder.tv3.setText(posts.get(position).getTitle());
           holder.tv4.setText(posts.get(position).getBody());


        }

//    public void setdata( List<Post> posts){
//        this.posts = posts;
//
//        notifyDataSetChanged();
//    }

        @Override
        public int getItemCount() {
            return posts.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder  {
            TextView tv1 , tv2 , tv3 , tv4;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv1 = itemView.findViewById(R.id.tv_usid);
                tv2 = itemView.findViewById(R.id.tv_id);
                tv3 = itemView.findViewById(R.id.tv_title);
                tv4 = itemView.findViewById(R.id.tv_body);
            }
        }
    }

