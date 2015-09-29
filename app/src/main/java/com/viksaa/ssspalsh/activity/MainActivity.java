package com.viksaa.ssspalsh.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.viksaa.ssspalsh.R;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.sLogoOrPath)
    SwitchCompat mSLogoOrPath;
    @Bind(R.id.cvLogo)
    CardView mCvLogo;
    @Bind(R.id.cvPath)
    CardView mCvPath;
    private ConfigSplash mConfigSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*Bundle b = new Bundle();
        ConfigSplash cs = new ConfigSplash();
        b.putSerializable("", cs);*/

        init();
    }


    public void init() {
        setSupportActionBar(mToolbar);
        mConfigSplash = new ConfigSplash();

        doSwitchCheck();


        //ListDialogFragment.newInstance(Constants.FOR_LOGO).show(getSupportFragmentManager(), "listDialogFragment");
    }


    /* Onclicks */
    @OnClick(R.id.sLogoOrPath)
    public void onSwitchClick(){
        doSwitchCheck();
    }


    public void doSwitchCheck(){
        String text = "";
        if(mSLogoOrPath.isChecked()){
            text = String.format(getString(R.string.logo_or_path),getString(R.string.path));
            mConfigSplash.setLogoSplashPath(Constants.DROID_LOGO);
            mCvLogo.setVisibility(View.GONE);
            mCvPath.setVisibility(View.VISIBLE);
        }
        else {
            text = String.format(getString(R.string.logo_or_path),getString(R.string.logo));
            mConfigSplash.setLogoSplashPath("");
            mConfigSplash.setLogoSplash(R.mipmap.ic_launcher);
            mCvLogo.setVisibility(View.VISIBLE);
            mCvPath.setVisibility(View.GONE);
        }
        mSLogoOrPath.setText(text);
    }

    /* Getters and Setters */
    public ConfigSplash getConfigSplash() {
        return mConfigSplash;
    }

    public void setConfigSplash(ConfigSplash mConfigSplash) {
        this.mConfigSplash = mConfigSplash;
    }
}
