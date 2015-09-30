package com.viksaa.ssspalsh.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.viksaa.ssspalsh.R;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.ssspalsh.util.UIUtil;

/**
 * Created by varsovski on 29-Sep-15.
 */
public class FontsAdapter extends BaseAdapter {

    private Context mContext;

    public FontsAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return Constants.FONTS.length;
    }

    @Override
    public Object getItem(int position) {
        return Constants.FONTS[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fnt_item, null, false);
        TextView t = (TextView) v.findViewById(R.id.font_item_text);
        String name = "";
        if (position != 0)
            name = UIUtil.getFontTitle(Constants.FONTS[position]);
        t.setText(name);
        //v.setTag(Techniques.values()[position]);
        return v;
    }
}
