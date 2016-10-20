package edu.temple.lab3;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PaletteActivity.ColorChangeInterface {
    CanvasActivity canvasActivity;
    PaletteActivity paletteActivity;
    boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPane = (findViewById(R.id.fragment_canvas) != null);
        canvasActivity = CanvasActivity.newInstance();
        paletteActivity = PaletteActivity.newInstance();

        load(paletteActivity, R.id.fragment_palette, false);


        /*
         *  Check if details pain is visible in current layout (e.g. large or landscape)
         *  and load fragment if true.
         */
        if (twoPane){
            load(canvasActivity, R.id.fragment_canvas, false);
        }
    }

    private void load(Fragment fragment, int panelId, boolean addToBackStack){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(panelId, fragment);
        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
        fragmentManager.executePendingTransactions();
    }

    @Override
    public void changeColor(int colorPosition){
        if(twoPane) {
            canvasActivity.changeColor(colorPosition);
        } else {
            load(canvasActivity, R.id.fragment_palette, true);
            canvasActivity.changeColor(colorPosition);
        }
    }
}
