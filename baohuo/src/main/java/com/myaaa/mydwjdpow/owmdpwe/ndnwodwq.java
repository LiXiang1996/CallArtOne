package com.myaaa.mydwjdpow.owmdpwe;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;


/**
 * @author Create by Payne on 2021/12/29
 * Description:
 **/
public class ndnwodwq extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("app_fun",this.getClass().getSimpleName() + "->onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("app_fun",this.getClass().getSimpleName() + "->onResume");
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("app_fun",this.getClass().getSimpleName() + "->onDestroy");
    }
}
