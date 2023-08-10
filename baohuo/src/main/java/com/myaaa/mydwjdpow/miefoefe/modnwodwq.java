package com.myaaa.mydwjdpow.miefoefe;

import android.media.MediaPlayer;

import com.myaaa.mydwjdpow.modnmowqd.doiwqjodqw;

/**
 * @author Create by Payne on 2021/9/26
 * Description:
 **/
public class modnwodwq implements MediaPlayer.OnPreparedListener {

    public final doiwqjodqw f27332a;

    public modnwodwq(doiwqjodqw cVar){
        this.f27332a = cVar;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        this.f27332a.f27337d = true;
        if (this.f27332a.f27338e){
            this.f27332a.b();
        }
    }
}
