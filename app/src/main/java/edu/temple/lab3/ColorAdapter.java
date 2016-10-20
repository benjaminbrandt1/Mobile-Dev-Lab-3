package edu.temple.lab3;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ben on 9/22/2016.
 */

public class ColorAdapter extends BaseAdapter {
    private Context mContext;
    private final String[] colors;
    String realColors[] = {"--Select One --", "blue", "green", "magenta", "cyan", "red"};

    public ColorAdapter(Context c, String[] colors){
        mContext = c;
        this.colors = colors;
    }

    @Override
    public int getCount(){
        return colors.length;
    }

    @Override
    public String getItem(int position){
        return colors[position];

    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View oldView, ViewGroup parent){
        LinearLayout layout;

        if(oldView!=null) {
            layout = (LinearLayout) oldView;
        } else {
            layout = new LinearLayout(mContext);
        }

        TextView color = new TextView(mContext);
        color.setText(colors[position]);
        try {
            color.setBackgroundColor(Color.parseColor(realColors[position]));
        } catch (Exception e) {
            color.setBackgroundColor(Color.WHITE);
        }
        color.setTextSize(32);

        layout.addView(color);
        return layout;

    }


}
