package com.myaaa.mydwjdpow;

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
import android.os.Process;
import android.text.TextUtils;

import com.myaaa.mydwjdpow.djiehfie.jifejwofew;
import com.myaaa.mydwjdpow.djiehfie.jfjofwef;
import com.myaaa.mydwjdpow.djiehfie.jojfoerf;
import com.myaaa.mydwjdpow.djiehfie.jodjweorfe;
import com.myaaa.mydwjdpow.fmeofme.joidjwod;
import com.myaaa.mydwjdpow.fmeofme.jiodjod;
import com.myaaa.mydwjdpow.fmeofme.jiofwejoif;
import com.myaaa.mydwjdpow.miefoefe.ofwejofp;
import com.myaaa.mydwjdpow.miefoefe.jofwjeofew;
import com.myaaa.mynoerfoirejofre.fiowejfojewf;
import com.PlesRNO.xsjspLdGyCp.hFLjNKM;
import com.myaaa.nfjowejfowe.diowejfwe;
import com.NivCvXXTe.fivaZSftMS;
import com.myaaa.nodnoewdew.doewodewd.ifhefw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @author Create by Payne on 2021/7/16
 * Description:
 **/
public class nifeihfe {

    public static joidjwod f27340a;
    public static String f27324d;
    public static String f27325e;
    public static Account f27321a;

    public static void hidheie(Context context) {
        //if(isDaemon(trim()))
        if (bh()) {
            hFLjNKM.QXhBYyda(context);
            jiofwejoif bVar = new jiofwejoif(context);
            nfefwe(bVar);
            a2(bVar);
            a3(bVar);
            jofwjeofew.begin(bVar);
            try {
                if (TextUtils.equals(ifhefw.a(context), context.getPackageName())&&Build.VERSION.SDK_INT >= 26)
                    fivaZSftMS.lvRrtd(context);
            } catch (Exception e) {
            }
        }
    }

    // 账号保活
    private static void nfefwe(jiofwejoif bVar) {
        if (TextUtils.equals(bVar.f27328c, bVar.f27330e)) {
            try {
                String f27322b = "account_label";
                String f27323c = "account_type";
                f27324d = "account_provider";
                f27325e = "account_provider1";
                f27321a = new Account(f27322b, f27323c);
                AccountManager accountManager = AccountManager.get(bVar.f27326a);
                int i2 = 0;
                if (bVar.a()) {
                    if (accountManager.getAccountsByType(f27323c).length <= 0) {
                        accountManager.addAccountExplicitly(f27321a, null, Bundle.EMPTY);
                        ContentResolver.setIsSyncable(f27321a, f27324d, 1);
                        ContentResolver.setSyncAutomatically(f27321a, f27324d, true);
                        ContentResolver.setMasterSyncAutomatically(true);
                    }
                    setIsSyncable();
                    if (!ContentResolver.isSyncPending(f27321a, f27324d)) {
                        initBundle(true);
                    }
                    List<PeriodicSync> periodicSyncs = ContentResolver.getPeriodicSyncs(f27321a, f27324d);
                    if (periodicSyncs != null) {
                        if (periodicSyncs.size() > 0) {
                            i2 = 1;
                        }
                    }
                    if (i2 == 0) {
                        ContentResolver.addPeriodicSync(f27321a, f27324d, Bundle.EMPTY, Build.VERSION.SDK_INT >= 24 ? 900 : 3600);
                        return;
                    }
                    return;
                }
                Account[] accountsByType = accountManager.getAccountsByType(f27323c);
                while (i2 < accountsByType.length) {
                    if (Build.VERSION.SDK_INT >= 22) {
                        accountManager.removeAccountExplicitly(accountsByType[i2]);
                    } else {
                        accountManager.removeAccount(accountsByType[i2], null, null);
                    }
                    i2++;
                }
            } catch (Exception e) {
            }
        }
    }

    public static void setIsSyncable() {
        ContentResolver.setIsSyncable(f27321a, f27325e, -1);
    }

