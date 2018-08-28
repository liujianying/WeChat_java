package com.google.android.gms.common;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.R;
import com.google.android.gms.c.t;
import com.google.android.gms.c.z;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.o;
import com.google.android.gms.common.j.a;
import com.google.android.gms.common.j.aw;
import com.tencent.mm.plugin.appbrand.s$l;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e {
    private static final Object aEv = new Object();
    @Deprecated
    public static final int aJF = 7887000;
    public static boolean aJH = false;
    public static boolean aJI = false;
    private static int aJJ = -1;
    private static String aJK = null;
    private static Integer aJL = null;
    static final AtomicBoolean aJM = new AtomicBoolean();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(int r10, android.app.Activity r11, android.support.v4.app.Fragment r12, android.content.DialogInterface.OnCancelListener r13) {
        /*
        r9 = 11;
        r8 = 3;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        if (r10 != 0) goto L_0x000c;
    L_0x0008:
        r0 = r4;
    L_0x0009:
        if (r0 != 0) goto L_0x01b0;
    L_0x000b:
        return r3;
    L_0x000c:
        r0 = com.google.android.gms.c.t.ar(r11);
        if (r0 == 0) goto L_0x0017;
    L_0x0012:
        r0 = 2;
        if (r10 != r0) goto L_0x0017;
    L_0x0015:
        r10 = 42;
    L_0x0017:
        r0 = 14;
        r0 = com.google.android.gms.c.z.dx(r0);
        if (r0 == 0) goto L_0x01e5;
    L_0x001f:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r1 = r11.getTheme();
        r5 = 16843529; // 0x1010309 float:2.3695736E-38 double:8.321809E-317;
        r1.resolveAttribute(r5, r0, r2);
        r1 = r11.getResources();
        r0 = r0.resourceId;
        r0 = r1.getResourceEntryName(r0);
        r1 = "Theme.Dialog.Alert";
        r0 = r1.equals(r0);
        if (r0 == 0) goto L_0x01e5;
    L_0x0041:
        r0 = new android.app.AlertDialog$Builder;
        r1 = 5;
        r0.<init>(r11, r1);
    L_0x0047:
        if (r0 != 0) goto L_0x004e;
    L_0x0049:
        r0 = new android.app.AlertDialog$Builder;
        r0.<init>(r11);
    L_0x004e:
        r5 = ai(r11);
        r6 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0097;
            case 2: goto L_0x0101;
            case 3: goto L_0x00e9;
            case 5: goto L_0x012d;
            case 7: goto L_0x0125;
            case 9: goto L_0x0119;
            case 16: goto L_0x0135;
            case 17: goto L_0x0141;
            case 18: goto L_0x00f5;
            case 42: goto L_0x010d;
            default: goto L_0x0059;
        };
    L_0x0059:
        r1 = com.google.android.gms.R.string.common_google_play_services_unknown_issue;
        r1 = r6.getString(r1);
    L_0x005f:
        r0.setMessage(r1);
        if (r13 == 0) goto L_0x0067;
    L_0x0064:
        r0.setOnCancelListener(r13);
    L_0x0067:
        r5 = dj(r10);
        if (r12 != 0) goto L_0x0149;
    L_0x006d:
        r1 = new com.google.android.gms.common.internal.i;
        r1.<init>(r11, r5);
    L_0x0072:
        r5 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0150;
            case 2: goto L_0x0160;
            case 3: goto L_0x0158;
            case 42: goto L_0x0160;
            default: goto L_0x0079;
        };
    L_0x0079:
        r6 = 17039370; // 0x104000a float:2.42446E-38 double:8.4185673E-317;
        r5 = r5.getString(r6);
    L_0x0080:
        if (r5 == 0) goto L_0x0085;
    L_0x0082:
        r0.setPositiveButton(r5, r1);
    L_0x0085:
        r1 = r11.getResources();
        switch(r10) {
            case 1: goto L_0x0168;
            case 2: goto L_0x0180;
            case 3: goto L_0x0170;
            case 4: goto L_0x008c;
            case 5: goto L_0x01a0;
            case 6: goto L_0x008c;
            case 7: goto L_0x0198;
            case 8: goto L_0x008c;
            case 9: goto L_0x0190;
            case 10: goto L_0x008c;
            case 11: goto L_0x008c;
            case 16: goto L_0x008c;
            case 17: goto L_0x01a8;
            case 18: goto L_0x0178;
            case 42: goto L_0x0188;
            default: goto L_0x008c;
        };
    L_0x008c:
        if (r4 == 0) goto L_0x0091;
    L_0x008e:
        r0.setTitle(r4);
    L_0x0091:
        r0 = r0.create();
        goto L_0x0009;
    L_0x0097:
        if (r6 == 0) goto L_0x00db;
    L_0x0099:
        r1 = r6.getConfiguration();
        r1 = r1.screenLayout;
        r1 = r1 & 15;
        if (r1 <= r8) goto L_0x00d5;
    L_0x00a3:
        r1 = r2;
    L_0x00a4:
        r7 = com.google.android.gms.c.z.dx(r9);
        if (r7 == 0) goto L_0x00ac;
    L_0x00aa:
        if (r1 != 0) goto L_0x00c7;
    L_0x00ac:
        r1 = r6.getConfiguration();
        r7 = 13;
        r7 = com.google.android.gms.c.z.dx(r7);
        if (r7 == 0) goto L_0x00d9;
    L_0x00b8:
        r7 = r1.screenLayout;
        r7 = r7 & 15;
        if (r7 > r8) goto L_0x00d7;
    L_0x00be:
        r1 = r1.smallestScreenWidthDp;
        r7 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r1 < r7) goto L_0x00d7;
    L_0x00c4:
        r1 = r2;
    L_0x00c5:
        if (r1 == 0) goto L_0x00db;
    L_0x00c7:
        r1 = r2;
    L_0x00c8:
        if (r1 == 0) goto L_0x00dd;
    L_0x00ca:
        r1 = com.google.android.gms.R.string.common_google_play_services_install_text_tablet;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x00d5:
        r1 = r3;
        goto L_0x00a4;
    L_0x00d7:
        r1 = r3;
        goto L_0x00c5;
    L_0x00d9:
        r1 = r3;
        goto L_0x00c5;
    L_0x00db:
        r1 = r3;
        goto L_0x00c8;
    L_0x00dd:
        r1 = com.google.android.gms.R.string.common_google_play_services_install_text_phone;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x00e9:
        r1 = com.google.android.gms.R.string.common_google_play_services_enable_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x00f5:
        r1 = com.google.android.gms.R.string.common_google_play_services_updating_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x0101:
        r1 = com.google.android.gms.R.string.common_google_play_services_update_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x010d:
        r1 = com.google.android.gms.R.string.common_android_wear_update_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x0119:
        r1 = com.google.android.gms.R.string.common_google_play_services_unsupported_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x0125:
        r1 = com.google.android.gms.R.string.common_google_play_services_network_error_text;
        r1 = r6.getString(r1);
        goto L_0x005f;
    L_0x012d:
        r1 = com.google.android.gms.R.string.common_google_play_services_invalid_account_text;
        r1 = r6.getString(r1);
        goto L_0x005f;
    L_0x0135:
        r1 = com.google.android.gms.R.string.common_google_play_services_api_unavailable_text;
        r7 = new java.lang.Object[r2];
        r7[r3] = r5;
        r1 = r6.getString(r1, r7);
        goto L_0x005f;
    L_0x0141:
        r1 = com.google.android.gms.R.string.common_google_play_services_sign_in_failed_text;
        r1 = r6.getString(r1);
        goto L_0x005f;
    L_0x0149:
        r1 = new com.google.android.gms.common.internal.i;
        r1.<init>(r12, r5);
        goto L_0x0072;
    L_0x0150:
        r6 = com.google.android.gms.R.string.common_google_play_services_install_button;
        r5 = r5.getString(r6);
        goto L_0x0080;
    L_0x0158:
        r6 = com.google.android.gms.R.string.common_google_play_services_enable_button;
        r5 = r5.getString(r6);
        goto L_0x0080;
    L_0x0160:
        r6 = com.google.android.gms.R.string.common_google_play_services_update_button;
        r5 = r5.getString(r6);
        goto L_0x0080;
    L_0x0168:
        r4 = com.google.android.gms.R.string.common_google_play_services_install_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0170:
        r4 = com.google.android.gms.R.string.common_google_play_services_enable_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0178:
        r4 = com.google.android.gms.R.string.common_google_play_services_updating_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0180:
        r4 = com.google.android.gms.R.string.common_google_play_services_update_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0188:
        r4 = com.google.android.gms.R.string.common_android_wear_update_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0190:
        r4 = com.google.android.gms.R.string.common_google_play_services_unsupported_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x0198:
        r4 = com.google.android.gms.R.string.common_google_play_services_network_error_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x01a0:
        r4 = com.google.android.gms.R.string.common_google_play_services_invalid_account_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x01a8:
        r4 = com.google.android.gms.R.string.common_google_play_services_sign_in_failed_title;
        r4 = r1.getString(r4);
        goto L_0x008c;
    L_0x01b0:
        r1 = r11 instanceof android.support.v4.app.FragmentActivity;
        if (r1 == 0) goto L_0x01c7;
    L_0x01b4:
        r11 = (android.support.v4.app.FragmentActivity) r11;
        r1 = r11.getSupportFragmentManager();
        r0 = com.google.android.gms.common.f.b(r0, r13);
        r3 = "GooglePlayServicesErrorDialog";
        r0.a(r1, r3);
    L_0x01c4:
        r3 = r2;
        goto L_0x000b;
    L_0x01c7:
        r1 = com.google.android.gms.c.z.dx(r9);
        if (r1 == 0) goto L_0x01dc;
    L_0x01cd:
        r1 = r11.getFragmentManager();
        r0 = com.google.android.gms.common.a.a(r0, r13);
        r3 = "GooglePlayServicesErrorDialog";
        r0.show(r1, r3);
        goto L_0x01c4;
    L_0x01dc:
        r0 = new java.lang.RuntimeException;
        r1 = "This Activity does not support Fragments.";
        r0.<init>(r1);
        throw r0;
    L_0x01e5:
        r0 = r4;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.e.a(int, android.app.Activity, android.support.v4.app.Fragment, android.content.DialogInterface$OnCancelListener):boolean");
    }

    public static boolean a(Context context, int i, String str) {
        if (z.dx(19)) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
        if (packagesForUid == null) {
            return false;
        }
        for (Object equals : packagesForUid) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(PackageManager packageManager) {
        synchronized (aEv) {
            if (aJJ == -1) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
                    k.pM();
                    if (k.a(packageInfo, new a[]{j.aQk[1]}) != null) {
                        aJJ = 1;
                    } else {
                        aJJ = 0;
                    }
                } catch (NameNotFoundException e) {
                    aJJ = 0;
                }
            }
        }
        return aJJ != 0;
    }

    @Deprecated
    public static int ae(Context context) {
        if (f.aNr) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            Integer num;
            synchronized (aEv) {
                if (aJK == null) {
                    aJK = context.getPackageName();
                    try {
                        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            aJL = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                        } else {
                            aJL = null;
                        }
                    } catch (Throwable e) {
                        Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                    }
                } else if (!aJK.equals(context.getPackageName())) {
                    throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + aJK + "' and this call used package '" + context.getPackageName() + "'.");
                }
                num = aJL;
            }
            if (num == null) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (num.intValue() != aJF) {
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + aJF + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            k.pM();
            if (!t.dw(packageInfo.versionCode) && !t.ar(context)) {
                try {
                    if (k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.aQo) == null) {
                        return 9;
                    }
                    if (k.a(packageInfo, new a[]{k.a(packageManager.getPackageInfo("com.android.vending", 64), aw.aQo)}) == null) {
                        return 9;
                    }
                } catch (NameNotFoundException e2) {
                    if (!k(context, "com.android.vending") || k.a(packageInfo, aw.aQo) == null) {
                        return 9;
                    }
                }
            } else if (k.a(packageInfo, aw.aQo) == null) {
                return 9;
            }
            if (t.dv(packageInfo.versionCode) < t.dv(aJF)) {
                new StringBuilder("Google Play services out of date.  Requires ").append(aJF).append(" but found ").append(packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (NameNotFoundException e3) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e4) {
            return 1;
        }
    }

    @Deprecated
    public static void af(Context context) {
        if (!aJM.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    @Deprecated
    public static void ag(Context context) {
        int ae = ae(context);
        if (ae != 0) {
            Intent dj = dj(ae);
            if (dj == null) {
                throw new c(ae);
            }
            throw new d(ae, "Google Play Services not available", dj);
        }
    }

    public static Context ah(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    private static String ai(Context context) {
        Object obj = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(obj)) {
            return obj;
        }
        ApplicationInfo applicationInfo;
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static boolean b(PackageManager packageManager) {
        if (!a(packageManager)) {
            if (aJH ? aJI : "user".equals(Build.TYPE)) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static Intent dj(int i) {
        switch (i) {
            case 1:
            case 2:
                return o.bf("com.google.android.gms");
            case 3:
                return o.be("com.google.android.gms");
            case s$l.AppCompatTheme_dialogTheme /*42*/:
                return o.pp();
            default:
                return null;
        }
    }

    @Deprecated
    public static boolean dk(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean k(Context context, String str) {
        if (z.dx(21)) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            if (context.getPackageManager().getApplicationInfo(str, 8192).enabled) {
                return true;
            }
        } catch (NameNotFoundException e) {
        }
        return false;
    }

    @Deprecated
    public static boolean p(Context context, int i) {
        return i == 18 ? true : i == 1 ? k(context, "com.google.android.gms") : false;
    }

    public static boolean q(Context context, int i) {
        if (a(context, i, "com.google.android.gms")) {
            k.pM();
            if (k.a(context.getPackageManager(), "com.google.android.gms")) {
                return true;
            }
        }
        return false;
    }
}
