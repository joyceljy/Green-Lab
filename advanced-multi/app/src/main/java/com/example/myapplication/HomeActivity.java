package com.example.myapplication;

import static com.example.myapplication.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements LocationListener {

    Button sendButton;
    Button videoButton;
    private final int locationPermissionCode = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_home);

        sendButton = findViewById(id.button_location);

        sendButton.setOnClickListener(v -> {
            getLocation();
        });

        videoButton = findViewById(id.button_video);

        videoButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), VideoSelectionActivity.class);
                // start the Intent
            startActivity(intent);
        });

        String password = getIntent().getStringExtra("password");
        String name = getIntent().getStringExtra("name");
        String address = getIntent().getStringExtra("address");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String gender = getIntent().getStringExtra("gender");

        TextView messageView = findViewById(id.text_view_username2);
        messageView.setText(name);

        TextView messageView2 = findViewById(id.text_view_address2);
        messageView2.setText(address);

        TextView messageView3 = findViewById(id.text_view_email2);
        messageView3.setText(email);

        TextView messageView4 = findViewById(id.text_view_phone);
        messageView4.setText(phone);

        TextView messageView5 = findViewById(id.text_view_gender);
        messageView5.setText(gender);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        String tvGpsLocation = "Your current location:\n Latitude: " + location.getLatitude() + " , Longitude: " + location.getLongitude();
        TextView viewLocation = findViewById(id.text_view_location);
        viewLocation.setText(tvGpsLocation);
    }

    private void getLocation() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, locationPermissionCode);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this);
    }
    private void onRequestPermissionsResult(int requestCode, ArrayList<String> permissions, ArrayList<Integer> grantResults) {
        if (requestCode == locationPermissionCode) {
            if (!grantResults.isEmpty() && grantResults.get(0) == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}