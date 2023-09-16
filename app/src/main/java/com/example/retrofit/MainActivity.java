package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface api ;
    RecyclerView recyclerView ;
    LinearLayoutManager linearLayoutManager;
    RecycleviewAdapter adapter;
    List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rec);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecycleviewAdapter(posts);
        recyclerView.setAdapter(adapter);



        api = Creator.getRetrofitInstance();
        getPosts();
    }
    private void getPosts() {

        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()&& response.body()!= null){

                    posts = response.body();


                    //posts.addAll(response.body());
                    //posts = response.body();
                    //recycleviewAdapter.RecycleviewAdapter(posts);



                   // posts = (ArrayList<Post>) response.body();
                    //recycleviewAdapter.notifyDataSetChanged();
//                    for (int i = 0; i < response.body().size(); i++) {
//
//                        Log.e("title",response.body().get(i).getTitle());
//
//                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
               // Toast.makeText(this , " Erorr" , Toast.LENGTH_LONG).show();

            }
        });
    }
    }
