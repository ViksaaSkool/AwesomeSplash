package com.viksaa.sssplash.lib.model;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.R;
import com.viksaa.sssplash.lib.cnst.Defaults;
import com.viksaa.sssplash.lib.cnst.Flags;

import java.io.Serializable;

/**
 * Created by varsovski on 25-Sep-15.
 */
public class ConfigSplash implements Serializable {


    //Circular Reveal
    private int animCircularRevealDuration;
    private int revealFlagX;
    private int revealFlagY;
    private int backgroundColor;

    //Img Logo
    private int logoSplash;
    private Techniques animLogoTechn;
    private int animLogoSplashDuration;

    //Path Logo
    private String logoSplashPath;
    private int strokeSize;
    private int strokeColor;
    private int fillColor;
    private int originalHeight;
    private int originalWidth;
    private int animPathStrokeDrawing;
    private int animPathFilling;

    //Text
    private String textSplash;
    private String font;
    private int animTextDuration;
    private Techniques animTextTechn;
    private float textSize;
    private int textColor;

    //Getters and Setters

    public int getFillColor() {
        return fillColor;
    }

    public void setFillColor(int fillColor) {
        this.fillColor = fillColor;
    }

    public int getStrokeSize() {
        return strokeSize;
    }

    public void setStrokeSize(int strokeSize) {
        this.strokeSize = strokeSize;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public int getOriginalHeight() {
        return originalHeight;
    }

    public void setOriginalHeight(int originalHeight) {
        this.originalHeight = originalHeight;
    }

    public int getOriginalWidth() {
        return originalWidth;
    }

    public void setOriginalWidth(int originalWidth) {
        this.originalWidth = originalWidth;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public Techniques getAnimLogoTechn() {
        return animLogoTechn;
    }

    public void setAnimLogoTechn(Techniques animLogoTechn) {
        this.animLogoTechn = animLogoTechn;
    }


    public int getAnimCircularRevealDuration() {
        return animCircularRevealDuration;
    }

    public void setAnimCircularRevealDuration(int animCircularRevealDuration) {
        this.animCircularRevealDuration = animCircularRevealDuration;
    }


    public int getLogoSplash() {
        return logoSplash;
    }

    public void setLogoSplash(int logoSplash) {
        this.logoSplash = logoSplash;
    }

    public String getLogoSplashPath() {
        return logoSplashPath;
    }

    public void setLogoSplashPath(String logoSplashPath) {
        this.logoSplashPath = logoSplashPath;
    }

    public int getAnimLogoSplashDuration() {
        return animLogoSplashDuration;
    }

    public void setAnimLogoSplashDuration(int animLogoSplashDuration) {
        this.animLogoSplashDuration = animLogoSplashDuration;
    }

    public String getTextSplash() {
        return textSplash;
    }

    public void setTextSplash(String textSplash) {
        this.textSplash = textSplash;
    }

    public int getAnimTextDuration() {
        return animTextDuration;
    }

    public void setAnimTextDuration(int animTextDuration) {
        this.animTextDuration = animTextDuration;
    }

    public Techniques getAnimTextTechn() {
        return animTextTechn;
    }

    public void setAnimTextTechn(Techniques animTextTechn) {
        this.animTextTechn = animTextTechn;
    }


    public int getRevealFlagX() {
        return revealFlagX;
    }

    public void setRevealFlagX(int revealFlagX) {
        this.revealFlagX = revealFlagX;
    }

    public int getRevealFlagY() {
        return revealFlagY;
    }

    public void setRevealFlagY(int revealFlagY) {
        this.revealFlagY = revealFlagY;
    }

    public int getAnimPathStrokeDrawing() {
        return animPathStrokeDrawing;
    }

    public void setAnimPathStrokeDrawing(int animPathStrokeDrawing) {
        this.animPathStrokeDrawing = animPathStrokeDrawing;
    }

    public int getAnimPathFilling() {
        return animPathFilling;
    }

    public void setAnimPathFilling(int animPathFilling) {
        this.animPathFilling = animPathFilling;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public ConfigSplash() {
        initDefaults();
    }

    public void initDefaults() {
        this.animCircularRevealDuration = Defaults.ANIM_REVEAL;
        this.revealFlagX = Flags.R_BOTTOM;
        this.revealFlagY = Flags.R_RIGHT;
        this.backgroundColor = R.color.bckg;

        //Img Logo
        this.logoSplash = android.R.mipmap.sym_def_app_icon;
        this.animLogoTechn = Techniques.FadeInDown;
        this.animLogoSplashDuration = Defaults.ANIM_LOGO;

        //Path Logo
        this.logoSplashPath = Defaults.EMPTY;
        this.strokeSize = Defaults.STROKE_WIDTH;
        this.strokeColor = android.R.color.white;
        this.fillColor = R.color.filn;
        this.originalHeight = Defaults.ORIGINAL_HEIGHT;
        this.originalWidth = Defaults.ORIGINAL_WIDTH;
        this.animPathStrokeDrawing = Defaults.ANIM_DRAWING;
        this.animPathFilling = Defaults.ANIM_FILLING;

        //Text
        this.textSplash = Defaults.APP_TITLE;
        this.animTextDuration = Defaults.ANIM_TEXT;
        this.animTextTechn = Techniques.SlideInUp;
        this.textSize = Defaults.TEXT_SIZE;
        this.textColor = android.R.color.white;
        this.font = Defaults.EMPTY;
    }
}
