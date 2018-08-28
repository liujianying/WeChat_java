package c.t.m.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.Locale;

class ct$2 implements Runnable {
    private /* synthetic */ ct a;

    ct$2(ct ctVar) {
        this.a = ctVar;
    }

    public final void run() {
        ct ctVar = this.a;
        try {
            String charSequence;
            cu cuVar = ctVar.b;
            PackageInfo e = ctVar.e();
            int i = e.versionCode;
            cuVar.h = e.versionName;
            CharSequence loadLabel = ctVar.a.getApplicationInfo().loadLabel(ctVar.d);
            if (loadLabel != null) {
                charSequence = loadLabel.toString();
            } else {
                charSequence = "unknown";
            }
            cuVar.i = charSequence;
            try {
                TelephonyManager telephonyManager = ctVar.e;
                if (telephonyManager != null) {
                    int[] iArr = new int[2];
                    ec.a(telephonyManager, iArr);
                    cuVar.j = iArr[0];
                    cuVar.k = iArr[1];
                    cuVar.a = telephonyManager.getPhoneType();
                    ctVar.i = eh.a(telephonyManager.getDeviceId(), eh.a).toUpperCase(Locale.ENGLISH);
                    String a = eh.a(telephonyManager.getSubscriberId(), eh.b);
                    charSequence = eh.a(telephonyManager.getLine1Number(), eh.c);
                    cuVar.b = ctVar.i;
                    cuVar.c = a;
                    cuVar.d = charSequence;
                }
            } catch (Throwable th) {
            }
            cuVar.e = eh.a(ctVar.f().replaceAll(":", "").toUpperCase(Locale.ENGLISH), eh.d);
            PackageManager packageManager = ctVar.d;
            boolean hasSystemFeature = packageManager.hasSystemFeature("android.hardware.location.gps");
            boolean hasSystemFeature2 = packageManager.hasSystemFeature("android.hardware.wifi");
            new StringBuilder("doInBg: hasGps=").append(hasSystemFeature).append(",hasWifi=").append(hasSystemFeature2).append(",hasCell=").append(packageManager.hasSystemFeature("android.hardware.telephony"));
            new StringBuilder("os:").append(Build.MODEL).append(" ").append(VERSION.RELEASE).append(" ").append(cuVar.a()).append(" net:").append(cuVar.j).append(" ").append(cuVar.k).append(" app:").append(e.versionCode).append(" ").append(e.versionName).append(" sdk: ").append(cuVar.d()).append(" ").append(cuVar.e());
        } catch (Throwable th2) {
        }
        ct.a(this.a).countDown();
    }
}
