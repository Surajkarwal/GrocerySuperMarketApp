package com.example.grocerysupermarketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    String _postalCode;
    TextInputEditText postalCode;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postalCode = findViewById(R.id.postalCode);
        confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check the postal code is valid and send further to get results
                checkAndSendPC(postalCode.getText().toString());
            }
        });

    }

    private void checkAndSendPC(String pc) {
        Toast.makeText(this, "" + pc, Toast.LENGTH_SHORT).show();
    }
}