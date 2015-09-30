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
            cs1.setAnimLogoSplashTechnique(cs2.getAnimLogoSplashTechnique());
            cs1.setAnimLogoSplashDuration(cs2.getAnimLogoSplashDuration());

            cs1.setPathSplash(cs2.getPathSplash());
            cs1.setPathSplashStrokeSize(cs2.getPathSplashStrokeSize());
            cs1.setPathSplashStrokeColor(cs2.getPathSplashStrokeColor());
            cs1.setPathSplashFillColor(cs2.getPathSplashFillColor());
            cs1.setOriginalHeight(cs2.getOriginalHeight());
            cs1.setOriginalWidth(cs2.getOriginalWidth());
            cs1.setAnimPathStrokeDrawingDuration(cs2.getAnimPathStrokeDrawingDuration());
            cs1.setAnimPathFillingDuration(cs2.getAnimPathFillingDuration());

            cs1.setTitleSplash(cs2.getTitleSplash());
            cs1.setAnimTitleDuration(cs2.getAnimTitleDuration());
            cs1.setAnimTitleTechnique(cs2.getAnimTitleTechnique());
            cs1.setTitleTextSize(cs2.getTitleTextSize());
            cs1.setTitleTextColor(cs2.getTitleTextColor());
            cs1.setTitleFont(cs2.getTitleFont());
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ChangeActivityHelper.changeActivity(this, MainActivity.class, true);
    }
}
