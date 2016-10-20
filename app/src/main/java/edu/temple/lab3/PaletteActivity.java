package edu.temple.lab3;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class PaletteActivity extends Fragment {
    String[] colorLabels;
    ColorAdapter adapter;
    ColorChangeInterface activity;



    public static PaletteActivity newInstance() {
        return new PaletteActivity();
    }

    public PaletteActivity() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (ColorChangeInterface)activity;
        Resources res = PaletteActivity.this.getResources();
        colorLabels = res.getStringArray(R.array.colors);
        adapter = new ColorAdapter(activity, colorLabels);
    }

    @Override
    public void onDetach(){
        super.onDetach();
        activity = null;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_palette, container, false);

        Spinner spinner = (Spinner)v.findViewById(R.id.colorSpinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                } else {
                    activity.changeColor(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return v;
    }

    public interface ColorChangeInterface{
        public void changeColor(int colorPosition);

    }


}
