package com.example.grocerysupermarketapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class Items extends AppCompatActivity {
    RecyclerView rc1;
    Adapter1 adp1;
    AsyncHttpClient client;
    //item , price, desc, category, image
    List<String> item,price,description,category,image;

    Workbook workboo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);


        String url = "https://github.com/Surajkarwal/GrocerySuperMarketApp/blob/master/grocery.xls";


//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        rc1 = findViewById(R.id.recyclerView);


item = new ArrayList<>();
description = new ArrayList<>();
price = new ArrayList<>();
category = new ArrayList<>();
image = new ArrayList<>();




client = new AsyncHttpClient();
    client.get(url, new FileAsyncHttpResponseHandler(this) {
        @Override
        public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
            Toast.makeText(Items.this, "Failes to load the xml file", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, File file) {

            Toast.makeText(Items.this, "File is loaded", Toast.LENGTH_SHORT).show();
            WorkbookSettings wb = new WorkbookSettings();
            wb.setGCDisabled(true);
            if(file != null)
            {
                try {
                    workboo = Workbook.getWorkbook(file);
                    Sheet sheet = workboo.getSheet(0);
                    for (int i = 0 ;i < sheet.getRows() ; i++)
                    {
Cell[] row = sheet.getRow(i);
item.add(row[1].getContents());

price.add(row[2].getContents());
                        description.add(row[3].getContents());

category.add(row[4].getContents());

                        image.add(row[5].getContents());


                    }
                    Showdata();
                    Log.d("TAG","sucess"+item);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }

            }
        }
    });
    }
    private void Showdata()
    {
        adp1 = new Adapter1(this,item,price,description,image);
        rc1.setLayoutManager(new LinearLayoutManager(this));
        rc1.setAdapter(adp1) ;


    }
}