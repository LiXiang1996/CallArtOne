package ndiehfiheifwe.nijewfeow.ndoweofew.fnewjofnoew;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;

import com.vpn.lahuo.R;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public final class jdoiwejodwe {

    /* renamed from: a  reason: collision with root package name */
    public static final jdoiwejodwe f119a = new jdoiwejodwe();
    public final void a(Context context, Account account, boolean z) {
        try {
            String string = context.getString(R.string.jiofjoiewjfowef);
            Bundle bundle = new Bundle();
            bundle.putBoolean(jdoejjwfew.a("AIVPRjk="), true);
            if (z) {
                bundle.putBoolean(jdoejjwfew.a("QSV/J/lRZ8xT8y4VTqTeBg=="), true);
            }
            if (account == null) {
                String string2 = context.getString(R.string.diofewnjfoew);
                String string3 = context.getString(R.string.joipwejgoiwejfwe);
                account = new Account(string2, string3);
            }
            ContentResolver.requestSync(account, string, bundle);
        } catch (Throwable th) {
        }
    }
}