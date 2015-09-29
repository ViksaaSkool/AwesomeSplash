package com.viksaa.ssspalsh.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import com.viksaa.ssspalsh.R;

/**
 * Created by varsovski on 29-Sep-15.
 */
public class ColorAdapter extends BaseAdapter {

    private Context mContext;
    private TypedArray mColors;

    public ColorAdapter(Context context) {
        mContext = context;
        mColors = mContext.getResources().obtainTypedArray(R.array.colors);
    }

    @Override
    public int getCount() {
        return mColors.length();
    }

    @Override
    public Object getItem(int position) {
        return mColors.getIndex(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.clr, null, false);
        RelativeLayout t = (RelativeLayout) v.findViewById(R.id.rlColor);
        t.setBackgroundColor(mContext.getResources().getColor(mColors.getResourceId(position, 0)));
        return v;
    }

    public TypedArray getColors() {
        return mColors;
    }
}
