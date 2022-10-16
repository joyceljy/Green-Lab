package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    Button send_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        send_button = findViewById(R.id.signup_btn2);

        send_button.setOnClickListener(v -> {
            EditText password1 = findViewById(R.id.password_up_text);
            EditText name1 = findViewById(R.id.name_up_text);
            EditText address1 = findViewById(R.id.address_text);
            EditText email1 = findViewById(R.id.email_text);

            String password = password1.getText().toString();
            String name = name1.getText().toString();
            String address = address1.getText().toString();
            String email = email1.getText().toString();
            // Create the Intent object of this class Context() to Second_activity class
            Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
            // now by putExtra method put the value in key, value pair key is
            // message_key by this key we will receive the value, and put the string
            intent.putExtra("password", password);
            intent.putExtra("name", name);
            intent.putExtra("address", address);
            intent.putExtra("email", email);
            // start the Intent
            startActivity(intent);
        });
    }
}