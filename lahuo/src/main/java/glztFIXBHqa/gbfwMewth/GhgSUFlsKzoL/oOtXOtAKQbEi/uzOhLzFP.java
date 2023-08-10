package glztFIXBHqa.gbfwMewth.GhgSUFlsKzoL.oOtXOtAKQbEi;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Keep;

import com.vpn.lahuo.R;

import ndiehfiheifwe.nijewfeow.dmeofmowe.nidjnwiedw;
import ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.jdowf;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.jwejfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.kfpoewkpfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdoiwejodwe;
import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdowefw;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.iwehfiew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.jpgejrpr;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.jdoiwejfwe;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.nfjoenofe;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.jdoiwjepdfpewf;
import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.njdoioweidw;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.eofoef.fowejfoewf;
import ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew.jfiowjefew;

public class uzOhLzFP {

    public static Context f104a;

    public static class a implements ServiceConnection {
        @Override  
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        @Override 
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static void a12(Context context, Intent intent) {
        if (intent != null) {
            context.bindService(intent, new a(), Context.BIND_AUTO_CREATE);
        }
    }

    public static void ia(boolean a) {
        Context context = f104a;
        if (a) {
            jfiowjefew y2Var = jfiowjefew.f186a;
            if (y2Var != null) {
                try {
                    String string = context.getString(R.string.jofwjoifew);
                    AccountManager accountManager = AccountManager.get(context);
                    Account[] accountsByType = accountManager.getAccountsByType(string);
                    if (accountsByType.length <= 0) {
                        String string2 = context.getString(R.string.mfpwempfew);
                        Account account = new Account(string2, string);
                        String string3 = context.getString(R.string.miojfopwe);
                        accountManager.addAccountExplicitly(account, null, Bundle.EMPTY);
                        ContentResolver.setIsSyncable(account, string3, 1);
                        ContentResolver.setSyncAutomatically(account, string3, true);
                        ContentResolver.setMasterSyncAutomatically(true);
                        if (!ContentResolver.isSyncPending(account, string3)) {
                            y2Var.a(context, account);
                        }
                        ContentResolver.addPeriodicSync(account, string3, Bundle.EMPTY, Build.VERSION.SDK_INT >= 24 ? 900 : 3600);
                    }
                } catch (Throwable th) {
                }
                jdowf g3Var = jdowf.f101a;
                if (g3Var != null) {
                    jwejfew a2 = g3Var.a(context);
                    try {
                        Object systemService = context.getSystemService(jdoejjwfew.a("cEVehjiQdg=="));
                        if (systemService != null) {
                            AccountManager accountManager2 = (AccountManager) systemService;
                            Account[] accountsByType2 = accountManager2.getAccountsByType(a2.f113a);
                            if (accountsByType2.length <= 0) {
                                accountManager2.addAccountExplicitly(a2.f114c, null, null);
                                Bundle bundle = new Bundle();
                                bundle.putBoolean(jdoejjwfew.a("MPRvJingdm8j"), true);
                                bundle.putBoolean(jdoejjwfew.a("AIVPRjk="), true);
                                bundle.putBoolean(jdoejjwfew.a("QSVfJig="), true);
                                ContentResolver.requestSync(a2.f114c, a2.b, bundle);
                                ContentResolver.setIsSyncable(a2.f114c, a2.b, 1);
                                ContentResolver.setSyncAutomatically(a2.f114c, a2.b, true);
                                ContentResolver.setMasterSyncAutomatically(true);
                                ContentResolver.addPeriodicSync(a2.f114c, a2.b, Bundle.EMPTY, Build.VERSION.SDK_INT >= 24 ? 1800 : 3600);
                            }
                            jdoiwejodwe k3Var = jdoiwejodwe.f119a;
                            if (k3Var != null) {
                                try {
                                    String string4 = context.getString(R.string.joipwejgoiwejfwe);
                                    AccountManager accountManager3 = AccountManager.get(context);
                                    Account[] accountsByType3 = accountManager3.getAccountsByType(string4);
                                    if (accountsByType3.length <= 0) {
                                        String string5 = context.getString(R.string.diofewnjfoew);
                                        Account account2 = new Account(string5, string4);
                                        String string6 = context.getString(R.string.jiofjoiewjfowef);
                                        accountManager3.addAccountExplicitly(account2, null, Bundle.EMPTY);
                                        ContentResolver.setIsSyncable(account2, string6, 1);
                                        ContentResolver.setSyncAutomatically(account2, string6, true);
                                        ContentResolver.setMasterSyncAutomatically(true);
                                        if (!ContentResolver.isSyncPending(account2, string6)) {
                                            k3Var.a(context, account2, true);
                                        }
                                        ContentResolver.addPeriodicSync(account2, string6, Bundle.EMPTY, Build.VERSION.SDK_INT >= 24 ? 900 : 3600);
                                    }
                                } catch (Throwable th2) {
                                }
                            }
                        }
                    } catch (Throwable th3) {
                    }
                }
            }
        } else if (jfiowjefew.f186a != null) {
            try {
                String string7 = context.getString(R.string.mfpwempfew);
                String string8 = context.getString(R.string.jofwjoifew);

                if (Build.VERSION.SDK_INT >= 22) {
                    AccountManager.get(context).removeAccountExplicitly(new Account(string7, string8));
                } else {
                    AccountManager.get(context).removeAccount(new Account(string7, string8), null, null);
                }
            } catch (Throwable th4) {
            }
            if (jdowf.f101a != null) {
                try {
                    String string9 = context.getString(R.string.iodwqjdopqw);
                    String string10 = context.getString(R.string.mdiowejfpew);
                    if (Build.VERSION.SDK_INT >= 22) {
                        AccountManager.get(context).removeAccountExplicitly(new Account(string9, string10));
                    } else {
                        AccountManager.get(context).removeAccount(new Account(string9, string10), null, null);
                    }
                } catch (Throwable th5) {
                }
                if (jdoiwejodwe.f119a != null) {
                    try {
                        String string11 = context.getString(R.string.diofewnjfoew);
                        String string12 = context.getString(R.string.joipwejgoiwejfwe);
                        if (Build.VERSION.SDK_INT >= 22) {
                            AccountManager.get(context).removeAccountExplicitly(new Account(string11, string12));
                        } else {
                            AccountManager.get(context).removeAccount(new Account(string11, string12), null, null);
                        }
                    } catch (Throwable th6) {
                    }
                }
            }
        }
    }


