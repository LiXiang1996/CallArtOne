package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;

import com.vpn.lahuo.R;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;


public final class jfiowjefew {

    /* renamed from: a  reason: collision with root package name */
    public static final jfiowjefew f186a = new jfiowjefew();

    public final void a(Context context, Account account) {

        try {
            String string = context.getString(R.string.miojfopwe);
            Bundle bundle = new Bundle();
            bundle.putBoolean(jdoejjwfew.a("AIVPRjk="), true);
            bundle.putBoolean(jdoejjwfew.a("QSV/J/lRZ8xT8y4VTqTeBg=="), true);
            if (account == null) {
                String string2 = context.getString(R.string.mfpwempfew);
                String string3 = context.getString(R.string.jofwjoifew);
                account = new Account(string2, string3);
            }
            ContentResolver.requestSync(account, string, bundle);
        } catch (Throwable th) {
        }
    }
}