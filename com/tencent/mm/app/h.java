package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.loader.stub.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class h {
    public static String a(final Application application, final String str) {
        if (!"com.tencent.mm:cuploader".equals(str)) {
            ak.a(new d() {
                public final void a(ak akVar, String str, Throwable th) {
                    Context context = application;
                    String str2 = str;
                    try {
                        StringBuilder stringBuilder = new StringBuilder(2560);
                        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
                        stringBuilderPrinter.println("#client.version=" + a.CLIENT_VERSION);
                        if (a.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.revision=123321123");
                        } else {
                            stringBuilderPrinter.println("#accinfo.revision=" + a.codeRevision());
                        }
                        String I = c.duQ.I("last_login_uin", "0");
                        if (I == null || I.equals("0")) {
                            I = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
                        }
                        stringBuilderPrinter.println("#accinfo.uin=" + I);
                        StringBuilder append = new StringBuilder("#accinfo.runtime=").append(bi.VF() - b.bya).append("(");
                        if (str2 == null) {
                            str2 = "";
                        }
                        stringBuilderPrinter.println(append.append(str2).append(") by cup").toString());
                        if (a.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.build=99/88/2077 66:55 PM:amm-dev");
                        } else {
                            stringBuilderPrinter.println("#accinfo.build=" + a.TIME + ":" + a.HOSTNAME + ":0");
                        }
                        I = "";
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            StatFs statFs2 = new StatFs(b.bnC);
                            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
                            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
                            str2 = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), b.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
                        } catch (Exception e) {
                            str2 = I;
                        }
                        p.b(th);
                        stringBuilderPrinter.println("#accinfo.data=" + str2);
                        Date date = new Date();
                        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
                        stringBuilderPrinter.println("#crashContent=");
                        if (f.aV(ad.getContext()) == 1) {
                            str = str.substring(0, f.aW(ad.getContext()));
                        }
                        f.g(ad.getContext(), ad.getProcessName(), "first");
                        stringBuilderPrinter.println(str);
                        x.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:" + str);
                        Intent intent = new Intent();
                        intent.setAction("INTENT_ACTION_UNCATCH");
                        intent.putExtra("INTENT_EXTRA_USER_NAME", c.duQ.I("login_user_name", "never_login_crash"));
                        intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                        intent.putExtra("INTENT_EXTRA_DATA_PATH", b.duN + "crash/");
                        intent.putExtra("INTENT_EXTRA_SDCARD_PATH", b.duP);
                        intent.putExtra("INTENT_EXTRA_UIN", c.duQ.I("last_login_uin", "0"));
                        intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", a.CLIENT_VERSION);
                        intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", a.DEVICE_TYPE);
                        intent.putExtra("INTENT_EXTRA_TAG", "exception");
                        String str3 = "INTENT_EXTRA_HOST";
                        intent.putExtra(str3, "http://" + context.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com"));
                        intent.setClassName(context, context.getPackageName() + ".crash.CrashUploaderService");
                        ad.getContext().startService(intent);
                    } catch (Exception e2) {
                    }
                }
            });
            ak.a(new ak.a() {
                public final void uV() {
                    String str = a.PATCH_REV;
                }
            });
        }
        return str;
    }
}
