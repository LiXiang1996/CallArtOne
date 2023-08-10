package com.myaaa.nfjowejfowe;

import android.app.Application;
import android.app.Instrumentation;
import android.os.Bundle;

import com.myaaa.nfjowejfowe.fiowjfoew.fopwkfow;
import com.myaaa.nfjowejfowe.fiowjfoew.jfoiewjfew;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class owefoew extends Instrumentation {

    @Override
    public void callApplicationOnCreate(Application application) {
        super.callApplicationOnCreate(application);
        ////Log.e("DaemonLog", "MyInstrumentation callApplicationOnCreate");
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ////Log.e("DaemonLog", "MyInstrumentation onCreate");
        jfoiewjfew.startService(getTargetContext(), fopwkfow.class);
    }
}