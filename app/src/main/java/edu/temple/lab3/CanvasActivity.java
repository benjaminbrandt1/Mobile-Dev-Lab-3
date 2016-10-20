package edu.temple.lab3;

import android.content.Intent;
import android.content.res.Resources;
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

        String colors[] = {"--Select One --", "blue", "green", "magenta", "cyan", "red"};
        Intent myIntent = getIntent();
        String color = myIntent.getStringExtra("color");
        int pointer = Integer.parseInt(color);

        Resources res = CanvasActivity.this.getResources();
        String[] colorLabels = res.getStringArray(R.array.colors);

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
        layout.setBackgroundColor(Color.parseColor(colors[pointer]));
        getSupportActionBar().setTitle(colorLabels[pointer].toUpperCase());
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(colors[pointer])));

    }
}
