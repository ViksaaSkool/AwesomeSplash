package com.viksaa.ssspalsh.activity;

import android.app.Activity;

import com.badoo.mobile.util.WeakHandler;
import com.viksaa.ssspalsh.R;
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
        configSplash.setBackgroundColor(R.color.primary);

        configSplash.setOriginalHeight(400);
        configSplash.setOriginalWidth(400);
        configSplash.setLogoSplashPath(Constants.DROID_LOGO);
        configSplash.setFillColor(R.color.accent);

        configSplash.setFont(Constants.SLIMJIM_FONT);
        configSplash.setTextSize(20f);

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


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ChangeActivityHelper.changeActivity(this, MainActivity.class, true);
    }
}
