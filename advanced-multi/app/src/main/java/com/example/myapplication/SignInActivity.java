package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class SignInActivity extends AppCompatActivity {

    Button send_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        send_button = findViewById(R.id.signin_btn3);

        send_button.setOnClickListener(v -> {
            EditText password1 = findViewById(R.id.editTextTextPassword);
            EditText username = findViewById(R.id.name_in_text3);

            String enteredPassword = password1.getText().toString();
            String enteredName = username.getText().toString();

            String password = getIntent().getStringExtra("password");
            String name = getIntent().getStringExtra("name");
            String address = getIntent().getStringExtra("address");
            String email = getIntent().getStringExtra("email");
            String phone = getIntent().getStringExtra("phone");
            String gender = getIntent().getStringExtra("gender");

            if (Objects.equals(password, enteredPassword) && enteredName.equals(name)) {
                // Create the Intent object of this class Context() to Second_activity class
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                // now by putExtra method put the value in key, value pair key is
                // message_key by this key we will receive the value, and put the string
                intent.putExtra("password", password);
                intent.putExtra("name", name);
                intent.putExtra("address", address);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("gender", gender);
                // start the Intent
                startActivity(intent);
            } else {
                Toast.makeText(this, "Username or Password Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}