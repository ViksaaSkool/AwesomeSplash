# AwesomeSplash

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AwesomeSplash-green.svg?style=flat)](https://android-arsenal.com/details/1/2605)

<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/web_res_512.png" width="96" height="96"/>

Awesome-looking customizable splash screen

<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/logo_promo.gif" width="210" height="330"/>
<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/path_promo.gif" width="210" height="330"/>

Splash screens have been around for quite a while. It's the first thing the users see when they run your app, so make it simple yet eventful and impressionable.
This library does exactly that, provides you with beautiful template screen, with wide range of customizations to fit your concept of the splash screen. 
To be noted, with the last acknowledgement form google that splash screens [got](http://is.gd/2MQzao), having a library that tackles this issue is kind of necessity. 

Ready to see implementation details? Let's scroll.

# Demo

What the library is capable of is shown in this youtube video:

[![ScreenShot](https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/yt_promo.png)](https://www.youtube.com/embed/8OOaT2LGZjc)


You can download the demo app [here]
(https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/awesome_splash_demo.apk?raw=true) 

# Prerequisites/Credits

This library is based and utilizes 3 great libraries:
- [Android View Animations](http://is.gd/BLUMT7)
- [Android FillableLoaders](http://is.gd/0WWbEf)
- [CircularReveal](http://is.gd/xpSITZ)

So before diving into AwesomeSplash library, look into the libraries. Especially make sure you understand the concept of
[SVG path](http://is.gd/0WWbEf) and look deeply on how to [create](http://is.gd/KfljPg) you custom svg (and get the string values needed for AwesomeSplash).

# Usage

Add this to your settings.gradle:
```groovy
	repositories {
	    //...
            maven { url "https://jitpack.io" }
    }
```

and then in dependencies:
```groovy
	dependencies {
	        implementation 'com.github.ViksaaSkool:AwesomeSplash:v1.0.0'
	}
```

Here is how you utilize the library in your Kotlin code:
```kotlin
//extends AwesomeSplash!
class YourActivity : AwesomeSplash() {

	//DO NOT OVERRIDE onCreate()!
	//if you need to start some services do it in initSplash()!

	override fun initSplash(configSplash: ConfigSplash?) {

        /* you don't have to override every property */

        configSplash?.let {
            //Customize Circular Reveal
            it.backgroundColor = R.color.purple_500 //any color you want from colors.xml
            it.animCircularRevealDuration = 2000 //int ms
            it.revealFlagX = Flags.REVEAL_RIGHT  //or Flags.REVEAL_LEFT
            it.revealFlagY = Flags.REVEAL_BOTTOM //or Flags.REVEAL_TOP

            //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

            //Customize Logo
            it.logoSplash = R.mipmap.ic_launcher //or any other drawable
            it.animLogoSplashDuration = 3000 //int ms
            it.animLogoSplashTechnique = Techniques.Bounce //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

            //Customize Path
            it.pathSplash = Constants.DROID_LOGO //set path String
            it.originalHeight = 400 //in relation to your svg (path) resource
            it.originalWidth = 400 //in relation to your svg (path) resource
            it.animPathStrokeDrawingDuration = 3000
            it.pathSplashStrokeSize = 3 //I advise value be <5
            it.pathSplashStrokeColor = R.color.teal_200 //any color you want from colors.xml
            it.animPathFillingDuration = 3000
            it.pathSplashFillColor = R.color.white //path object filling color

            //Customize Title
            it.titleSplash = "My Awesome App"
            it.titleTextColor = R.color.white
            it.titleTextSize = 30f //float value
            it.animTitleDuration = 3000
            it.animTitleTechnique = Techniques.Bounce
            it.titleFont = "fonts/myfont.ttf" //provide string to your font located in assets/fonts/
        }

    }

    override fun animationsFinished() {
        //transit to another activity here
        //or do whatever you want
    }
    
}
```

Here is how you utilize the library in your Java code:

```java
//extends AwesomeSplash!
public class YourActivity extends AwesomeSplash {

	//DO NOT OVERRIDE onCreate()!
	//if you need to start some services do it in initSplash()!

	@Override
	public void initSplash(ConfigSplash configSplash) {

		/* you don't have to override every property */

		//Customize Circular Reveal
		configSplash.setBackgroundColor(R.color.purple_500); //any color you want form colors.xml
		configSplash.setAnimCircularRevealDuration(2000); //int ms
		configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
		configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

		//Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

		//Customize Logo
		configSplash.setLogoSplash(R.mipmap.ic_launcher); //or any other drawable
		configSplash.setAnimLogoSplashDuration(2000); //int ms
		configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)

		//Customize Path
		configSplash.setPathSplash(Constants.DROID_LOGO); //set path String
		configSplash.setOriginalHeight(400); //in relation to your svg (path) resource
		configSplash.setOriginalWidth(400); //in relation to your svg (path) resource
		configSplash.setAnimPathStrokeDrawingDuration(3000);
		configSplash.setPathSplashStrokeSize(3); //I advise value be <5
		configSplash.setPathSplashStrokeColor(R.color.accent); //any color you want form colors.xml
		configSplash.setAnimPathFillingDuration(3000);
		configSplash.setPathSplashFillColor(R.color.Wheat); //path object filling color

		//Customize Title
		configSplash.setTitleSplash("My Awesome App");
		configSplash.setTitleTextColor(R.color.white);
		configSplash.setTitleTextSize(30f); //float value
		configSplash.setAnimTitleDuration(3000);
		configSplash.setAnimTitleTechnique(Techniques.FlipInX);
		configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/

	}

	@Override
	public void animationsFinished() {
		//transit to another activity here
		//or do whatever you want
	}
}
```


Implemented in
--------------

Reiseuhu
</br>
<a href="http://bit.ly/1ttLFyy"><img src="http://bit.ly/1ttLfs2" align="left" height="96" width="96" ></a>
</br>
</br>
</br>
</br>

CliniShift
</br>
<a href="http://www.clinishift.com/"><img src="http://bit.ly/2d1aSrM" align="left" height="96" width="96" ></a>
</br>
</br>
</br>
</br>
<p>If you implement the library in your app(s) and you upload it on Google Play, let me know.</p>


License
--------

    The MIT License (MIT)

    Copyright (c) 2015 Viktor Arsovski
    
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
    
    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.


# Developed By
Viktor Arsovski
</br>
<a href="https://mk.linkedin.com/in/varsovski">
  <img alt="Add me to Linkedin" src="http://is.gd/u42ILV" width="96" height="96"/>
</a>

