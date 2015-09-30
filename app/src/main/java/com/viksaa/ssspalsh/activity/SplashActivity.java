package com.viksaa.ssspalsh.activity;

import android.app.Activity;

import com.badoo.mobile.util.WeakHandler;
import com.viksaa.ssspalsh.helpers.ChangeActivityHelper;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by varsovski on 28-Sep-15.
 */
public class SplashActivity extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {
        getAndSetSplashValues(configSplash);
    }

    @Override
    public void animationsFinished() {
        //wait 5 sec and then go back to MainActivity
        final Activity a = this;
        WeakHandler handler = new WeakHandler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ChangeActivityHelper.changeActivity(a, MainActivity.class, true);
            }
        }, Constants.SPLASH_DELAY);
    }


    public void getAndSetSplashValues(ConfigSplash cs1) {
        ConfigSplash cs2 = (ConfigSplash) getIntent().getExtras().getSerializable(Constants.CONFIG);
        if (cs2 != null) {
            cs1.setAnimCircularRevealDuration(cs2.getAnimCircularRevealDuration());
            cs1.setRevealFlagX(cs2.getRevealFlagX());
            cs1.setRevealFlagY(cs2.getRevealFlagY());
            cs1.setBackgroundColor(cs2.getBackgroundColor());

            cs1.setLogoSplash(cs2.getLogoSplash());
            cs1.setAnimLogoTechn(cs2.getAnimLogoTechn());
            cs1.setAnimLogoSplashDuration(cs2.getAnimLogoSplashDuration());

            cs1.setLogoSplashPath(cs2.getLogoSplashPath());
            cs1.setStrokeSize(cs2.getStrokeSize());
            cs1.setStrokeColor(cs2.getStrokeColor());
            cs1.setFillColor(cs2.getFillColor());
            cs1.setOriginalHeight(cs2.getOriginalHeight());
            cs1.setOriginalWidth(cs2.getOriginalWidth());
            cs1.setAnimPathStrokeDrawing(cs2.getAnimPathStrokeDrawing());
            cs1.setAnimPathFilling(cs2.getAnimPathFilling());

            cs1.setTextSplash(cs2.getTextSplash());
            cs1.setAnimTextDuration(cs2.getAnimTextDuration());
            cs1.setAnimTextTechn(cs2.getAnimTextTechn());
            cs1.setTextSize(cs2.getTextSize());
            cs1.setTextColor(cs2.getTextColor());
            cs1.setFont(cs2.getFont());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ChangeActivityHelper.changeActivity(this, MainActivity.class, true);
    }
}
