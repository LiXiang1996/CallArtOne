package com.myaaa.mydwjdpow.modnmowqd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.Log;


import com.android.kachem.R;
import com.myaaa.mydwjdpow.miefoefe.pfdewpfwe;
import com.myaaa.mydwjdpow.miefoefe.modnwodwq;

import java.io.IOException;

/**
 * @author Create by Payne on 2021/9/26
 * Description:
 **/
public class doiwqjodqw {

    public MediaPlayer f27334a;

    public PlaySilentBroadcastReceiver f27335b;

    public boolean f27336c = false;

    public boolean f27337d = false;

    public boolean f27338e;


    public class PlaySilentBroadcastReceiver extends BroadcastReceiver {

        public PlaySilentBroadcastReceiver(){

        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null){
                String action = intent.getAction();
                if ("android.intent.action.SCREEN_OFF".equalsIgnoreCase(action)) {
                    doiwqjodqw.this.b();
                } else if ("com.ms.android.dailycleanaegis.background".equalsIgnoreCase(action)) {
                    doiwqjodqw.this.b();
                } else if ("com.ms.android.dailycleanaegis.foreground".equalsIgnoreCase(action)) {
                    doiwqjodqw.this.a();
                }
            }
        }
    }

    public void d(Context context){
        e(context);
        a();
        MediaPlayer mediaPlayer = this.f27334a;
        if (mediaPlayer != null){
            mediaPlayer.release();
            this.f27334a = null;
        }
        this.f27337d = false;
        this.f27336c = false;
        this.f27338e = false;
    }

    public final void e(Context context){
        PlaySilentBroadcastReceiver aVar = this.f27335b;
        if (aVar != null){
            context.unregisterReceiver(aVar);
            this.f27335b = null;
        }
    }

    public final void b(){
        this.f27338e = true;
        MediaPlayer mediaPlayer = this.f27334a;
        if (mediaPlayer != null && !this.f27336c && this.f27337d){
            try {
                mediaPlayer.start();
            }catch (IllegalStateException unused){
                this.f27337d = false;
            }
        }
    }

    public final void c(Context context){
        AssetFileDescriptor assetFileDescriptor;
        try {
            assetFileDescriptor = context.getResources().openRawResourceFd(R.raw.silent);
        }catch (Resources.NotFoundException e){
            e.printStackTrace();
            assetFileDescriptor = null;
        }
        if (assetFileDescriptor != null){
            try {
                this.f27334a = new MediaPlayer();
                int i2 = 0;
                if (Build.VERSION.SDK_INT >= 21){
                    this.f27334a.setAudioAttributes(new AudioAttributes.Builder().build());
                    i2 = Math.max(((AudioManager) context.getSystemService(Context.AUDIO_SERVICE)).generateAudioSessionId(), 0);
                }
                this.f27334a.setAudioSessionId(i2);
                this.f27334a.setWakeMode(context, 1);
                this.f27334a.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                this.f27334a.setVolume(1.0f, 1.0f);
                this.f27334a.setLooping(true);
                this.f27334a.setOnPreparedListener(new modnwodwq(this));
                this.f27334a.setOnErrorListener(new pfdewpfwe());
                this.f27334a.prepareAsync();
                assetFileDescriptor.close();
            }catch (Exception e){
                e.printStackTrace();
                try {
                    assetFileDescriptor.close();
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }catch (Throwable th){
                try {
                    assetFileDescriptor.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                throw th;
            }
        }

    }

    public void a(Context context){
        this.f27338e = true;
        c(context);
        b(context);
    }

    public final void a(){
        this.f27338e = false;
        MediaPlayer mediaPlayer = this.f27334a;
        if (mediaPlayer != null && this.f27336c && this.f27337d){
            try {
                mediaPlayer.pause();
                Log.i("DaemonLog","MediaPlayer pause");
                this.f27336c = false;
            }catch (IllegalStateException e){
                this.f27336c = false;
            }
        }
    }

    public final void b(Context context){
        if (this.f27335b == null){
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("com.ms.android.dailycleanaegis.foreground");
            intentFilter.addAction("com.ms.android.dailycleanaegis.background");
            this.f27335b = new PlaySilentBroadcastReceiver();
            context.registerReceiver(this.f27335b, intentFilter);
        }
    }

}
