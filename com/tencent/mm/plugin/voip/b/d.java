package com.tencent.mm.plugin.voip.b;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.widget.Toast;
import com.tencent.mm.g.a.au;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.g.a.su;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class d {
    public static Context oSX = null;
    private static final String oSY;
    private static final Uri oSZ = Uri.parse("content://com.lbe.security.miui.permmgr/active");

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VERSION.RELEASE:[" + VERSION.RELEASE);
        stringBuilder.append("] VERSION.CODENAME:[" + VERSION.CODENAME);
        stringBuilder.append("] VERSION.INCREMENTAL:[" + VERSION.INCREMENTAL);
        stringBuilder.append("] BOARD:[" + Build.BOARD);
        stringBuilder.append("] DEVICE:[" + Build.DEVICE);
        stringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
        stringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
        stringBuilder.append("] HOST:[" + Build.HOST);
        stringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
        stringBuilder.append("] MODEL:[" + Build.MODEL);
        stringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
        stringBuilder.append("] TAGS:[" + Build.TAGS);
        stringBuilder.append("] TYPE:[" + Build.TYPE);
        stringBuilder.append("] USER:[" + Build.USER + "]");
        oSY = stringBuilder.toString();
    }

    public static boolean bLP() {
        return true;
    }

    public static int bLQ() {
        return VERSION.SDK_INT;
    }

    private static boolean bLR() {
        boolean z = false;
        FileInputStream fileInputStream;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
            try {
                properties.load(fileInputStream);
                String property = properties.getProperty("ro.miui.ui.version.name", null);
                if (property != null && property.equals("V6")) {
                    z = true;
                }
            } catch (IOException e) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                x.d("VoipUtil", "isMIUIv6 " + z);
                return z;
            }
        } catch (IOException e3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e22) {
                }
            }
            x.d("VoipUtil", "isMIUIv6 " + z);
            return z;
        }
        x.d("VoipUtil", "isMIUIv6 " + z);
        return z;
    }

    public static boolean em(Context context) {
        boolean z = false;
        if (bLR()) {
            z = ep(context);
        }
        x.d("VoipUtil", "isLbePermissionEnable ret:" + z);
        return z;
    }

    public static boolean en(Context context) {
        boolean z = false;
        if (bLR()) {
            z = eo(context);
        }
        x.d("VoipUtil", "setLbePermissionEnable ret:" + z);
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean eo(android.content.Context r12) {
        /*
        r11 = 2;
        r9 = 0;
        r10 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r7 = 1;
        r8 = 0;
        r6 = -1;
        r0 = r12.getContentResolver();	 Catch:{ Throwable -> 0x00a9, all -> 0x00cc }
        r1 = oSZ;	 Catch:{ Throwable -> 0x00f1, all -> 0x00cc }
        r2 = 1;
        r2 = new java.lang.String[r2];	 Catch:{ Throwable -> 0x00f1, all -> 0x00cc }
        r3 = 0;
        r4 = "userAccept";
        r2[r3] = r4;	 Catch:{ Throwable -> 0x00f1, all -> 0x00cc }
        r3 = "pkgName='com.tencent.mm'";
        r4 = 0;
        r5 = 0;
        r2 = r0.query(r1, r2, r3, r4, r5);	 Catch:{ Throwable -> 0x00f1, all -> 0x00cc }
        if (r2 == 0) goto L_0x00fb;
    L_0x0021:
        r1 = r2.getCount();	 Catch:{ Throwable -> 0x00f4 }
        if (r1 <= 0) goto L_0x00fb;
    L_0x0027:
        r1 = r2.moveToLast();	 Catch:{ Throwable -> 0x00f4 }
        if (r1 == 0) goto L_0x00fb;
    L_0x002d:
        r1 = 0;
        r6 = r2.getInt(r1);	 Catch:{ Throwable -> 0x00f4 }
        r1 = r6;
    L_0x0033:
        if (r2 == 0) goto L_0x0038;
    L_0x0035:
        r2.close();
    L_0x0038:
        r2 = "VoipUtil";
        r3 = "setLbePermissionEnable query ua: ";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r1);
        r4[r8] = r5;
        r5 = " flag: ";
        r4[r7] = r5;
        r5 = java.lang.Integer.valueOf(r10);
        r4[r11] = r5;
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);
        r2 = -1;
        r3 = -1;
        if (r1 == r3) goto L_0x00f6;
    L_0x0059:
        if (r0 == 0) goto L_0x00f6;
    L_0x005b:
        r1 = r1 | r10;
        r3 = new android.content.ContentValues;	 Catch:{ Throwable -> 0x00d4 }
        r3.<init>();	 Catch:{ Throwable -> 0x00d4 }
        r4 = "userAccept";
        r5 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00d4 }
        r3.put(r4, r5);	 Catch:{ Throwable -> 0x00d4 }
        r4 = oSZ;	 Catch:{ Throwable -> 0x00d4 }
        r5 = "pkgName='com.tencent.mm'";
        r6 = 0;
        r0 = r0.update(r4, r3, r5, r6);	 Catch:{ Throwable -> 0x00d4 }
        r2 = "VoipUtil";
        r3 = "serLbePermissionEnable update ua: ";
        r4 = 5;
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x00ec }
        r5 = 0;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x00ec }
        r4[r5] = r1;	 Catch:{ Throwable -> 0x00ec }
        r1 = 1;
        r5 = " flag: ";
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00ec }
        r1 = 2;
        r5 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x00ec }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00ec }
        r1 = 3;
        r5 = " ret: ";
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00ec }
        r1 = 4;
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x00ec }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x00ec }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ Throwable -> 0x00ec }
    L_0x00a4:
        r2 = r0;
    L_0x00a5:
        if (r2 <= 0) goto L_0x00ea;
    L_0x00a7:
        r0 = r7;
    L_0x00a8:
        return r0;
    L_0x00a9:
        r1 = move-exception;
        r2 = r9;
        r0 = r9;
    L_0x00ac:
        r3 = "VoipUtil";
        r4 = "isLbePermissionEnable query ";
        r5 = 2;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00ef }
        r9 = 0;
        r5[r9] = r1;	 Catch:{ all -> 0x00ef }
        r1 = 1;
        r9 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x00ef }
        r5[r1] = r9;	 Catch:{ all -> 0x00ef }
        com.tencent.mm.sdk.platformtools.x.w(r3, r4, r5);	 Catch:{ all -> 0x00ef }
        if (r2 == 0) goto L_0x00f8;
    L_0x00c6:
        r2.close();
        r1 = r6;
        goto L_0x0038;
    L_0x00cc:
        r0 = move-exception;
        r2 = r9;
    L_0x00ce:
        if (r2 == 0) goto L_0x00d3;
    L_0x00d0:
        r2.close();
    L_0x00d3:
        throw r0;
    L_0x00d4:
        r0 = move-exception;
        r1 = r0;
    L_0x00d6:
        r0 = "VoipUtil";
        r3 = "isLbePermissionEnable update ";
        r4 = new java.lang.Object[r11];
        r4[r8] = r1;
        r1 = java.lang.Integer.valueOf(r10);
        r4[r7] = r1;
        com.tencent.mm.sdk.platformtools.x.w(r0, r3, r4);
        goto L_0x00a5;
    L_0x00ea:
        r0 = r8;
        goto L_0x00a8;
    L_0x00ec:
        r1 = move-exception;
        r2 = r0;
        goto L_0x00d6;
    L_0x00ef:
        r0 = move-exception;
        goto L_0x00ce;
    L_0x00f1:
        r1 = move-exception;
        r2 = r9;
        goto L_0x00ac;
    L_0x00f4:
        r1 = move-exception;
        goto L_0x00ac;
    L_0x00f6:
        r0 = r2;
        goto L_0x00a4;
    L_0x00f8:
        r1 = r6;
        goto L_0x0038;
    L_0x00fb:
        r1 = r6;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.b.d.eo(android.content.Context):boolean");
    }

    private static boolean ep(Context context) {
        Throwable th;
        Cursor query;
        try {
            query = context.getContentResolver().query(oSZ, new String[]{"suggestAccept", "userAccept", "userPrompt", "userReject"}, "pkgName='com.tencent.mm'", null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0 && query.moveToLast()) {
                        boolean z = ((query.getInt(0) & 131072) == 131072 && (query.getInt(2) & 131072) == 0 && (query.getInt(3) & 131072) == 0) || (query.getInt(1) & 131072) == 131072;
                        if (query == null) {
                            return z;
                        }
                        query.close();
                        return z;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        x.w("gray", "isLbePermissionEnable", new Object[]{th, Integer.valueOf(131072)});
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th4) {
            th = th4;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return false;
    }

    public static void O(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    public static int oH(String str) {
        int i = 0;
        try {
            return bi.getInt(g.AT().getValue(str), 0);
        } catch (Exception e) {
            x.e("VoipUtil", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public static boolean bLS() {
        ax axVar = new ax();
        a.sFg.m(axVar);
        return axVar.bIs.bwu;
    }

    public static boolean bLT() {
        su suVar = new su();
        suVar.cdE.bOh = 2;
        a.sFg.m(suVar);
        return suVar.cdF.cdG;
    }

    public static boolean bLU() {
        bg bgVar = new bg();
        a.sFg.m(bgVar);
        return bgVar.bIM.bwu;
    }

    public static boolean bLV() {
        au auVar = new au();
        a.sFg.m(auVar);
        return auVar.bIm.bIn;
    }

    public static Notification a(Builder builder) {
        if (com.tencent.mm.compatible.util.d.fS(16)) {
            return builder.getNotification();
        }
        return builder.build();
    }
}
