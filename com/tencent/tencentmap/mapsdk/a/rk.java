package com.tencent.tencentmap.mapsdk.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.net.URLEncoder;

public class rk {
    private final String a = rk.class.getSimpleName();
    private StringBuffer b = new StringBuffer(TbsListener$ErrorCode.ERROR_CODE_LOAD_BASE);
    private boolean c = false;

    public rk() {
        String encode;
        String charSequence;
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        int i3;
        String str = null;
        try {
            encode = URLEncoder.encode(sz.a(sl.a()), "UTF-8");
            this.b.append("key=");
            this.b.append(encode);
        } catch (Exception e) {
        }
        this.b.append("&output=json");
        this.b.append("&pf=and_2Dmap");
        this.b.append("&ver=");
        try {
            this.b.append(URLEncoder.encode("1.3.1.e70cce6", "UTF-8"));
        } catch (Exception e2) {
        }
        try {
            this.b.append("&hm=");
            this.b.append(URLEncoder.encode(Build.MODEL, "UTF-8"));
            this.b.append("&os=A");
            this.b.append(VERSION.SDK_INT);
            this.b.append("&pid=");
            this.b.append(URLEncoder.encode(sl.a().getPackageName(), "UTF-8"));
            this.b.append("&nt=");
            StringBuffer stringBuffer = this.b;
            ConnectivityManager connectivityManager = (ConnectivityManager) sl.a().getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                encode = activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : "";
            } else {
                encode = "";
            }
            stringBuffer.append(URLEncoder.encode(encode));
        } catch (Exception e3) {
        }
        this.b.append("&suid=");
        this.b.append(b());
        try {
            PackageManager packageManager = sl.a().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(sl.a().getPackageName(), 0);
            charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            try {
                CharSequence charSequence2 = packageInfo.versionName;
                if (TextUtils.isEmpty(charSequence2)) {
                    charSequence2 = null;
                }
                str = charSequence2;
            } catch (Exception e4) {
                encode = charSequence;
            }
        } catch (Exception e5) {
            encode = null;
        }
        if (charSequence != null) {
            this.b.append("&ref=");
            try {
                this.b.append(URLEncoder.encode(charSequence, "UTF-8"));
            } catch (Exception e6) {
            }
        }
        if (str != null) {
            this.b.append("&psv=");
            try {
                this.b.append(URLEncoder.encode(str, "UTF-8"));
            } catch (Exception e7) {
            }
        }
        try {
            displayMetrics = sl.a().getResources().getDisplayMetrics();
            i = displayMetrics.densityDpi;
            i2 = displayMetrics.widthPixels;
            i3 = displayMetrics.heightPixels;
            this.b.append("&dpi=");
            this.b.append(i);
            this.b.append("&scrn=");
            this.b.append(i2);
            this.b.append("*");
            this.b.append(i3);
        } catch (Exception e8) {
            return;
        }
        charSequence = encode;
        if (charSequence != null) {
            this.b.append("&ref=");
            try {
                this.b.append(URLEncoder.encode(charSequence, "UTF-8"));
            } catch (Exception e62) {
            }
        }
        if (str != null) {
            this.b.append("&psv=");
            try {
                this.b.append(URLEncoder.encode(str, "UTF-8"));
            } catch (Exception e72) {
            }
        }
        displayMetrics = sl.a().getResources().getDisplayMetrics();
        i = displayMetrics.densityDpi;
        i2 = displayMetrics.widthPixels;
        i3 = displayMetrics.heightPixels;
        this.b.append("&dpi=");
        this.b.append(i);
        this.b.append("&scrn=");
        this.b.append(i2);
        this.b.append("*");
        this.b.append(i3);
    }

    @SuppressLint({"NewApi"})
    public static String b() {
        Object obj = "";
        Context a = sl.a();
        if (VERSION.SDK_INT < 23 || (a != null && a.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            obj = ((TelephonyManager) a.getSystemService("phone")).getDeviceId();
        }
        return TextUtils.isEmpty(obj) ? "noIMEI" : obj;
    }

    public final void a() {
        if (!this.c) {
            new 1(this).start();
        }
    }

    public final String c() {
        return this.b == null ? "" : this.b.toString();
    }
}
