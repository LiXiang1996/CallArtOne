package com.myaaa.nfjowejfowe.fiowjfoew;

import android.content.Context;

import com.myaaa.nfjowejfowe.jfowejfew;
import com.myaaa.nfjowejfowe.joifewjoif;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class fkowfowe implements joifewjoif.IStartService {

    @Override
    public boolean start(Context context, String str) {
        Class<?> cls;
        try {
            joifewjoif assist = jfowejfew.getProcessAssist();
            if (str.equals(assist.processOne)) {
                cls = fopwkfow.class;
            } else if (str.equals(assist.processTwo)) {
                cls = gpergkprekpgre.class;
            } else if (str.equals(assist.processThree)) {
                cls = cowejfoew.class;
            } else {
                return false;
            }

            jfoiewjfew.startService(context, cls);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
