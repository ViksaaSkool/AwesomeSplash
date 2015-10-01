package com.viksaa.ssspalsh.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.viksaa.ssspalsh.R;
import com.viksaa.ssspalsh.adapters.ColorAdapter;
import com.viksaa.ssspalsh.adapters.FontsAdapter;
import com.viksaa.ssspalsh.dialogfragment.ListDialogFragment;
import com.viksaa.ssspalsh.helpers.ChangeActivityHelper;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.ssspalsh.util.UIUtil;
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
    AppCompatSpinner mSpCircColor;
    @Bind(R.id.rgY)
    RadioGroup mRgY;
    @Bind(R.id.rgX)
    RadioGroup mRgX;
    @Bind(R.id.sbCircDuration)
    SeekBar mSbCircD;
    @Bind(R.id.txtCircDur)
    AppCompatTextView mCxtCircDur;
    @Bind(R.id.txtLogoTech)
    AppCompatTextView mtxtLogoTech;
    @Bind(R.id.txtLogoDur)
    AppCompatTextView mTxtLogoDur;
    @Bind(R.id.sbLogoDuration)
    SeekBar mSbLogoDur;
    @Bind(R.id.llAnimLogoTech)
    LinearLayout mLlAnimLogoTech;
    @Bind(R.id.crParent)
    CoordinatorLayout mCrParent;
    @Bind(R.id.spTitleFont)
    AppCompatSpinner mSpTitleFont;
    @Bind(R.id.spTitleColor)
    AppCompatSpinner mSpTitleColor;
    @Bind(R.id.spPathStrokeColor)
    AppCompatSpinner mSpPathStrokeColor;
    @Bind(R.id.spPathFillColor)
    AppCompatSpinner mSpPathFillColor;
    @Bind(R.id.txtPathDrawDur)
    AppCompatTextView mTxtPathDrawDur;
    @Bind(R.id.sbPathDrawDuration)
    SeekBar mSbPathDrawDuration;
    @Bind(R.id.txtPathFillDur)
    AppCompatTextView mTxtPathFillDur;
    @Bind(R.id.sbPathFillDuration)
    SeekBar mSbPathFillDuration;
    @Bind(R.id.txtTitleTech)
    AppCompatTextView mTxtTitleTech;
    @Bind(R.id.llAnimTitleTech)
    LinearLayout llAnimTitleTech;
    @Bind(R.id.etStrokeSize)
    AppCompatEditText mEtStrokeSize;
    @Bind(R.id.etTitle)
    AppCompatEditText mEtTitle;
    @Bind(R.id.etTitleSize)
    AppCompatEditText mEtTitleSize;
    @Bind(R.id.txtTitleDur)
    AppCompatTextView mTxtTitleDur;
    @Bind(R.id.sbTitleDuration)
    SeekBar mSbTitleDuration;

    private ConfigSplash mConfigSplash;
    private ColorAdapter mColorAdapter;
    private FontsAdapter mFontAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }


    public void init() {

        //Essential
        setSupportActionBar(mToolbar);
        mConfigSplash = new ConfigSplash();
        UIUtil.hideSoftKeyOutsideET(this, mCrParent);

        //Switch
        doSwitchCheck();

        //Colors
        mColorAdapter = new ColorAdapter(this);
        mSpCircColor.setAdapter(mColorAdapter);
        mSpPathStrokeColor.setAdapter(mColorAdapter);
        mSpPathStrokeColor.setSelection(9);
        mSpPathFillColor.setAdapter(mColorAdapter);
        mSpPathFillColor.setSelection(1);
        mSpTitleColor.setAdapter(mColorAdapter);
        mSpTitleColor.setSelection(9);

        //Fonts
        mFontAdapter = new FontsAdapter(this);
        mSpTitleFont.setAdapter(mFontAdapter);

        //RadioButtons
        mRgX.setOnCheckedChangeListener(this);
        mRgY.setOnCheckedChangeListener(this);

        //Durations
        String text = String.format(getString(R.string.circ_duration), Integer.toString(1000));
        String _text = String.format(getString(R.string.path_f_duration), Integer.toString(1000));
        String __text = String.format(getString(R.string.path_d_duration), Integer.toString(1000));
        mCxtCircDur.setText(text);
        mTxtLogoDur.setText(text);
        mTxtTitleDur.setText(text);
        mTxtPathFillDur.setText(_text);
        mTxtPathDrawDur.setText(__text);
        mSbTitleDuration.setOnSeekBarChangeListener(this);
        mSbPathDrawDuration.setOnSeekBarChangeListener(this);
        mSbCircD.setOnSeekBarChangeListener(this);
        mSbLogoDur.setOnSeekBarChangeListener(this);
        mSbPathFillDuration.setOnSeekBarChangeListener(this);


        //Animations
        mtxtLogoTech.setText("FadeInDown");
        mTxtTitleTech.setText("SlideInUp");
    }


    /* OnClicks */
    @OnClick(R.id.sLogoOrPath)
    public void onSwitchClick() {
        doSwitchCheck();
    }

    @OnClick(R.id.fabReady)
    public void onFabReady() {
        if (!mEtStrokeSize.getText().toString().isEmpty())
            mConfigSplash.setPathSplashStrokeSize(Integer.valueOf(mEtStrokeSize.getText().toString()));
        if (!mEtTitle.getText().toString().isEmpty())
            mConfigSplash.setTitleSplash(mEtTitle.getText().toString());
        if (!mEtTitleSize.getText().toString().isEmpty())
            mConfigSplash.setTitleTextSize(Float.valueOf(mEtTitleSize.getText().toString()));

        Bundle b = new Bundle();
        b.putSerializable(Constants.CONFIG, mConfigSplash);
        ChangeActivityHelper.changeActivity(this, SplashActivity.class, false, b);
    }

    @OnItemSelected(R.id.spCircColor)
    public void onCircColors(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setBackgroundColor(mColorAdapter.getColors().getResourceId(arg2, 0));
    }

    @OnItemSelected(R.id.spTitleColor)
    public void onTextColors(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setTitleTextColor(mColorAdapter.getColors().getResourceId(arg2, 0));
    }

    @OnItemSelected(R.id.spPathStrokeColor)
     public void onStrokeColors(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setPathSplashStrokeColor(mColorAdapter.getColors().getResourceId(arg2, 0));
    }

    @OnItemSelected(R.id.spPathFillColor)
    public void onFillColors(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setPathSplashFillColor(mColorAdapter.getColors().getResourceId(arg2, 0));
    }

    @OnItemSelected(R.id.spTitleFont)
    public void onFont(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        mConfigSplash.setTitleFont((String) mFontAdapter.getItem(arg2));
    }


    @OnClick(R.id.llAnimLogoTech)
    public void onLogoAnimTech() {
        ListDialogFragment.newInstance(Constants.FOR_LOGO).show(getSupportFragmentManager(), "listDialogFragment");
    }

    @OnClick(R.id.llAnimTitleTech)
    public void onTextAnimTech() {
        ListDialogFragment.newInstance(Constants.FOR_TEXT).show(getSupportFragmentManager(), "listDialogFragment");
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
        String text = String.format(getString(R.string.circ_duration), Integer.toString(duration));
        String _text = String.format(getString(R.string.path_f_duration), Integer.toString(duration));
        String __text = String.format(getString(R.string.path_d_duration), Integer.toString(duration));
        switch (seekBar.getId()) {
            case R.id.sbCircDuration:
                mCxtCircDur.setText(text);
                mConfigSplash.setAnimCircularRevealDuration(duration);
                break;
            case R.id.sbLogoDuration:
                mTxtLogoDur.setText(text);
                mConfigSplash.setAnimLogoSplashDuration(duration);
                break;
            case R.id.sbTitleDuration:
                mTxtTitleDur.setText(text);
                mConfigSplash.setAnimTitleDuration(duration);
                break;

            case R.id.sbPathDrawDuration:
                mTxtPathDrawDur.setText(__text);
                mConfigSplash.setAnimPathStrokeDrawingDuration(duration);
                break;

            case R.id.sbPathFillDuration:
                mTxtPathFillDur.setText(_text);
                mConfigSplash.setAnimPathFillingDuration(duration);
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
            mConfigSplash.setPathSplash(Constants.DROID_LOGO);
            mCvLogo.setVisibility(View.GONE);
            mCvPath.setVisibility(View.VISIBLE);
        } else {
            text = String.format(getString(R.string.logo_or_path), getString(R.string.logo));
            mConfigSplash.setPathSplash("");
            mConfigSplash.setLogoSplash(R.drawable.ic_splash);
            mCvLogo.setVisibility(View.VISIBLE);
            mCvPath.setVisibility(View.GONE);
        }
        mSLogoOrPath.setText(text);
    }

    public void doRadioGroupCheck(int flag) {
        if (flag == R.id.rgY) {
            if (mRgY.getCheckedRadioButtonId() == R.id.bottom) {
                mConfigSplash.setRevealFlagY(Flags.REVEAL_BOTTOM);
            } else {
                mConfigSplash.setRevealFlagY(Flags.REVEAL_TOP);
            }
        } else {
            if (mRgX.getCheckedRadioButtonId() == R.id.right) {
                mConfigSplash.setRevealFlagX(Flags.REVEAL_RIGHT);
            } else {
                mConfigSplash.setRevealFlagX(Flags.REVEAL_LEFT);
            }
        }
    }

    public void setTechnique(int flag, String tech) {
        if (flag == Constants.FOR_LOGO)
            mtxtLogoTech.setText(tech);
        else {
            mTxtTitleTech.setText(tech);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UIUtil.hideKeyboard(this);
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
