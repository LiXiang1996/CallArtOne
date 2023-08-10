package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw.dmiodjw;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew.feofoe.jdoejjwfew;

public class hifweife extends ContentProvider {

    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (uri == null || !uri.toString().endsWith(jdoejjwfew.a("lDX+Vzkwd38jQ3/EH3R+Ni34PgY=").replaceAll(jdoejjwfew.a("IDUuNg=="), ""))) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{new String(jdoejjwfew.a("cEVehjiQdi9zYy7WLuRu")).replace(jdoejjwfew.a("cGV+Zg=="), ""), new String(jdoejjwfew.a("cEVehjiQdh9DUx53rzVu")).replace(jdoejjwfew.a("QFVOVg=="), ""), new String(jdoejjwfew.a("IOVfd6lgpg9TQw7WLuRu")).replace(jdoejjwfew.a("UEVeRg=="), ""), jdoejjwfew.a("IeRvJkogBs8yUg5krHQ="), jdoejjwfew.a("MPRvhkgxBG5ics4Vfw=="), jdoejjwfew.a("UfWeVyhAZn5QIj81zhV/"), jdoejjwfew.a("YfWeN5lDZj5igx91")});
        matrixCursor.addRow(new Object[]{getContext().getPackageName(), getContext().getPackageName(), getContext().getPackageName(), 0, 1, 1, 1});
        return matrixCursor;
    }

    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}