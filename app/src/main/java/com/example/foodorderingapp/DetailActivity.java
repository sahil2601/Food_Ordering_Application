package com.example.foodorderingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       final int image =getIntent().getIntExtra("image",0);
       final int price =Integer.parseInt(getIntent().getStringExtra("price"));
       final String name= getIntent().getStringExtra("name");
       final String description= getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.foodName.setText(name);
        binding.detailDescription.setText(description);

        final  DataBaseHelper helper=new DataBaseHelper(this);
        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               boolean isInserted = helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,

                        Integer.parseInt(binding.quantity.getText().toString())
                );
               if (isInserted){
                   Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();
               }

            }
        });


    }
}