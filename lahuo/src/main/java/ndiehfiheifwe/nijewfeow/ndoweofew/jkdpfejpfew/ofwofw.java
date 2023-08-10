package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew;

import android.accounts.Account;
import android.content.Context;
import android.content.ISyncAdapterUnsyncableAccountCallback;
import android.content.ISyncContext;
import android.content.SyncResult;
import android.os.Build;
import android.os.Bundle;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;
import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdoiwejodwe;
import ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew.jdowefew;

public class ofwofw extends jdowefew {
    public final Context f187a;
    public ofwofw(Context context) {
        this.f187a = context;
    }

    @Override // android.content.ISyncAdapter
    public void cancelSync(ISyncContext iSyncContext) {
        jdoiwejodwe.f119a.a(this.f187a, null, true);
    }
    @Override // android.content.ISyncAdapte
    public void onUnsyncableAccount(ISyncAdapterUnsyncableAccountCallback iSyncAdapterUnsyncableAccountCallback) {
        if (iSyncAdapterUnsyncableAccountCallback != null) {
            try {
                iSyncAdapterUnsyncableAccountCallback.onUnsyncableAccountDone(true);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.content.ISyncAdapter
    public void startSync(ISyncContext iSyncContext, String str, Account account, Bundle bundle) {
        boolean z;
        try {
            if (Build.VERSION.SDK_INT <= 26 || this.f187a.getApplicationInfo().targetSdkVersion <= 26) {
                boolean z2 = false;
                if (bundle != null) {
                    if (bundle.getBoolean(jdoejjwfew.a("AIVPRjk="), false)) {
                        z = true;
                        if (z) {
                            if (bundle != null) {
                                if (bundle.getBoolean(jdoejjwfew.a("8AWOhkggxB9zQ47EXlQ="), false)) {
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                if (iSyncContext != null) {
                                    iSyncContext.onFinished(new SyncResult());
                                }
                                jdoiwejodwe.f119a.a(this.f187a, null, true);
                                return;
                            } else if (iSyncContext != null) {
                                iSyncContext.onFinished(SyncResult.ALREADY_IN_PROGRESS);
                                return;
                            } else {
                                return;
                            }
                        } else if (iSyncContext != null) {
                            iSyncContext.onFinished(new SyncResult());
                            return;
                        } else {
                            return;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
        } catch (Throwable th) {
            //b3.b(b, j.l(x.a("UTR+VyhDpt9T96rwOmQ6o2k="), th));
        }
    }
}