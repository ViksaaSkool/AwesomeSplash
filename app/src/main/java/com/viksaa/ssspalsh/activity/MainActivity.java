package com.viksaa.ssspalsh.activity;

import android.util.Log;
import android.widget.Toast;

import com.viksaa.ssspalsh.R;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AwesomeSplash {



    @Override
    public void initSplash(ConfigSplash configSplash){
        configSplash.setLogoSplash(R.mipmap.ic_launcher);
    }



    @Override
    public void animationsFinished() {
        Log.d("", "");
        Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show();
    }


}
