package com.coursera.unam.w423project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verLugar(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(getString(R.string.key_lugar), view.getId());

        startActivity(intent);
    }
}