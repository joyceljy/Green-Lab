package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String password = getIntent().getStringExtra("password");
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String email = getIntent().getStringExtra("email");

        TextView messageView = findViewById(R.id.text_view_username2);
        messageView.setText(name);

        TextView messageView2 = findViewById(R.id.text_view_address2);
        messageView2.setText(address);

        TextView messageView3 = findViewById(R.id.text_view_email2);
        messageView3.setText(email);
    }
}