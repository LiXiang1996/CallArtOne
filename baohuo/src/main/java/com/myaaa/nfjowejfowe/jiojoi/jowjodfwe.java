package com.myaaa.nfjowejfowe.jiojoi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.myaaa.nfjowejfowe.fiowjfoew.fopwkfow;
import com.myaaa.nfjowejfowe.fiowjfoew.jfoiewjfew;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jowjodfwe extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ////Log.e("DaemonLog", "MainReceiver onReceive");
        jfoiewjfew.startService(context.getApplicationContext(), fopwkfow.class);
    }
}