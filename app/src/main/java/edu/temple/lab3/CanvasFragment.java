package edu.temple.lab3;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


public class CanvasFragment extends Fragment {
    RelativeLayout layout;
    String[] colors;

    public static CanvasFragment newInstance() {
        return new CanvasFragment();
    }

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_canvas, container, false);

        colors = new String[]{"--Select One --", "blue", "green", "magenta", "cyan", "red"};

        layout = (RelativeLayout)v.findViewById(R.id.layout);

        return v;
    }

    public void changeColor(int pointer){
        try{
            layout.setBackgroundColor(Color.parseColor(colors[pointer]));
        } catch (NullPointerException e){

        }
    }



}
