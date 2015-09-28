package com.viksaa.sssplash.lib.model;

import com.daimajia.androidanimations.library.Techniques;
import com.github.jorgecastillo.clippingtransforms.ClippingTransform;
import com.github.jorgecastillo.clippingtransforms.PlainClippingTransform;
import com.viksaa.sssplash.lib.cnst.Defaults;
import com.viksaa.sssplash.lib.cnst.Flags;

/**
 * Created by varsovski on 25-Sep-15.
 */
public class ConfigSplash {


    //Circular Reveal
    private int animCircularRevealDuration;
    private int revealX;
    private int revealY;
    private int backgroundColor;

    //Img Logo
    private int logoSplash;
    private Techniques animLogoTechn;
    private int animLogoSplashDuration;

    //Path Logo
    private String logoSplashPath;
    private int strokeSize;
    private int strokeColor;
    private ClippingTransform clippingTransform;
    private int originalHeight;
    private int originalWidth;

    //Text
    private String textSplash;
    private int animTextDuration;
    private Techniques animTextTechn;
    private float textSize;
    private int textColor;

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

    public ClippingTransform getClippingTransform() {
        return clippingTransform;
    }

    public void setClippingTransform(ClippingTransform clippingTransform) {
        this.clippingTransform = clippingTransform;
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




    //Getters and Setters

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


    public int getRevealX() {
        return revealX;
    }

    public void setRevealX(int revealX) {
        this.revealX = revealX;
    }

    public int getRevealY() {
        return revealY;
    }

    public void setRevealY(int revealY) {
        this.revealY = revealY;
    }


    public ConfigSplash(){
        initDefaults();
    }


    public void initDefaults(){
        this.animCircularRevealDuration = Defaults.ANIM_REVEAL;
        this.revealX = Flags.R_BOTTOM;
        this.revealY = Flags.R_RIGHT;
        this.backgroundColor = android.R.color.holo_purple;

        //Img Logo
        this.logoSplash = android.R.mipmap.sym_def_app_icon;
        this.animLogoTechn = Techniques.Bounce;
        this.animLogoSplashDuration = Defaults.ANIM_LOGO;

        //Path Logo
        this.logoSplashPath = Defaults.EMPTY;
        this.strokeSize = Defaults.STROKE_WIDTH;
        this.strokeColor = android.R.color.holo_red_dark;
        this.clippingTransform = new PlainClippingTransform();
        this.originalHeight = Defaults.ORIGINAL_HEIGHT;
        this.originalWidth = Defaults.ORIGINAL_WIDTH;

        //Text
        this.textSplash = Defaults.APP_TITLE;
        this.animTextDuration = Defaults.ANIM_TEXT;
        this.animTextTechn = Techniques.FadeInDown;
        this.textSize = Defaults.TEXT_SIZE;
        this.textColor = android.R.color.white;
    }

}
