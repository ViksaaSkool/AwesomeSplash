package com.viksaa.ssspalsh.activity;

import android.util.Log;
import android.widget.Toast;

import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AwesomeSplash {



    @Override
    public void initSplash(ConfigSplash configSplash){
        configSplash.setLogoSplashPath(Constants.LOGO_PATH);
    }



    @Override
    public void animationsFinished() {
        Log.d("", "");
        Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
    }


}
