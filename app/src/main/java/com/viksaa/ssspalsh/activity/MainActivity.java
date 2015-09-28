package com.viksaa.ssspalsh.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.viksaa.ssspalsh.R;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class MainActivity extends AppCompatActivity {


    private ConfigSplash configSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = new Bundle();
        ConfigSplash cs = new ConfigSplash();
        b.putSerializable("", cs);
    }


    public void navigationAndToolbarSetuUp() {
        /*setSupportActionBar(mTlBar);
        //mActionBar = getSupportActionBar();
        getSupportActionBar().setIcon(R.drawable.ic_al_white);
        getSupportActionBar().setTitle(Static.EMPTY);*/

    }


    public void init(){
        configSplash = new ConfigSplash();
    }
}
