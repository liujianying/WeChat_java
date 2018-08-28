package com.tencent.b.a.a;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.Locale;
import java.util.TimeZone;

final class b {
    static a bvh;
    Integer bvi = null;
    String bvj = null;

    static class a {
        String aem;
        String bvk;
        String bvl;
        DisplayMetrics bvm;
        int bvn;
        String bvo;
        String bvp;
        String bvq;
        String bvr;
        int bvs;
        String bvt;
        String bvu;
        Context ctx;
        String imsi;
        String model;
        String packageName;
        String timezone;

        private a(Context context) {
            this.bvl = "2.21";
            this.bvn = VERSION.SDK_INT;
            this.model = Build.MODEL;
            this.bvo = Build.MANUFACTURER;
            this.aem = Locale.getDefault().getLanguage();
            this.bvp = "WX";
            this.bvs = 0;
            this.packageName = null;
            this.ctx = null;
            this.bvt = null;
            this.bvu = null;
            this.ctx = context.getApplicationContext();
            try {
                this.bvk = this.ctx.getPackageManager().getPackageInfo(this.ctx.getPackageName(), 0).versionName;
            } catch (NameNotFoundException e) {
            }
            this.bvm = new DisplayMetrics();
            ((WindowManager) this.ctx.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(this.bvm);
            if (s.o(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.bvq = telephonyManager.getSimOperator();
                    this.imsi = telephonyManager.getSubscriberId();
                }
            }
            this.timezone = TimeZone.getDefault().getID();
            this.bvr = s.aO(this.ctx);
            this.packageName = this.ctx.getPackageName();
            this.bvu = s.tV();
        }

        /* synthetic */ a(Context context, byte b) {
            this(context);
        }
    }

    private static synchronized a aE(Context context) {
        a aVar;
        synchronized (b.class) {
            if (bvh == null) {
                bvh = new a(context.getApplicationContext(), (byte) 0);
            }
            aVar = bvh;
        }
        return aVar;
    }

    public b(Context context) {
        try {
            aE(context);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                this.bvi = Integer.valueOf(telephonyManager.getNetworkType());
            }
            this.bvj = s.aP(context);
        } catch (Throwable th) {
        }
    }
}
