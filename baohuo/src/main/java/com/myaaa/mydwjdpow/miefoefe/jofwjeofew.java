package com.myaaa.mydwjdpow.miefoefe;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.myaaa.mydwjdpow.fmeofme.jiofwejoif;
import com.myaaa.mydwjdpow.modnmowqd.doiwqjodqw;

/**
 * @author Create by Payne on 2021/9/26
 * Description:
 **/
public class jofwjeofew extends Service {

    public doiwqjodqw f12210a;

    public static void begin(jiofwejoif bVar){
        if (TextUtils.equals(bVar.f27328c, bVar.f27330e)){
            Intent intent = new Intent(bVar.f27326a, jofwjeofew.class);
            try {
//                if (bVar.d()){
                    bVar.f27326a.startService(intent);
//                }else {
//                    Log.i("DaemonLog","SilentMusicService stop");
//                    bVar.f27326a.stopService(intent);
//                }
            }catch (Exception e){
               // Log.i("DaemonLog","SilentMusicService begin exception");
            }
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        doiwqjodqw cVar = this.f12210a;
        if (cVar != null){
            cVar.d(getApplicationContext());
            this.f12210a = null;
        }
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (this.f12210a == null){
            this.f12210a = new doiwqjodqw();
            this.f12210a.a(getApplicationContext());
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
