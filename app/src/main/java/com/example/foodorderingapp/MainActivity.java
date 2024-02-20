package com.example.foodorderingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.foodorderingapp.Adapters.MainAdapter;
import com.example.foodorderingapp.Models.MainModel;
import com.example.foodorderingapp.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list =new ArrayList<>();
        list.add(new MainModel(R.drawable.burger_2,"Burger","5","Savor gourmet burgers, delivered fast"));
         list.add(new MainModel(R.drawable.samosa,"Pamosa","5","Mote ho jaaoge Munna"));
        list.add(new MainModel(R.drawable.momes,"Momoes","5","Mote ho jaaoge Munna"));
        list.add(new MainModel(R.drawable.pasta_1,"Pasta","5","Mote ho jaaoge Munna"));
        list.add(new MainModel(R.drawable.sandwich_1,"Sandwich","5","Mote ho jaaoge Munna"));
        list.add(new MainModel(R.drawable.noodle_1,"Noodle","5","Mote ho jaaoge Munna"));

        MainAdapter adapter = new MainAdapter(list, this);

        // Set up RecyclerView
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }




}