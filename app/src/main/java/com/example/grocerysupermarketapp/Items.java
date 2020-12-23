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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
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


    ArrayList<String> item = new ArrayList<>();
    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    ArrayList<String> image = new ArrayList<>();
    ArrayList<String> category = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);
rc1 = findViewById(R.id.recyclerView);

try {
            JSONObject obj = new JSONObject(loadJSONfromAssets());

            //fetching
            JSONArray GroceryArray = obj.getJSONArray("users");

            //loop

            for (int i = 0; i < GroceryArray.length(); i++)
            {
                //craeting json obj for fetching single data
                JSONObject Grocerydetail = GroceryArray.getJSONObject(i);

                item.add(Grocerydetail.getString("item"));
                price.add(Grocerydetail.getString("price"));
                description.add(Grocerydetail.getString("descript"));
                image.add(Grocerydetail.getString("Image"));
            }
    adp1 = new Adapter1(this, item, price, description, image);
    rc1.setLayoutManager(new LinearLayoutManager(this));
    rc1.setAdapter(adp1);

}
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private String loadJSONfromAssets() {
        String json = null;
        try {
            InputStream is = getAssets().open("m9gpz-5hhao.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
return json;
    }


}