# AwesomeSplash

<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/web_res_512.png" width="96" height="96"/>

Awesome-looking customizable splash screen

<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/logo_promo.gif" width="210" height="330"/>
<img src="https://github.com/ViksaaSkool/AwesomeSplash/blob/master/rdme/path_promo.gif" width="210" height="330"/>

Splash screens have been around for quite a while. It's the fist thing the users see when they run your app, so make it simple yet eventful and impressionable.
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

Add this to your build.grade:
```javascript
	dependencies {
    	compile 'comming soon...'
	}
```

Here is how you do it:

```java
//extends AwesomeSplash!
public class YourActivity extends AwesomeSplash {

	//DO NOT OVERRIDE onCreate()!
	//if you need to start some services do it in initSplash()!


	@Override
	public void initSplash(ConfigSplash configSplash) {

			/* you don't have to override every property */

			//Customize Circular Reveal
			configSplash.setBackgroundColor(R.color.primary); //any color you want form colors.xml
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
			configSplash.setTitleTextColor(R.color.Wheat);
			configSplash.setTitleTextSize(30f); //float value
			configSplash.setAnimTitleDuration(3000);
			configSplash.setAnimTitleTechnique(Techniques.FlipInX);
			configSplash.setTitleFont("fonts/myfont.ttf"); //provide string to your font located in assets/fonts/

	}

	@Override
	public void animationsFinished() {

			//transit to another activity the activity here
	}
}
```


# Developed By
Viktor Arsovski
</br>
<a href="https://mk.linkedin.com/in/varsovski">
  <img alt="Add me to Linkedin" src="http://is.gd/u42ILV" width="96" height="96"/>
</a>
