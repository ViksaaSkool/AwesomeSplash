package com.viksaa.ssspalsh.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by varsovski on 28-Sep-15.
 */
public class UIUtil {

    public static void setFont(Activity a, TextView txtView, String font) {
        Typeface type = Typeface.createFromAsset(a.getAssets(), font);
        txtView.setTypeface(type);
    }

    public static String getFontTitle(String font) {
        String _font = font.substring(font.indexOf("/"), font.indexOf("."));
        _font = _font.substring(0,1).toUpperCase() + _font.substring(1).toLowerCase();
        _font = _font.replace("_", " ");
        return _font;
    }

    public static String getTechniqueTitle(Object o){
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        return o.getClass().getName().substring(start);
    }

    public static int getToolbarHeight(Context c){
        final TypedArray styledAttributes = c.getTheme().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        return (int) styledAttributes.getDimension(0, 0);
    }

}
