package edu.temple.lab3;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class PaletteFragment extends Fragment {
    String[] colorLabels;
    ColorAdapter adapter;
    ColorChangeInterface activity;



    public static PaletteFragment newInstance() {
        return new PaletteFragment();
    }

    public PaletteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //Make sure the activity implements ColorChangeInterface
        try {
            this.activity = (ColorChangeInterface)activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement ColorChangeInterface");
        }
        //Get the array of colors and create an adapter
        Resources res = PaletteFragment.this.getResources();
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

        final Spinner spinner = (Spinner)v.findViewById(R.id.colorSpinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){

                } else {
                    spinner.setSelection(0);
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
        void changeColor(int colorPosition);

    }


}
