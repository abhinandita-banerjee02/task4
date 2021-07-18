package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String url = "https://pixabay.com/";


    RecyclerView recyclerView;
    List<model> modelslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        modelslist = new ArrayList<>();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myapi api = retrofit.create(myapi.class);
        Call<List<model>> call = api.getmodels();
        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                if (response.code() != 200) {
                    //handle error
                    return;
                }
                List<model> models = response.body();
                for (model m : models) {
                    //String responseTest="";
                    //responseTest+=m.getLikes();
                    //Log.v("Tag",""+responseTest);
                    //int k=m.getLikes();
                    //String cat_name=m.getUser();
                    //String imag=m.getUserImageURL();
                    modelslist.add(m);
                }
            }


            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });

    }
    private void PutDataIntoRecyclerView(List<model>modelslist){
        Adaptery adaptery=new Adaptery(this,modelslist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }
}