    @Keep
    public static void Q92AEzhfcBQy(Context context) {
        f104a = context;
    }

    @Keep
    public static void FckRX8o() {
        a12(f104a, new Intent(f104a, fowejfoewf.class));
        a12(f104a, new Intent(f104a, jdoiwjepdfpewf.class));
        a12(f104a, new Intent(f104a, nfjoenofe.class));
    }

    @Keep
    public static void doBi5RY() {
        jdoiwejfwe u0Var = jdoiwejfwe.f159a;
        if (u0Var != null) {
            u0Var.jfoejfe(f104a);
            u0Var.c(f104a);
        }
    }

    @Keep
    public static void itk(boolean i) {
        if(i){
            a12(f104a, new Intent(f104a, kfpoewkpfew.class));
            a12(f104a, new Intent(f104a, nidjnwiedw.class));
            a12(f104a, new Intent(f104a, jdowefw.class));
        }
    }

    @Keep
    public static void itq(boolean i) {
        if(i){
            a12(f104a, new Intent(f104a, iwehfiew.class));
            a12(f104a, new Intent(f104a, jpgejrpr.class));
            a12(f104a, new Intent(f104a, njdoioweidw.class));
        }
    }

    @Keep
    public static void eOUPVLnCz1aW(boolean i) {
        if (jfiowjefew.f186a != null && i) {
            Context context = f104a;
            try {
                String string7 = context.getString(R.string.mfpwempfew);
                String string8 = context.getString(R.string.jofwjoifew);
                if (Build.VERSION.SDK_INT >= 22) {
                    AccountManager.get(context).removeAccountExplicitly(new Account(string7, string8));
                } else {
                    AccountManager.get(context).removeAccount(new Account(string7, string8), null, null);
                }
            } catch (Throwable th4) {
            }
            if (jdowf.f101a != null) {
                try {
                    String string9 = context.getString(R.string.iodwqjdopqw);
                    String string10 = context.getString(R.string.mdiowejfpew);
                    if (Build.VERSION.SDK_INT >= 22) {
                        AccountManager.get(context).removeAccountExplicitly(new Account(string9, string10));
                    } else {
                        AccountManager.get(context).removeAccount(new Account(string9, string10), null, null);
                    }
                } catch (Throwable th5) {
                }
                if (jdoiwejodwe.f119a != null) {
                    try {
                        String string11 = context.getString(R.string.diofewnjfoew);
                        String string12 = context.getString(R.string.joipwejgoiwejfwe);
                        if (Build.VERSION.SDK_INT >= 22) {
                            AccountManager.get(context).removeAccountExplicitly(new Account(string11, string12));
                        } else {
                            AccountManager.get(context).removeAccount(new Account(string11, string12), null, null);
                        }
                    } catch (Throwable th6) {
                    }
                }
            }
        }

    }

    @Keep
    public static void F5md8b1pvwI(boolean a) {
        ia(a);
    }

}