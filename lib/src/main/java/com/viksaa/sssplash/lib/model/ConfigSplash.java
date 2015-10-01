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
    private Techniques animLogoSplashTechnique;
    private int animLogoSplashDuration;

    //Path Logo
    private String pathSplash;
    private int pathSplashStrokeSize;
    private int pathSplashStrokeColor;
    private int pathSplashFillColor;
    private int originalHeight;
    private int originalWidth;
    private int animPathStrokeDrawingDuration;
    private int animPathFillingDuration;

    //Text
    private String titleSplash;
    private String titleFont;
    private int animTitleDuration;
    private Techniques animTitleTechnique;
    private float titleTextSize;
    private int titleTextColor;

    //Getters and Setters

    public int getPathSplashFillColor() {
        return pathSplashFillColor;
    }

    public void setPathSplashFillColor(int fillColor) {
        this.pathSplashFillColor = fillColor;
    }

    public int getPathSplashStrokeSize() {
        return pathSplashStrokeSize;
    }

    public void setPathSplashStrokeSize(int pathSplashStrokeSize) {
        this.pathSplashStrokeSize = pathSplashStrokeSize;
    }

    public int getPathSplashStrokeColor() {
        return pathSplashStrokeColor;
    }

    public void setPathSplashStrokeColor(int strokeColor) {
        this.pathSplashStrokeColor = strokeColor;
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

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public void setTitleTextSize(float textSize) {
        this.titleTextSize = textSize;
    }

    public int getTitleTextColor() {
        return titleTextColor;
    }

    public void setTitleTextColor(int textColor) {
        this.titleTextColor = textColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public Techniques getAnimLogoSplashTechnique() {
        return animLogoSplashTechnique;
    }

    public void setAnimLogoSplashTechnique(Techniques animLogoSplashTechnique) {
        this.animLogoSplashTechnique = animLogoSplashTechnique;
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

    public String getPathSplash() {
        return pathSplash;
    }

    public void setPathSplash(String pathSplash) {
        this.pathSplash = pathSplash;
    }

    public int getAnimLogoSplashDuration() {
        return animLogoSplashDuration;
    }

    public void setAnimLogoSplashDuration(int animLogoSplashDuration) {
        this.animLogoSplashDuration = animLogoSplashDuration;
    }

    public String getTitleSplash() {
        return titleSplash;
    }

    public void setTitleSplash(String titleSplash) {
        this.titleSplash = titleSplash;
    }

    public int getAnimTitleDuration() {
        return animTitleDuration;
    }

    public void setAnimTitleDuration(int animTitleDuration) {
        this.animTitleDuration = animTitleDuration;
    }

    public Techniques getAnimTitleTechnique() {
        return animTitleTechnique;
    }

    public void setAnimTitleTechnique(Techniques animTitleTechnique) {
        this.animTitleTechnique = animTitleTechnique;
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

    public int getAnimPathStrokeDrawingDuration() {
        return animPathStrokeDrawingDuration;
    }

    public void setAnimPathStrokeDrawingDuration(int animPathStrokeDrawingDuration) {
        this.animPathStrokeDrawingDuration = animPathStrokeDrawingDuration;
    }

    public int getAnimPathFillingDuration() {
        return animPathFillingDuration;
    }

    public void setAnimPathFillingDuration(int animPathFillingDuration) {
        this.animPathFillingDuration = animPathFillingDuration;
    }

    public String getTitleFont() {
        return titleFont;
    }

    public void setTitleFont(String titleFont) {
        this.titleFont = titleFont;
    }

    public ConfigSplash() {
        initDefaults();
    }

    public void initDefaults() {
        this.animCircularRevealDuration = Defaults.ANIM_REVEAL;
        this.revealFlagX = Flags.REVEAL_RIGHT;
        this.revealFlagY = Flags.REVEAL_BOTTOM;
        this.backgroundColor = R.color.bckg;

        //Img Logo
        this.logoSplash = android.R.mipmap.sym_def_app_icon;
        this.animLogoSplashTechnique = Techniques.FadeInDown;
        this.animLogoSplashDuration = Defaults.ANIM_LOGO;

        //Path Logo
        this.pathSplash = Defaults.EMPTY;
        this.pathSplashStrokeSize = Defaults.STROKE_WIDTH;
        this.pathSplashStrokeColor = android.R.color.white;
        this.pathSplashFillColor = R.color.filn;
        this.originalHeight = Defaults.ORIGINAL_HEIGHT;
        this.originalWidth = Defaults.ORIGINAL_WIDTH;
        this.animPathStrokeDrawingDuration = Defaults.ANIM_DRAWING;
        this.animPathFillingDuration = Defaults.ANIM_FILLING;

        //Text
        this.titleSplash = Defaults.APP_TITLE;
        this.animTitleDuration = Defaults.ANIM_TEXT;
        this.animTitleTechnique = Techniques.SlideInUp;
        this.titleTextSize = Defaults.TEXT_SIZE;
        this.titleTextColor = android.R.color.white;
        this.titleFont = Defaults.EMPTY;
    }
}
