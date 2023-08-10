package com.myaaa.nfjowejfowe;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/**
 * @author Create by Payne on 2021/5/26
 * Description:
 **/
public class joifewjoif {

    public String pkgName;

    public String processOne;

    public String processTwo;

    public String processThree;

    public Intent dServiceIntent;

    public Intent instruIntent;

    public Intent dReceiverIntent;

    public String daemonFilePath;

    public String nativeLibraryDir;

    public String publicSourceDir;

    public IStartService serviceStarter;

    public interface IStartService {
        boolean start(Context context, String str);
    }

    public static final class Builder {

        public String pkgName;

        public String processOne;

        public String processTwo;

        public String processThree;

        public Intent dServiceIntent;

        public Intent instruIntent;

        public Intent dReceiverIntent;

        public String daemonFilePath;

        public String nativeLibraryDir;

        public String publicSourceDir;

        public IStartService serviceStarter;

        public Context context;

        public Builder(Context context) {
            this.context = context;
        }
        public joifewjoif build() {
            PackageInfo packageInfo;
            if (TextUtils.isEmpty(this.pkgName)) {
                throw new IllegalArgumentException("packageName is not set");
            } else if (TextUtils.isEmpty(this.processOne)) {
                throw new IllegalArgumentException("process1Name is not set");
            } else if (TextUtils.isEmpty(this.processTwo)) {
                throw new IllegalArgumentException("process2Name is not set");
            } else if (TextUtils.isEmpty(this.processThree)) {
                throw new IllegalArgumentException("process3Name is not set");
            } else if (this.dReceiverIntent == null && this.instruIntent == null && this.dServiceIntent == null) {
                throw new IllegalArgumentException("intent is not set");
            } else {
                if (TextUtils.isEmpty(this.daemonFilePath)) {
                    this.daemonFilePath = this.context.getDir("daemonFile", 0).getAbsolutePath();
                }
                try {
                    packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
                } catch (Exception unused) {
                    packageInfo = null;
                }
                if (TextUtils.isEmpty(this.nativeLibraryDir)) {
                    if (packageInfo != null) {
                        this.nativeLibraryDir = packageInfo.applicationInfo.nativeLibraryDir;
                    } else {
                        throw new IllegalArgumentException("so find path is not set");
                    }
                }
                if (TextUtils.isEmpty(this.publicSourceDir)) {
                    if (packageInfo != null) {
                        this.publicSourceDir = packageInfo.applicationInfo.publicSourceDir;
                    } else {
                        throw new IllegalArgumentException("class find path is not set");
                    }
                }
                if (this.serviceStarter != null) {
                    return new joifewjoif(this);
                }
                throw new IllegalArgumentException("daemon process starter is not set");
            }
        }
    }

    public joifewjoif(Builder builder) {
        this.pkgName = builder.pkgName;
        this.processOne = builder.processOne;
        this.processTwo = builder.processTwo;
        this.processThree = builder.processThree;
        this.dReceiverIntent = builder.dReceiverIntent;
        this.instruIntent = builder.instruIntent;
        this.dServiceIntent = builder.dServiceIntent;
        this.daemonFilePath = builder.daemonFilePath;
        this.nativeLibraryDir = builder.nativeLibraryDir;
        this.publicSourceDir = builder.publicSourceDir;
        this.serviceStarter = builder.serviceStarter;
    }

    public Intent getInstruIntent() {
        return this.instruIntent;
    }

    public Intent getReceiverIntent() {
        return this.dReceiverIntent;
    }

    public Intent getServiceIntent() {
        return this.dServiceIntent;
    }

    public String getNativeLibraryDir() {
        return this.nativeLibraryDir;
    }

}
