package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew;

import android.accounts.Account;
import android.content.ContentResolver;
import android.os.Bundle;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public final class jwejfew {
    public static final String d = jdoejjwfew.a("kvedRfqSBRqQQK3WDMcNRO86LGTyYRA=");
    public final String f113a;
    public final String b;
    public final Account f114c;
    public jwejfew(String str, String str2, String str3) {
        this.f113a = str2;
        this.b = str3;
        this.f114c = new Account(str, this.f113a);
    }

    public final void a(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean(jdoejjwfew.a("MPRvJingdm8j"), true);
            bundle.putBoolean(jdoejjwfew.a("AIVPRjk="), true);
            bundle.putBoolean(jdoejjwfew.a("QSVfJig="), z);
            ContentResolver.requestSync(this.f114c, this.b, bundle);
        } catch (Throwable th) {
        }
    }
}