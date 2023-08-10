package com.myaaa.mydwjdpow.tel;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author Create by Payne on 2021/9/29
 * Description:
 **/
public class modmwodw extends ContentProvider {
    @Override
    public boolean onCreate() {
        //if((RomUtil.isVivo()) && (Build.VERSION.SDK_INT < 30))
        //    DaemonManager.getInstance().init(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return mo32502a(uri);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
    public final Cursor mo32502a(Uri uri) {
        if (uri == null || !uri.toString().endsWith("/directories")) {
            return null;
        }
        //MatrixCursor matrixCursor = new MatrixCursor(new String[]{new String("accountName"), new String("accountType"), new String(FileProvider.DISPLAYNAME_FIELD), "typeResourceId", "exportSupport", "shortcutSupport", "photoSupport"});
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{new String("accountName"), new String("accountType"), new String("displayName"), "typeResourceId", "exportSupport", "shortcutSupport", "photoSupport"});
        matrixCursor.addRow(new Object[]{getContext().getPackageName(), getContext().getPackageName(), getContext().getPackageName(), 0, 1, 1, 1});
        return matrixCursor;
    }
}