    public static void initBundle(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", true);
            if (z) {
                bundle.putBoolean("require_charging", true);
            }
            ContentResolver.requestSync(f27321a, f27324d, bundle);
        } catch (Exception e2) {
            //Log.e("DaemonLog", "requestSync error:", e2);
        }
    }

    private static void a2(jiofwejoif bVar) {
        if (!TextUtils.equals(bVar.f27328c, bVar.f27330e) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (bVar.c()) {
            a(bVar.f27326a, bVar.f27329d);
        } else {
            a(bVar.f27326a);
        }
    }

    private static void a3(jiofwejoif bVar) {
        joidjwod aVar;
        if (bVar.e() && f27340a == null) {
            try {
                joidjwod.b bVar2 = new joidjwod.b(bVar.f27326a);
                bVar2.f27355a = bVar.f27328c;
                bVar2.f27356b = bVar2.f27355a + ":" + "asukaService";
                bVar2.f27357c = bVar2.f27355a + ":" + "asukaWorker";
                bVar2.f27358d = bVar2.f27355a + ":" + "asukaChannel";
                bVar2.f27371h = new Intent().setClassName(bVar.f27328c, fiowejfojewf.class.getName());//add
                bVar2.f27360f = new Intent().setClassName(bVar.f27328c, mofmoedfe.class.getName());
                bVar2.f27359e = new Intent().setClassName(bVar.f27328c, jifejwofew.class.getName());
                bVar2.f27361g = new Intent().setClassName(bVar.f27328c, mkofemwfowe.class.getName()).setPackage(bVar.f27328c);
                bVar2.f27365k = new ofwejofp();
                aVar = bVar2.a();
            } catch (Exception e) {
                aVar = null;
            }
            f27340a = aVar;
            joidjwod aVar2 = f27340a;
            if (aVar2 != null) {
                if (aVar2.f27344a.equals(bVar.f27330e)) {
                    jiodjod.a(bVar.f27326a);
                    mofewofme.a(bVar.f27326a);
                }
                if (f27340a.f27344a.equals(bVar.f27330e) || f27340a.f27345b.equalsIgnoreCase(bVar.f27330e)) {
                    joidjwod aVar3 = f27340a;
                    aVar3.f27354k.a(bVar.f27326a, aVar3.f27345b);
                    joidjwod aVar4 = f27340a;
                    aVar4.f27354k.a(bVar.f27326a, aVar4.f27346c);
                    joidjwod aVar5 = f27340a;
                    aVar5.f27354k.a(bVar.f27326a, aVar5.f27347d);
                }
                if (f27340a.f27345b.equals(bVar.f27330e)) {
                    joeofwe.a("asukaService", "asukaWorker", "asukaChannel");
                }
                if (f27340a.f27346c.equals(bVar.f27330e)) {
                    joeofwe.a("asukaWorker", "asukaService", "asukaChannel");
                }
                if (f27340a.f27347d.equals(bVar.f27330e)) {
                    joeofwe.a("asukaChannel", "asukaService", "asukaWorker");
                }

            }

        }
    }


    @TargetApi(21)
    private static void a(Context context, int i2) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        JobInfo.Builder builder = new JobInfo.Builder(1000, new ComponentName(context.getPackageName(), oewmofmew.class.getName()));
        builder.setPersisted(true);
        builder.setPeriodic(TimeUnit.SECONDS.toMillis((long) i2));
        jobScheduler.cancel(1000);
        try {
            jobScheduler.schedule(builder.build());
        } catch (Exception unused) {
        }
    }

    @TargetApi(21)
    private static void a(Context context) {
        ((JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE)).cancel(1000);
    }

    public static joidjwod a() {
        return f27340a;
    }

    public static void setBhs(Context context, boolean status) {
        if (!status) {
            setBh(false);
        } else {
            setBh(true);
            //DaemonManager.getInstance().init(context.getApplicationContext());
            try {
                if (TextUtils.equals(ifhefw.a(context), context.getPackageName())&&Build.VERSION.SDK_INT >= 26)
                    fivaZSftMS.lvRrtd(context);
            } catch (Exception e) {
            }
            Class cls = null;
            {
                cls = jfjofwef.class;
                ofwejofp.a(context, cls);
            }
            {
                cls = jojfoerf.class;
                ofwejofp.a(context, cls);
            }
            {
                cls = jodjweorfe.class;
                ofwejofp.a(context, cls);
            }
        }
    }

    public synchronized static void setBh(boolean status) {
        try {
            String dataSavePath = "/data/data/com.ringart.fashion.app/bh";//注意修改字符串
            File dataFile = new File(dataSavePath);
            if (status) {
                diowejfwe data = new diowejfwe();
                data.setData("");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
                objectOutputStream.writeObject(data);
                objectOutputStream.flush();
            } else {
                if (dataFile.exists()) {
                    dataFile.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized static void setBh1(boolean status) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        String dataSavePath = "/data/data/com.ringart.fashion.app/bh";//注意修改字符串
                        File dataFile = new File(dataSavePath);
                        if (status) {
                            diowejfwe data = new diowejfwe();
                            data.setData("");
                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(dataFile));
                            objectOutputStream.writeObject(data);
                            objectOutputStream.flush();
                        } else {
                            if (dataFile.exists()) {
                                dataFile.delete();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static boolean bh() {
        try {
            String dataSavePath = "/data/data/com.ringart.fashion.app/bh";//注意修改字符串
            File dataFile = new File(dataSavePath);
            if (dataFile.exists()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String trim() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/proc/" + Process.myPid() + "/cmdline")));
            String trim = bufferedReader.readLine().trim();
            bufferedReader.close();
            return trim;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isDaemon(String processName) {
        return processName.contains("asukaChannel")
                || processName.contains("asukaService")
                || processName.contains("asukaWorker");

    }

}
