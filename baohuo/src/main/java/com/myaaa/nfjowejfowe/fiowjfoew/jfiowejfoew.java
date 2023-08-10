package com.myaaa.nfjowejfowe.fiowjfoew;

import android.app.Service;
import android.content.Context;

import com.myaaa.nfjowejfowe.jiojoi.jdiowejofe;

/**
 * @author Create by Payne on 2021/7/7
 * Description:
 **/
public class jfiowejfoew implements jdiowejofe.OnMainProcessStartCallback {

    private final Service service;

    public jfiowejfoew(Service service) {
        this.service = service;
    }

    @Override
    public void onMainStart(Context context) {
        jiofewjof.send(context, this.service.getClass().getName());
    }
}
