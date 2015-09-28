package com.viksaa.ssspalsh.activity;

import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

/**
 * Created by varsovski on 28-Sep-15.
 */
public class SplashActivity extends AwesomeSplash {


    @Override
    public void initSplash(ConfigSplash configSplash) {
        configSplash.setOriginalHeight(400);
        configSplash.setOriginalWidth(400);
        configSplash.setLogoSplashPath(Constants.DROID_LOGO);

        configSplash.setFont("fonts/streatwear.otf");
        configSplash.setTextSize(20f);

    }

    @Override
    public void animationsFinished() {

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
