package edu.temple.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        String[] colors = new String[6];
        colors[0] = "-- Select One --";
        colors[1] = "blue";
        colors[2] = "green";
        colors[3] = "magenta";
        colors[4] = "cyan";
        colors[5] = "red";

        Spinner spinner = (Spinner)findViewById(R.id.colorSpinner);

        ColorAdapter adapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).toString().equals("-- Select One --")){

                } else {
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("color", parent.getItemAtPosition(position).toString());
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}
