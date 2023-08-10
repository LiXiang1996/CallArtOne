# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.gyf.immersionbar.* {*;}
-dontwarn com.gyf.immersionbar.**

-keep class com.github.shadowsocks.** {*;}
-dontwarn com.github.shadowsocks.**

-keep public class * extends android.view.View{
    *** get*();
    void set*(***);
    public <init>(android.content.Context);
    public <init>(android.content.Context, java.lang.Boolean);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
 }

 #okhttp
  -dontwarn okhttp3.**
  -keep class okhttp3.**{*;}

  #okio
  -dontwarn okio.**
  -keep class okio.**{*;}

  #okgo
  -dontwarn com.lzy.okgo.**
  -keep class com.lzy.okgo.**{*;}

  #okrx
  -dontwarn com.lzy.okrx.**
  -keep class com.lzy.okrx.**{*;}

  #okrx2
  -dontwarn com.lzy.okrx2.**
  -keep class com.lzy.okrx2.**{*;}

  #okserver
  -dontwarn com.lzy.okserver.**
  -keep class com.lzy.okserver.**{*;}

  -keep public class com.anythink.**
  -keepclassmembers class com.anythink.** {
     *;
  }

  -keep public class com.anythink.network.**
  -keepclassmembers class com.anythink.network.** {
     public *;
  }

  -dontwarn com.anythink.hb.**
  -keep class com.anythink.hb.**{ *;}

  -dontwarn com.anythink.china.api.**
  -keep class com.anythink.china.api.**{ *;}

  # new in v5.6.6
  -keep class com.anythink.myoffer.ui.**{ *;}
  -keepclassmembers public class com.anythink.myoffer.ui.** {
     public *;
  }


  -keep class com.appsflyer.** { *; }
  -keep public class com.android.installreferrer.** { *; }

  -keep class com.adjust.sdk.** { *; }
  -keep class com.google.android.gms.common.ConnectionResult {
      int SUCCESS;
  }
  -keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
      com.google.android.gms.ads.identifier.AdvertisingIdClient$Info getAdvertisingIdInfo(android.content.Context);
  }
  -keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
      java.lang.String getId();
      boolean isLimitAdTrackingEnabled();
  }
  -keep public class com.android.installreferrer.** { *; }

