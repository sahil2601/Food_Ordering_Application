package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.foodorderingapp.Adapters.OrderAdapter;
import com.example.foodorderingapp.Models.OrderModel;
import com.example.foodorderingapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrderModel> list= new ArrayList<>();
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.burger_2,"Burger","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));
        list.add(new OrderModel(R.drawable.samosa,"Samosa","4","12343"));

        OrderAdapter adapter=new OrderAdapter(list,this);
        binding.orderRecycleView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecycleView.setLayoutManager(layoutManager);

    }
}