package com.viksaa.ssspalsh.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.viksaa.ssspalsh.R;
import com.viksaa.ssspalsh.adapters.ColorAdapter;
import com.viksaa.ssspalsh.helpers.ChangeActivityHelper;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.sLogoOrPath)
    SwitchCompat mSLogoOrPath;
    @Bind(R.id.cvLogo)
    CardView mCvLogo;
    @Bind(R.id.cvPath)
    CardView mCvPath;
    @Bind(R.id.fabReady)
    FloatingActionButton mFabReady;
    @Bind(R.id.spCircColor)
    AppCompatSpinner mCpCircColor;
    @Bind(R.id.rgY)
    RadioGroup mRgY;
    @Bind(R.id.rgX)
    RadioGroup mRgX;
    @Bind(R.id.sbCircDuration)
    SeekBar mSbCircD;
    @Bind(R.id.txtCircDur)
    AppCompatTextView mCxtCircDur;

    private ConfigSplash mConfigSplash;
    private ColorAdapter mCircColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }


    public void init() {
        setSupportActionBar(mToolbar);
        mConfigSplash = new ConfigSplash();

        doSwitchCheck();

        mCircColor = new ColorAdapter(this);
        mCpCircColor.setAdapter(mCircColor);

        mRgX.setOnCheckedChangeListener(this);
        mRgY.setOnCheckedChangeListener(this);

        mSbCircD.setOnSeekBarChangeListener(this);
        String text = String.format(getString(R.string.circ_duration), Integer.toString(1000));
        mCxtCircDur.setText(text);


        //ListDialogFragment.newInstance(Constants.FOR_LOGO).show(getSupportFragmentManager(), "listDialogFragment");
    }


    /* OnClicks */
    @OnClick(R.id.sLogoOrPath)
    public void onSwitchClick() {
        doSwitchCheck();
    }

    @OnClick(R.id.fabReady)
    public void onFabReady() {
        Bundle b = new Bundle();
        b.putSerializable(Constants.CONFIG, mConfigSplash);
        ChangeActivityHelper.changeActivity(this, SplashActivity.class, false, b);
    }

    @OnItemSelected(R.id.spCircColor)
    public void onCircColors(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setBackgroundColor(mCircColor.getColors().getResourceId(arg2, 0));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int progressChanged = progress / 10;
        int duration = 1000;
        int bonus = 0;

        if (progressChanged == 0)
            bonus = 1000;
        if (progressChanged == 1)
            bonus = 500;

        duration *= progressChanged;
        duration += bonus;
        String text = "";
        switch (seekBar.getId()) {
            case R.id.sbCircDuration:
                text = String.format(getString(R.string.circ_duration), Integer.toString(duration));
                mCxtCircDur.setText(text);
                Log.d("SP", text);
                mConfigSplash.setAnimCircularRevealDuration(duration);
                break;

            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        doRadioGroupCheck(group.getId());
    }

    /* Helper methods */
    public void doSwitchCheck() {
        String text = "";
        if (mSLogoOrPath.isChecked()) {
            text = String.format(getString(R.string.logo_or_path), getString(R.string.path));
            mConfigSplash.setLogoSplashPath(Constants.DROID_LOGO);
            mCvLogo.setVisibility(View.GONE);
            mCvPath.setVisibility(View.VISIBLE);
        } else {
            text = String.format(getString(R.string.logo_or_path), getString(R.string.logo));
            mConfigSplash.setLogoSplashPath("");
            mConfigSplash.setLogoSplash(R.mipmap.ic_launcher);
            mCvLogo.setVisibility(View.VISIBLE);
            mCvPath.setVisibility(View.GONE);
        }
        mSLogoOrPath.setText(text);
    }

    public void doRadioGroupCheck(int flag) {
        if (flag == R.id.rgY) {
            if (mRgY.getCheckedRadioButtonId() == R.id.bottom) {
                mConfigSplash.setRevealFlagX(Flags.R_BOTTOM);
            } else {
                mConfigSplash.setRevealFlagX(Flags.R_TOP);
            }
        } else {
            if (mRgX.getCheckedRadioButtonId() == R.id.right) {
                mConfigSplash.setRevealFlagY(Flags.R_RIGHT);
            } else {
                mConfigSplash.setRevealFlagY(Flags.R_LEFT);
            }
        }
    }

    /* Getters and Setters */
    public ConfigSplash getConfigSplash() {
        return mConfigSplash;
    }

    public void setConfigSplash(ConfigSplash mConfigSplash) {
        this.mConfigSplash = mConfigSplash;
    }


    /* Unused */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
