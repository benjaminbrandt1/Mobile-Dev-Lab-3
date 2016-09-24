package edu.temple.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);
        Intent myIntent = getIntent();
        String color = myIntent.getStringExtra("color");
        Toast.makeText(CanvasActivity.this, color, Toast.LENGTH_SHORT).show();
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(color));
        getSupportActionBar().setTitle(color.toUpperCase());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(color)));

    }
}
