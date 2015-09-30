package com.viksaa.ssspalsh.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
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
         String _font = font.substring(font.indexOf("/") + 1, font.indexOf("."));
        _font = _font.substring(0, 1).toUpperCase() + _font.substring(1).toLowerCase();
        _font = _font.replace("_", " ");
        return _font;
    }

    public static String getTechniqueTitle(Object o) {
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        return o.getClass().getName().substring(start);
    }

    public static void hideKeyboard(Activity ba) {
        // Check if no view has focus:
        View view = ba.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) ba.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public static void hideSoftKeyOutsideET(final Activity a, View view) {

        // if the view is not instance of AutoResizeEditText
        // i.e. if the user taps outside of the box
        if (!(view instanceof AppCompatEditText)) {

            view.setOnTouchListener(new View.OnTouchListener() {

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    //hide the keyboard
                    hideKeyboard(a);
                    return false;
                }
            });
        }
        // If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                hideSoftKeyOutsideET(a, innerView);
            }
        }
    }

    public static int getToolbarHeight(Context c) {
        /* this TypedArray should be recycled!!! */
        final TypedArray styledAttributes = c.getTheme().obtainStyledAttributes(new int[]{android.R.attr.actionBarSize});
        return (int) styledAttributes.getDimension(0, 0);
    }

}
