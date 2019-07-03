package com.demo.recycleviewdeatils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        " 1.Apple",
                        "This brand name has conquered all the other brands in the field of technology.",
                        R.drawable.macbook));

        productList.add(
                new Product(
                        1,
                        "2.Sony",
                        "Sony is a renowned electronic manufacturer,",
                        R.drawable.dellinspiron));

        productList.add(
                new Product(
                        1,
                        "3.HP",
                        "HP is the name of innovation in the world of laptops.",
                        R.drawable.hp));
        productList.add(
                new Product(
                        1,
                        "4.Dell",
                        "Dell is the most popular brand worldwide.",
                        R.drawable.dell));

        productList.add(
                new Product(
                        1,
                        "5.Samsung",
                        "Samsung is one of the leaders in the global market of high-tech electronics and digital media.",
                        R.drawable.sam));

        productList.add(
                new Product(
                        1,
                        "6.Lenovo",
                        "Lenovo is ideally a Chinese brand but its operations go all the way to the USA.",
                        R.drawable.len));

        productList.add(
                new Product(
                        1,
                        "7.ASUS",
                        "ASUS is an Asian brand which is popular in the world",
                        R.drawable.surface));

        productList.add(
                new Product(
                        1,
                        "8.Acer",
                        "Customers looking for aesthetic value and sophistication tend to go for Acer laptops",
                        R.drawable.ac));

        productList.add(
                new Product(
                        1,
                        "9.Toshiba",
                        "Customers worldwide agree that it may not offer top notch functionality.",
                        R.drawable.to));

        productList.add(
                new Product(
                        1,
                        "10.Msi",
                        "Micro-Star International is one of the best and least popular laptop brands.",
                        R.drawable.msi));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
