package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VideoSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_selection);

        ListView lv = (ListView) findViewById(R.id.listview_videolist);

        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("video1");
        your_array_list.add("video2");
        your_array_list.add("video3");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
            String selected_item = String.valueOf(adapterView.getItemAtPosition(i));

            intent.putExtra("selectedVideo", selected_item);
            startActivity(intent);
        });


    }
}