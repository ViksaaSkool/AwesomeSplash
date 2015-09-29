package com.viksaa.ssspalsh.helpers;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;


/**
 * Created by varsovski on 18-Mar-15.
 */
public class ChangeActivityHelper implements OnClickListener {

    private Activity _source;
    private Class<?> _destination;
    private boolean _finishActivity;

    public ChangeActivityHelper(Activity source, Class<?> destination) {
        super();
        _source = source;
        _destination = destination;
        _finishActivity = false;
    }

    public ChangeActivityHelper(Activity source, Class<?> destination, boolean finishActivity) {
        this(source, destination);
        _finishActivity = finishActivity;
    }

    @Override
    public void onClick(View v) {
        changeActivity(_source, _destination, _finishActivity);
    }

    public static void changeActivity(Activity source, Class<?> destination) {
        changeActivity(source, destination, false);
    }


    /**
     * call when you need to transit form one activity to another
     * @param shouldFinishContext: true if you want to finish context of the current activity, false otherwise
     */
    public static void changeActivity(Activity source, Class<?> destination, Boolean shouldFinishContext) {
        if (shouldFinishContext){
            source.finish();
        }
        Intent intent = new Intent(source, destination);
        source.startActivity(intent);
    }

    public static void changeActivity(FragmentActivity source, Class<?> destination, boolean shouldFinishContext, Bundle bundle) {
        if (shouldFinishContext){
            source.finish();
        }
        Intent intent = new Intent(source, destination);
        intent.putExtras(bundle);
        source.startActivity(intent);
    }



}
