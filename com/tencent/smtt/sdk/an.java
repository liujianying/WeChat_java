package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.v;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class an {
    public static ThreadLocal<Integer> a = new ao();
    static boolean b = false;
    static final FileFilter c = new ap();
    private static an d = null;
    private static final ReentrantLock i = new ReentrantLock();
    private static final Lock j = new ReentrantLock();
    private static FileLock l = null;
    private static Handler m = null;
    private static final Long[][] n;
    private static int o = 0;
    private static boolean p = false;
    private int e = 0;
    private FileLock f;
    private FileOutputStream g;
    private boolean h = false;
    private boolean k = false;

    static {
        Long[][] lArr = new Long[9][];
        lArr[0] = new Long[]{Long.valueOf(44006), Long.valueOf(39094008)};
        lArr[1] = new Long[]{Long.valueOf(44005), Long.valueOf(39094008)};
        lArr[2] = new Long[]{Long.valueOf(43910), Long.valueOf(38917816)};
        lArr[3] = new Long[]{Long.valueOf(44027), Long.valueOf(39094008)};
        lArr[4] = new Long[]{Long.valueOf(44028), Long.valueOf(39094008)};
        lArr[5] = new Long[]{Long.valueOf(44029), Long.valueOf(39094008)};
        lArr[6] = new Long[]{Long.valueOf(44030), Long.valueOf(39094008)};
        lArr[7] = new Long[]{Long.valueOf(44032), Long.valueOf(39094008)};
        lArr[8] = new Long[]{Long.valueOf(43909), Long.valueOf(38917816)};
        n = lArr;
    }

    private an() {
        if (m == null) {
            m = new aq(this, al.a().getLooper());
        }
    }

    private void A(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (z(context)) {
            try {
                C(context);
                D(context);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    TbsShareManager.a(context);
                }
                ai.a(context).a(0);
                ai.a(context).b(0);
                ai.a(context).d(0);
                ai.a(context).a("incrupdate_retry_num", 0);
                ai.a(context).b(0, 3);
                ai.a(context).a("");
                ai.a(context).c(-1);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == a().h(context) || i != a().i(context)) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                    } else {
                        n(context);
                    }
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsShareManager.writeCoreInfoForThirdPartyApp(context, m(context), true);
                }
                a.set(Integer.valueOf(0));
                o = 0;
            } catch (Throwable th) {
                TbsLogReport.a(context).a(219, "exception when renameing from unzip:" + th.toString());
                TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
            }
            y(context);
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    private void B(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (z(context)) {
            try {
                C(context);
                E(context);
                TbsShareManager.a(context);
                ai.a(context).a(0, 3);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == a().h(context) || i != a().i(context)) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + a().h(context) + " getTbsCoreInstalledVerInNolock is " + a().i(context));
                    } else {
                        n(context);
                    }
                }
                a.set(Integer.valueOf(0));
            } catch (Exception e) {
                TbsLogReport.a(context).a(219, "exception when renameing from copy:" + e.toString());
            }
            y(context);
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
    }

    private void C(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        j.a(q(context), false);
    }

    private void D(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File t = t(context);
        File q = q(context);
        if (t != null && q != null) {
            t.renameTo(q);
            f(context, false);
        }
    }

    private void E(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File v = v(context);
        File q = q(context);
        if (v != null && q != null) {
            v.renameTo(q);
            f(context, false);
        }
    }

    private void F(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File t = t(context);
        if (t != null) {
            j.a(t, false);
        }
        ai.a(context).b(0, 5);
        ai.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
    }

    static synchronized an a() {
        an anVar;
        synchronized (an.class) {
            if (d == null) {
                synchronized (an.class) {
                    if (d == null) {
                        d = new an();
                    }
                }
            }
            anVar = d;
        }
        return anVar;
    }

    private void a(int i, String str, Context context) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = null;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
                try {
                    properties.setProperty("tbs_local_installation", "true");
                    properties.store(bufferedOutputStream, null);
                    TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e22) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                bufferedOutputStream2 = null;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e52) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e222) {
                    }
                }
                throw th;
            }
        }
    }

    public static void a(Context context) {
        if (!x(context)) {
            if (d(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
            } else if (d(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
            } else if (d(context, "core_copy_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(11)
    private void a(android.content.Context r13, android.content.Context r14, int r15) {
        /*
        r12 = this;
        r2 = -1;
        r5 = 1;
        r6 = 0;
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);
        r1 = -524; // 0xfffffffffffffdf4 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);
        r0 = r12.c(r14);
        if (r0 == 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r3 = "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ";
        r1.<init>(r3);
        r1 = r1.append(r15);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x0067;
    L_0x002f:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);
    L_0x0037:
        r1 = "tbs_precheck_disable_version";
        r0 = r0.getInt(r1, r2);
        if (r0 != r15) goto L_0x006f;
    L_0x0040:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r2 = "TbsInstaller-copyTbsCoreInThread -- version:";
        r1.<init>(r2);
        r1 = r1.append(r15);
        r2 = " is disabled by preload_x5_check!";
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);
        r1 = -525; // 0xfffffffffffffdf3 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);
        goto L_0x0012;
    L_0x0067:
        r0 = "tbs_preloadx5_check_cfg_file";
        r0 = r14.getSharedPreferences(r0, r6);
        goto L_0x0037;
    L_0x006f:
        r0 = r12.w(r14);
        if (r0 != 0) goto L_0x007f;
    L_0x0075:
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);
        r1 = -526; // 0xfffffffffffffdf2 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);
        goto L_0x0012;
    L_0x007f:
        r0 = j;
        r0 = r0.tryLock();
        r1 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "TbsInstaller-copyTbsCoreInThread #1 locked is ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.i(r1, r3);
        if (r0 == 0) goto L_0x05b8;
    L_0x009d:
        r0 = i;
        r0.lock();
        r1 = 0;
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x05cf }
        r3 = "copy_core_ver";
        r3 = r0.c(r3);	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x05cf }
        r4 = "copy_status";
        r0 = r0.b(r4);	 Catch:{ Exception -> 0x05cf }
        if (r3 != r15) goto L_0x00da;
    L_0x00bb:
        r0 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ Exception -> 0x05cf }
        r2 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.onInstallFinish(r2);	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x05cf }
        r2 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.setInstallInterruptCode(r2);	 Catch:{ Exception -> 0x05cf }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
    L_0x00d5:
        r12.b();
        goto L_0x0012;
    L_0x00da:
        r4 = r12.i(r14);	 Catch:{ Exception -> 0x05cf }
        r7 = "TbsInstaller";
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05cf }
        r9 = "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=";
        r8.<init>(r9);	 Catch:{ Exception -> 0x05cf }
        r8 = r8.append(r4);	 Catch:{ Exception -> 0x05cf }
        r8 = r8.toString();	 Catch:{ Exception -> 0x05cf }
        com.tencent.smtt.utils.TbsLog.i(r7, r8);	 Catch:{ Exception -> 0x05cf }
        if (r4 != r15) goto L_0x0127;
    L_0x00f6:
        r0 = com.tencent.smtt.sdk.QbSdk.m;	 Catch:{ Exception -> 0x05cf }
        r2 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r0.onInstallFinish(r2);	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x05cf }
        r2 = -528; // 0xfffffffffffffdf0 float:NaN double:NaN;
        r0.setInstallInterruptCode(r2);	 Catch:{ Exception -> 0x05cf }
        r0 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05cf }
        r3 = "TbsInstaller-copyTbsCoreInThread return have same version is ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.toString();	 Catch:{ Exception -> 0x05cf }
        com.tencent.smtt.utils.TbsLog.i(r0, r2);	 Catch:{ Exception -> 0x05cf }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x0127:
        r7 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x05cf }
        r7 = r7.b();	 Catch:{ Exception -> 0x05cf }
        if (r7 <= 0) goto L_0x0133;
    L_0x0131:
        if (r15 > r7) goto L_0x0137;
    L_0x0133:
        if (r3 <= 0) goto L_0x013a;
    L_0x0135:
        if (r15 <= r3) goto L_0x013a;
    L_0x0137:
        r12.o(r14);	 Catch:{ Exception -> 0x05cf }
    L_0x013a:
        r3 = 3;
        if (r0 != r3) goto L_0x0154;
    L_0x013d:
        if (r4 <= 0) goto L_0x0154;
    L_0x013f:
        if (r15 > r4) goto L_0x0146;
    L_0x0141:
        r3 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;
        if (r15 != r3) goto L_0x0154;
    L_0x0146:
        r12.o(r14);	 Catch:{ Exception -> 0x05cf }
        r0 = "TbsInstaller";
        r3 = "TbsInstaller-copyTbsCoreInThread -- update TBS.....";
        r4 = 1;
        com.tencent.smtt.utils.TbsLog.i(r0, r3, r4);	 Catch:{ Exception -> 0x05cf }
        r0 = r2;
    L_0x0154:
        r2 = com.tencent.smtt.utils.j.b(r14);	 Catch:{ Exception -> 0x05cf }
        if (r2 != 0) goto L_0x019f;
    L_0x015a:
        r2 = com.tencent.smtt.utils.v.a();	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r14);	 Catch:{ Exception -> 0x05cf }
        r4 = r0.getDownloadMinFreeSpace();	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x05cf }
        r6 = -529; // 0xfffffffffffffdef float:NaN double:NaN;
        r0.setInstallInterruptCode(r6);	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x05cf }
        r6 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05cf }
        r8 = "rom is not enough when copying tbs core! curAvailROM=";
        r7.<init>(r8);	 Catch:{ Exception -> 0x05cf }
        r2 = r7.append(r2);	 Catch:{ Exception -> 0x05cf }
        r3 = ",minReqRom=";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.toString();	 Catch:{ Exception -> 0x05cf }
        r0.a(r6, r2);	 Catch:{ Exception -> 0x05cf }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x019f:
        if (r0 <= 0) goto L_0x01e3;
    L_0x01a1:
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r14);	 Catch:{ Exception -> 0x05cf }
        if (r2 != 0) goto L_0x01bd;
    L_0x01a7:
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r14);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.mPreferences;	 Catch:{ Exception -> 0x05cf }
        r3 = "tbs_downloaddecouplecore";
        r4 = 0;
        r2 = r2.getInt(r3, r4);	 Catch:{ Exception -> 0x05cf }
        if (r2 != r5) goto L_0x01bd;
    L_0x01b7:
        r2 = r12.h(r14);	 Catch:{ Exception -> 0x05cf }
        if (r15 != r2) goto L_0x01e3;
    L_0x01bd:
        r0 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05cf }
        r3 = "TbsInstaller-copyTbsCoreInThread return have copied is ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x05cf }
        r3 = r12.h(r14);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.toString();	 Catch:{ Exception -> 0x05cf }
        com.tencent.smtt.utils.TbsLog.i(r0, r2);	 Catch:{ Exception -> 0x05cf }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x01e3:
        if (r0 != 0) goto L_0x0220;
    L_0x01e5:
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x05cf }
        r2 = "copy_retry_num";
        r0 = r0.c(r2);	 Catch:{ Exception -> 0x05cf }
        r2 = 2;
        if (r0 <= r2) goto L_0x0214;
    L_0x01f3:
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x05cf }
        r2 = 211; // 0xd3 float:2.96E-43 double:1.042E-321;
        r3 = "exceed copy retry num!";
        r0.a(r2, r3);	 Catch:{ Exception -> 0x05cf }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x05cf }
        r2 = -530; // 0xfffffffffffffdee float:NaN double:NaN;
        r0.setInstallInterruptCode(r2);	 Catch:{ Exception -> 0x05cf }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x0214:
        r2 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x05cf }
        r3 = "copy_retry_num";
        r0 = r0 + 1;
        r2.a(r3, r0);	 Catch:{ Exception -> 0x05cf }
    L_0x0220:
        r0 = r12.q(r13);	 Catch:{ Exception -> 0x05cf }
        r2 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r14);	 Catch:{ Exception -> 0x05cf }
        if (r2 != 0) goto L_0x02d3;
    L_0x022a:
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r14);	 Catch:{ Exception -> 0x05cf }
        r2 = r2.mPreferences;	 Catch:{ Exception -> 0x05cf }
        r3 = "tbs_downloaddecouplecore";
        r4 = 0;
        r2 = r2.getInt(r3, r4);	 Catch:{ Exception -> 0x05cf }
        if (r2 != r5) goto L_0x02cd;
    L_0x023a:
        r3 = r12.p(r14);	 Catch:{ Exception -> 0x05cf }
    L_0x023e:
        if (r0 == 0) goto L_0x055c;
    L_0x0240:
        if (r3 == 0) goto L_0x055c;
    L_0x0242:
        r1 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r2 = 0;
        r1.a(r15, r2);	 Catch:{ Exception -> 0x03a9 }
        r1 = new com.tencent.smtt.utils.u;	 Catch:{ Exception -> 0x03a9 }
        r1.<init>();	 Catch:{ Exception -> 0x03a9 }
        r1.a(r0);	 Catch:{ Exception -> 0x03a9 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x03a9 }
        r2 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r4 = -551; // 0xfffffffffffffdd9 float:NaN double:NaN;
        r2.setInstallInterruptCode(r4);	 Catch:{ Exception -> 0x03a9 }
        r2 = c;	 Catch:{ Exception -> 0x03a9 }
        r2 = com.tencent.smtt.utils.j.a(r0, r3, r2);	 Catch:{ Exception -> 0x03a9 }
        r4 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r14);	 Catch:{ Exception -> 0x03a9 }
        r4 = r4.mPreferences;	 Catch:{ Exception -> 0x03a9 }
        r7 = "tbs_downloaddecouplecore";
        r10 = 0;
        r4 = r4.getInt(r7, r10);	 Catch:{ Exception -> 0x03a9 }
        if (r4 != r5) goto L_0x0278;
    L_0x0275:
        com.tencent.smtt.sdk.TbsShareManager.b(r14);	 Catch:{ Exception -> 0x03a9 }
    L_0x0278:
        r4 = "TbsInstaller";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r10 = "TbsInstaller-copyTbsCoreInThread time=";
        r7.<init>(r10);	 Catch:{ Exception -> 0x03a9 }
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x03a9 }
        r8 = r10 - r8;
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x03a9 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.i(r4, r7);	 Catch:{ Exception -> 0x03a9 }
        if (r2 == 0) goto L_0x0531;
    L_0x0296:
        r1.b(r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = r1.a();	 Catch:{ Exception -> 0x03a9 }
        if (r0 != 0) goto L_0x02d9;
    L_0x029f:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread copy-verify fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = 1;
        com.tencent.smtt.utils.j.a(r3, r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify fail after copying tbs core!";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -531; // 0xfffffffffffffded float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x02cd:
        r3 = r12.v(r14);	 Catch:{ Exception -> 0x05cf }
        goto L_0x023e;
    L_0x02d3:
        r3 = r12.v(r14);	 Catch:{ Exception -> 0x05cf }
        goto L_0x023e;
    L_0x02d9:
        r2 = 0;
        r1 = 0;
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0397, all -> 0x03a2 }
        r0 = "1";
        r4.<init>(r3, r0);	 Catch:{ Exception -> 0x0397, all -> 0x03a2 }
        r0 = new java.util.Properties;	 Catch:{ Exception -> 0x0397, all -> 0x03a2 }
        r0.<init>();	 Catch:{ Exception -> 0x0397, all -> 0x03a2 }
        r1 = r4.exists();	 Catch:{ Exception -> 0x05d6, all -> 0x03a2 }
        if (r1 == 0) goto L_0x0393;
    L_0x02ee:
        r7 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x05d6, all -> 0x03a2 }
        r7.<init>(r4);	 Catch:{ Exception -> 0x05d6, all -> 0x03a2 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x05d6, all -> 0x03a2 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x05d6, all -> 0x03a2 }
        r0.load(r1);	 Catch:{ Exception -> 0x05d9, all -> 0x05d2 }
        r4 = r5;
    L_0x02fc:
        if (r1 == 0) goto L_0x0301;
    L_0x02fe:
        r1.close();	 Catch:{ IOException -> 0x05cc }
    L_0x0301:
        r1 = r0;
    L_0x0302:
        if (r4 == 0) goto L_0x040b;
    L_0x0304:
        r2 = r3.listFiles();	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r7 = -552; // 0xfffffffffffffdd8 float:NaN double:NaN;
        r0.setInstallInterruptCode(r7);	 Catch:{ Exception -> 0x03a9 }
        r0 = r6;
    L_0x0312:
        r7 = r2.length;	 Catch:{ Exception -> 0x03a9 }
        if (r0 >= r7) goto L_0x040b;
    L_0x0315:
        r7 = r2[r0];	 Catch:{ Exception -> 0x03a9 }
        r8 = "1";
        r9 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x03a9 }
        if (r8 != 0) goto L_0x0390;
    L_0x0324:
        r8 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r9 = ".dex";
        r8 = r8.endsWith(r9);	 Catch:{ Exception -> 0x03a9 }
        if (r8 != 0) goto L_0x0390;
    L_0x0331:
        r8 = "tbs.conf";
        r9 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x03a9 }
        if (r8 != 0) goto L_0x0390;
    L_0x033e:
        r8 = r7.isDirectory();	 Catch:{ Exception -> 0x03a9 }
        if (r8 != 0) goto L_0x0390;
    L_0x0344:
        r8 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r9 = ".prof";
        r8 = r8.endsWith(r9);	 Catch:{ Exception -> 0x03a9 }
        if (r8 != 0) goto L_0x0390;
    L_0x0351:
        r8 = com.tencent.smtt.utils.a.a(r7);	 Catch:{ Exception -> 0x03a9 }
        r9 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r10 = "";
        r9 = r1.getProperty(r9, r10);	 Catch:{ Exception -> 0x03a9 }
        r10 = "";
        r10 = r9.equals(r10);	 Catch:{ Exception -> 0x03a9 }
        if (r10 != 0) goto L_0x03da;
    L_0x0369:
        r10 = r8.equals(r9);	 Catch:{ Exception -> 0x03a9 }
        if (r10 == 0) goto L_0x03da;
    L_0x036f:
        r8 = "TbsInstaller";
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r10 = "md5_check_success for (";
        r9.<init>(r10);	 Catch:{ Exception -> 0x03a9 }
        r7 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r7 = r9.append(r7);	 Catch:{ Exception -> 0x03a9 }
        r9 = ")";
        r7 = r7.append(r9);	 Catch:{ Exception -> 0x03a9 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.i(r8, r7);	 Catch:{ Exception -> 0x03a9 }
    L_0x0390:
        r0 = r0 + 1;
        goto L_0x0312;
    L_0x0393:
        r1 = r2;
        r4 = r6;
        goto L_0x02fc;
    L_0x0397:
        r0 = move-exception;
        r0 = r1;
    L_0x0399:
        if (r2 == 0) goto L_0x039e;
    L_0x039b:
        r2.close();	 Catch:{ IOException -> 0x05c6 }
    L_0x039e:
        r1 = r0;
        r4 = r5;
        goto L_0x0302;
    L_0x03a2:
        r0 = move-exception;
    L_0x03a3:
        if (r2 == 0) goto L_0x03a8;
    L_0x03a5:
        r2.close();	 Catch:{ IOException -> 0x05c9 }
    L_0x03a8:
        throw r0;	 Catch:{ Exception -> 0x03a9 }
    L_0x03a9:
        r0 = move-exception;
        r1 = r3;
    L_0x03ab:
        r2 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ all -> 0x04fd }
        r3 = 215; // 0xd7 float:3.01E-43 double:1.06E-321;
        r0 = r0.toString();	 Catch:{ all -> 0x04fd }
        r2.a(r3, r0);	 Catch:{ all -> 0x04fd }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ all -> 0x04fd }
        r2 = -537; // 0xfffffffffffffde7 float:NaN double:NaN;
        r0.setInstallInterruptCode(r2);	 Catch:{ all -> 0x04fd }
        r0 = 0;
        com.tencent.smtt.utils.j.a(r1, r0);	 Catch:{ Exception -> 0x058c }
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x058c }
        r1 = 0;
        r2 = -1;
        r0.a(r1, r2);	 Catch:{ Exception -> 0x058c }
    L_0x03ce:
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x03da:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r2 = "md5_check_failure for (";
        r1.<init>(r2);	 Catch:{ Exception -> 0x03a9 }
        r2 = r7.getName();	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03a9 }
        r2 = ") targetMd5:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.append(r9);	 Catch:{ Exception -> 0x03a9 }
        r2 = ", realMd5:";
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.append(r8);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r5 = r6;
    L_0x040b:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r2 = "copyTbsCoreInThread - md5_check_success:";
        r1.<init>(r2);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.append(r5);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        if (r4 == 0) goto L_0x0453;
    L_0x0423:
        if (r5 != 0) goto L_0x0453;
    L_0x0425:
        r0 = "TbsInstaller";
        r1 = "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = 1;
        com.tencent.smtt.utils.j.a(r3, r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "TbsCopy-Verify md5 fail after copying tbs core!";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -532; // 0xfffffffffffffdec float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x0453:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread success!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = 1;
        r12.f(r14, r0);	 Catch:{ Exception -> 0x03a9 }
        r1 = com.tencent.smtt.sdk.ag.b(r13);	 Catch:{ Exception -> 0x03a9 }
        if (r1 == 0) goto L_0x047d;
    L_0x0466:
        r0 = r1.exists();	 Catch:{ Exception -> 0x03a9 }
        if (r0 == 0) goto L_0x047d;
    L_0x046c:
        r2 = new java.io.File;	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloader.getOverSea(r14);	 Catch:{ Exception -> 0x03a9 }
        if (r0 == 0) goto L_0x04ec;
    L_0x0474:
        r0 = "x5.oversea.tbs.org";
    L_0x0477:
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.sdk.ag.a(r2, r14);	 Catch:{ Exception -> 0x03a9 }
    L_0x047d:
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 1;
        r0.a(r15, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = r12.k;	 Catch:{ Exception -> 0x03a9 }
        if (r0 == 0) goto L_0x04f0;
    L_0x0489:
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "continueInstallWithout core success";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
    L_0x0495:
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -533; // 0xfffffffffffffdeb float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r2 = "TbsInstaller-copyTbsCoreInThread success -- version:";
        r1.<init>(r2);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.append(r15);	 Catch:{ Exception -> 0x03a9 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x03a9 }
        r1 = 11;
        if (r0 < r1) goto L_0x050c;
    L_0x04ba:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 4;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x03a9 }
    L_0x04c2:
        r0 = r0.edit();	 Catch:{ Throwable -> 0x0515 }
        r1 = "tbs_preload_x5_counter";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0515 }
        r1 = "tbs_preload_x5_recorder";
        r2 = 0;
        r0.putInt(r1, r2);	 Catch:{ Throwable -> 0x0515 }
        r1 = "tbs_preload_x5_version";
        r0.putInt(r1, r15);	 Catch:{ Throwable -> 0x0515 }
        r0.commit();	 Catch:{ Throwable -> 0x0515 }
    L_0x04dd:
        com.tencent.smtt.utils.v.a(r14);	 Catch:{ Exception -> 0x03a9 }
    L_0x04e0:
        r0 = i;
        r0.unlock();
        r0 = j;
        r0.unlock();
        goto L_0x00d5;
    L_0x04ec:
        r0 = "x5.tbs.org";
        goto L_0x0477;
    L_0x04f0:
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 220; // 0xdc float:3.08E-43 double:1.087E-321;
        r2 = "success";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        goto L_0x0495;
    L_0x04fd:
        r0 = move-exception;
        r1 = i;
        r1.unlock();
        r1 = j;
        r1.unlock();
        r12.b();
        throw r0;
    L_0x050c:
        r0 = "tbs_preloadx5_check_cfg_file";
        r1 = 0;
        r0 = r14.getSharedPreferences(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        goto L_0x04c2;
    L_0x0515:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x03a9 }
        r4 = "Init tbs_preload_x5_counter#2 exception:";
        r2.<init>(r4);	 Catch:{ Exception -> 0x03a9 }
        r0 = android.util.Log.getStackTraceString(r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x03a9 }
        com.tencent.smtt.utils.TbsLog.e(r1, r0);	 Catch:{ Exception -> 0x03a9 }
        goto L_0x04dd;
    L_0x0531:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-copyTbsCoreInThread fail!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.ai.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 2;
        r0.a(r15, r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = 0;
        com.tencent.smtt.utils.j.a(r3, r0);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -534; // 0xfffffffffffffdea float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 212; // 0xd4 float:2.97E-43 double:1.047E-321;
        r2 = "copy fail!";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        goto L_0x04e0;
    L_0x055c:
        if (r0 != 0) goto L_0x0573;
    L_0x055e:
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 213; // 0xd5 float:2.98E-43 double:1.05E-321;
        r2 = "src-dir is null when copying tbs core!";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -535; // 0xfffffffffffffde9 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
    L_0x0573:
        if (r3 != 0) goto L_0x04e0;
    L_0x0575:
        r0 = com.tencent.smtt.sdk.TbsLogReport.a(r14);	 Catch:{ Exception -> 0x03a9 }
        r1 = 214; // 0xd6 float:3.0E-43 double:1.057E-321;
        r2 = "dst-dir is null when copying tbs core!";
        r0.a(r1, r2);	 Catch:{ Exception -> 0x03a9 }
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);	 Catch:{ Exception -> 0x03a9 }
        r1 = -536; // 0xfffffffffffffde8 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);	 Catch:{ Exception -> 0x03a9 }
        goto L_0x04e0;
    L_0x058c:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x04fd }
        r3 = "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:";
        r2.<init>(r3);	 Catch:{ all -> 0x04fd }
        r3 = r0.getMessage();	 Catch:{ all -> 0x04fd }
        r2 = r2.append(r3);	 Catch:{ all -> 0x04fd }
        r3 = ",";
        r2 = r2.append(r3);	 Catch:{ all -> 0x04fd }
        r0 = r0.getCause();	 Catch:{ all -> 0x04fd }
        r0 = r2.append(r0);	 Catch:{ all -> 0x04fd }
        r0 = r0.toString();	 Catch:{ all -> 0x04fd }
        com.tencent.smtt.utils.TbsLog.e(r1, r0);	 Catch:{ all -> 0x04fd }
        goto L_0x03ce;
    L_0x05b8:
        r12.b();
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r13);
        r1 = -538; // 0xfffffffffffffde6 float:NaN double:NaN;
        r0.setInstallInterruptCode(r1);
        goto L_0x0012;
    L_0x05c6:
        r1 = move-exception;
        goto L_0x039e;
    L_0x05c9:
        r1 = move-exception;
        goto L_0x03a8;
    L_0x05cc:
        r1 = move-exception;
        goto L_0x0301;
    L_0x05cf:
        r0 = move-exception;
        goto L_0x03ab;
    L_0x05d2:
        r0 = move-exception;
        r2 = r1;
        goto L_0x03a3;
    L_0x05d6:
        r1 = move-exception;
        goto L_0x0399;
    L_0x05d9:
        r2 = move-exception;
        r2 = r1;
        goto L_0x0399;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.an.a(android.content.Context, android.content.Context, int):void");
    }

    private boolean a(Context context, File file) {
        return a(context, file, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r10, java.io.File r11, boolean r12) {
        /*
        r9 = this;
        r2 = 1;
        r0 = 0;
        r1 = "TbsInstaller";
        r3 = "TbsInstaller-unzipTbs start";
        com.tencent.smtt.utils.TbsLog.i(r1, r3);
        r1 = com.tencent.smtt.utils.j.c(r11);
        if (r1 != 0) goto L_0x0027;
    L_0x0011:
        r1 = com.tencent.smtt.sdk.TbsLogReport.a(r10);
        r2 = 204; // 0xcc float:2.86E-43 double:1.01E-321;
        r3 = "apk is invalid!";
        r1.a(r2, r3);
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);
        r2 = -520; // 0xfffffffffffffdf8 float:NaN double:NaN;
        r1.setInstallInterruptCode(r2);
    L_0x0026:
        return r0;
    L_0x0027:
        r1 = "tbs";
        r3 = 0;
        r3 = r10.getDir(r1, r3);	 Catch:{ Throwable -> 0x007a }
        if (r12 == 0) goto L_0x0071;
    L_0x0031:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_share_decouple";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
    L_0x0039:
        r3 = r1.exists();	 Catch:{ Throwable -> 0x007a }
        if (r3 == 0) goto L_0x0052;
    L_0x003f:
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ Throwable -> 0x007a }
        r3 = r3.mPreferences;	 Catch:{ Throwable -> 0x007a }
        r4 = "tbs_downloaddecouplecore";
        r5 = 0;
        r3 = r3.getInt(r4, r5);	 Catch:{ Throwable -> 0x007a }
        if (r3 == r2) goto L_0x0052;
    L_0x004f:
        com.tencent.smtt.utils.j.b(r1);	 Catch:{ Throwable -> 0x007a }
    L_0x0052:
        if (r12 == 0) goto L_0x0096;
    L_0x0054:
        r1 = r9.u(r10);
        r4 = r1;
    L_0x0059:
        if (r4 != 0) goto L_0x009c;
    L_0x005b:
        r1 = com.tencent.smtt.sdk.TbsLogReport.a(r10);
        r2 = 205; // 0xcd float:2.87E-43 double:1.013E-321;
        r3 = "tmp unzip dir is null!";
        r1.a(r2, r3);
        r1 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);
        r2 = -521; // 0xfffffffffffffdf7 float:NaN double:NaN;
        r1.setInstallInterruptCode(r2);
        goto L_0x0026;
    L_0x0071:
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x007a }
        r4 = "core_unzip_tmp";
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x007a }
        goto L_0x0039;
    L_0x007a:
        r1 = move-exception;
        r3 = "TbsInstaller";
        r4 = new java.lang.StringBuilder;
        r5 = "TbsInstaller-unzipTbs -- delete unzip folder if exists exception";
        r4.<init>(r5);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r1);
        goto L_0x0052;
    L_0x0096:
        r1 = r9.t(r10);
        r4 = r1;
        goto L_0x0059;
    L_0x009c:
        com.tencent.smtt.utils.j.a(r4);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        if (r12 == 0) goto L_0x00a5;
    L_0x00a1:
        r1 = 1;
        com.tencent.smtt.utils.j.a(r4, r1);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
    L_0x00a5:
        r1 = com.tencent.smtt.utils.j.a(r11, r4);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        if (r1 == 0) goto L_0x00af;
    L_0x00ab:
        r1 = r9.a(r4, r10);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
    L_0x00af:
        if (r12 == 0) goto L_0x00e2;
    L_0x00b1:
        r5 = r4.list();	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r3 = r0;
    L_0x00b6:
        r6 = r5.length;	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        if (r3 >= r6) goto L_0x00d3;
    L_0x00b9:
        r6 = new java.io.File;	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r7 = r5[r3];	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r6.<init>(r4, r7);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r7 = r6.getName();	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r8 = ".dex";
        r7 = r7.endsWith(r8);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        if (r7 == 0) goto L_0x00d0;
    L_0x00cd:
        r6.delete();	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
    L_0x00d0:
        r3 = r3 + 1;
        goto L_0x00b6;
    L_0x00d3:
        r3 = s(r10);	 Catch:{ Exception -> 0x01f9, IOException -> 0x012b }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x01f9, IOException -> 0x012b }
        r6 = "x5.tbs";
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x01f9, IOException -> 0x012b }
        r5.delete();	 Catch:{ Exception -> 0x01f9, IOException -> 0x012b }
    L_0x00e2:
        if (r1 != 0) goto L_0x0116;
    L_0x00e4:
        com.tencent.smtt.utils.j.b(r4);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r5 = -522; // 0xfffffffffffffdf6 float:NaN double:NaN;
        r3.setInstallInterruptCode(r5);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r3 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r6 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:";
        r5.<init>(r6);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r6 = r4.exists();	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r5 = r5.append(r6);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        com.tencent.smtt.utils.TbsLog.e(r3, r5);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
    L_0x010a:
        r0 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r0, r2);
        r0 = r1;
        goto L_0x0026;
    L_0x0116:
        r3 = 1;
        r9.f(r10, r3);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        if (r12 == 0) goto L_0x010a;
    L_0x011c:
        r3 = r9.p(r10);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r5 = 1;
        com.tencent.smtt.utils.j.a(r3, r5);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        r4.renameTo(r3);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        com.tencent.smtt.sdk.TbsShareManager.b(r10);	 Catch:{ IOException -> 0x012b, Exception -> 0x0173 }
        goto L_0x010a;
    L_0x012b:
        r1 = move-exception;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ all -> 0x01b6 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.setInstallInterruptCode(r5);	 Catch:{ all -> 0x01b6 }
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r10);	 Catch:{ all -> 0x01b6 }
        r5 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        r3.a(r5, r1);	 Catch:{ all -> 0x01b6 }
        if (r4 == 0) goto L_0x01fe;
    L_0x0140:
        r1 = r4.exists();	 Catch:{ all -> 0x01b6 }
        if (r1 == 0) goto L_0x01fe;
    L_0x0146:
        r1 = r2;
    L_0x0147:
        if (r1 == 0) goto L_0x0168;
    L_0x0149:
        if (r4 == 0) goto L_0x0168;
    L_0x014b:
        com.tencent.smtt.utils.j.b(r4);	 Catch:{ Throwable -> 0x01c1 }
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c1 }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01c1 }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01c1 }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01c1 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01c1 }
        com.tencent.smtt.utils.TbsLog.e(r1, r2);	 Catch:{ Throwable -> 0x01c1 }
    L_0x0168:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
    L_0x016e:
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        goto L_0x0026;
    L_0x0173:
        r1 = move-exception;
        r3 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r10);	 Catch:{ all -> 0x01b6 }
        r5 = -523; // 0xfffffffffffffdf5 float:NaN double:NaN;
        r3.setInstallInterruptCode(r5);	 Catch:{ all -> 0x01b6 }
        r3 = com.tencent.smtt.sdk.TbsLogReport.a(r10);	 Catch:{ all -> 0x01b6 }
        r5 = 207; // 0xcf float:2.9E-43 double:1.023E-321;
        r3.a(r5, r1);	 Catch:{ all -> 0x01b6 }
        if (r4 == 0) goto L_0x01fc;
    L_0x0188:
        r1 = r4.exists();	 Catch:{ all -> 0x01b6 }
        if (r1 == 0) goto L_0x01fc;
    L_0x018e:
        if (r2 == 0) goto L_0x01af;
    L_0x0190:
        if (r4 == 0) goto L_0x01af;
    L_0x0192:
        com.tencent.smtt.utils.j.b(r4);	 Catch:{ Throwable -> 0x01dd }
        r1 = "TbsInstaller";
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01dd }
        r3 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:";
        r2.<init>(r3);	 Catch:{ Throwable -> 0x01dd }
        r3 = r4.exists();	 Catch:{ Throwable -> 0x01dd }
        r2 = r2.append(r3);	 Catch:{ Throwable -> 0x01dd }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x01dd }
        com.tencent.smtt.utils.TbsLog.e(r1, r2);	 Catch:{ Throwable -> 0x01dd }
    L_0x01af:
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        goto L_0x016e;
    L_0x01b6:
        r0 = move-exception;
        r1 = "TbsInstaller";
        r2 = "TbsInstaller-unzipTbs done";
        com.tencent.smtt.utils.TbsLog.i(r1, r2);
        throw r0;
    L_0x01c1:
        r1 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r1);
        goto L_0x0168;
    L_0x01dd:
        r1 = move-exception;
        r2 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r4 = "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:";
        r3.<init>(r4);
        r1 = android.util.Log.getStackTraceString(r1);
        r1 = r3.append(r1);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.e(r2, r1);
        goto L_0x01af;
    L_0x01f9:
        r3 = move-exception;
        goto L_0x00e2;
    L_0x01fc:
        r2 = r0;
        goto L_0x018e;
    L_0x01fe:
        r1 = r0;
        goto L_0x0147;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.an.a(android.content.Context, java.io.File, boolean):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.io.File r11, android.content.Context r12) {
        /*
        r10 = this;
        r3 = 0;
        r2 = 1;
        r4 = 0;
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r5 = "finalCheckForTbsCoreValidity - ";
        r1.<init>(r5);
        r1 = r1.append(r11);
        r5 = ", ";
        r1 = r1.append(r5);
        r1 = r1.append(r12);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r1 = new java.io.File;	 Catch:{ Exception -> 0x00ec, all -> 0x00f7 }
        r0 = "1";
        r1.<init>(r11, r0);	 Catch:{ Exception -> 0x00ec, all -> 0x00f7 }
        r0 = new java.util.Properties;	 Catch:{ Exception -> 0x00ec, all -> 0x00f7 }
        r0.<init>();	 Catch:{ Exception -> 0x00ec, all -> 0x00f7 }
        r5 = r1.exists();	 Catch:{ Exception -> 0x0168, all -> 0x00f7 }
        if (r5 == 0) goto L_0x00e8;
    L_0x0037:
        r6 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0168, all -> 0x00f7 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0168, all -> 0x00f7 }
        r5 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x0168, all -> 0x00f7 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0168, all -> 0x00f7 }
        r0.load(r5);	 Catch:{ Exception -> 0x016b, all -> 0x0165 }
        r1 = r2;
    L_0x0045:
        if (r5 == 0) goto L_0x004a;
    L_0x0047:
        r5.close();	 Catch:{ IOException -> 0x0162 }
    L_0x004a:
        r3 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;
        r6 = "finalCheckForTbsCoreValidity - need_check:";
        r5.<init>(r6);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r5);
        if (r1 == 0) goto L_0x016e;
    L_0x0062:
        r5 = r11.listFiles();
        r3 = r4;
    L_0x0067:
        r6 = r5.length;
        if (r3 >= r6) goto L_0x016e;
    L_0x006a:
        r6 = r5[r3];
        r7 = "1";
        r8 = r6.getName();
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x00e5;
    L_0x0079:
        r7 = r6.getName();
        r8 = ".dex";
        r7 = r7.endsWith(r8);
        if (r7 != 0) goto L_0x00e5;
    L_0x0086:
        r7 = "tbs.conf";
        r8 = r6.getName();
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x00e5;
    L_0x0093:
        r7 = r6.isDirectory();
        if (r7 != 0) goto L_0x00e5;
    L_0x0099:
        r7 = r6.getName();
        r8 = ".prof";
        r7 = r7.endsWith(r8);
        if (r7 != 0) goto L_0x00e5;
    L_0x00a6:
        r7 = com.tencent.smtt.utils.a.a(r6);
        r8 = r6.getName();
        r9 = "";
        r8 = r0.getProperty(r8, r9);
        r9 = "";
        r9 = r8.equals(r9);
        if (r9 != 0) goto L_0x00fe;
    L_0x00be:
        r9 = r8.equals(r7);
        if (r9 == 0) goto L_0x00fe;
    L_0x00c4:
        r7 = "TbsInstaller";
        r8 = new java.lang.StringBuilder;
        r9 = "md5_check_success for (";
        r8.<init>(r9);
        r6 = r6.getName();
        r6 = r8.append(r6);
        r8 = ")";
        r6 = r6.append(r8);
        r6 = r6.toString();
        com.tencent.smtt.utils.TbsLog.i(r7, r6);
    L_0x00e5:
        r3 = r3 + 1;
        goto L_0x0067;
    L_0x00e8:
        r5 = r3;
        r1 = r4;
        goto L_0x0045;
    L_0x00ec:
        r0 = move-exception;
        r0 = r3;
        r1 = r3;
    L_0x00ef:
        if (r1 == 0) goto L_0x00f4;
    L_0x00f1:
        r1.close();	 Catch:{ IOException -> 0x015e }
    L_0x00f4:
        r1 = r2;
        goto L_0x004a;
    L_0x00f7:
        r0 = move-exception;
    L_0x00f8:
        if (r3 == 0) goto L_0x00fd;
    L_0x00fa:
        r3.close();	 Catch:{ IOException -> 0x0160 }
    L_0x00fd:
        throw r0;
    L_0x00fe:
        r0 = "TbsInstaller";
        r3 = new java.lang.StringBuilder;
        r5 = "md5_check_failure for (";
        r3.<init>(r5);
        r5 = r6.getName();
        r3 = r3.append(r5);
        r5 = ") targetMd5:";
        r3 = r3.append(r5);
        r3 = r3.append(r8);
        r5 = ", realMd5:";
        r3 = r3.append(r5);
        r3 = r3.append(r7);
        r3 = r3.toString();
        com.tencent.smtt.utils.TbsLog.e(r0, r3);
        r0 = r4;
    L_0x012f:
        r3 = "TbsInstaller";
        r5 = new java.lang.StringBuilder;
        r6 = "finalCheckForTbsCoreValidity - md5_check_success:";
        r5.<init>(r6);
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.tencent.smtt.utils.TbsLog.i(r3, r5);
        if (r1 == 0) goto L_0x0153;
    L_0x0147:
        if (r0 != 0) goto L_0x0153;
    L_0x0149:
        r0 = "TbsInstaller";
        r1 = "finalCheckForTbsCoreValidity - Verify failed after unzipping!";
        com.tencent.smtt.utils.TbsLog.e(r0, r1);
    L_0x0152:
        return r4;
    L_0x0153:
        r0 = "TbsInstaller";
        r1 = "finalCheckForTbsCoreValidity success!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r4 = r2;
        goto L_0x0152;
    L_0x015e:
        r1 = move-exception;
        goto L_0x00f4;
    L_0x0160:
        r1 = move-exception;
        goto L_0x00fd;
    L_0x0162:
        r3 = move-exception;
        goto L_0x004a;
    L_0x0165:
        r0 = move-exception;
        r3 = r5;
        goto L_0x00f8;
    L_0x0168:
        r1 = move-exception;
        r1 = r3;
        goto L_0x00ef;
    L_0x016b:
        r1 = move-exception;
        r1 = r5;
        goto L_0x00ef;
    L_0x016e:
        r0 = r2;
        goto L_0x012f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.an.a(java.io.File, android.content.Context):boolean");
    }

    @TargetApi(11)
    private void b(Context context, String str, int i) {
        int i2 = 200;
        int i3 = 0;
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (c(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
        } else if (!j.b(context)) {
            long a = v.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport.a(context).a(210, "rom is not enough when installing tbs core! curAvailROM=" + a + ",minReqRom=" + downloadMinFreeSpace);
        } else if (w(context)) {
            boolean tryLock = j.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + tryLock);
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                i.lock();
                try {
                    boolean z;
                    int i4;
                    int c = ai.a(context).c("copy_core_ver");
                    int b = ai.a(context).b();
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + c);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + b);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + i);
                    if ((b > 0 && i > b) || (c > 0 && i > c)) {
                        o(context);
                    }
                    c = ai.a(context).c();
                    b = i(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + c);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + b);
                    if (c < 0 || c >= 2) {
                        if (c == 3 && b > 0 && (i > b || i == 88888888)) {
                            c = -1;
                            o(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        z = false;
                        i4 = c;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z = true;
                        i4 = c;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + i4);
                    String d;
                    if (i4 <= 0) {
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z) {
                            c = ai.a(context).c("unzip_retry_num");
                            if (c > 10) {
                                TbsLogReport.a(context).a(av.CTRL_INDEX, "exceed unzip retry num!");
                                F(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                            ai.a(context).b(c + 1);
                        }
                        if (str == null) {
                            d = ai.a(context).d("install_apk_path");
                            if (d == null) {
                                TbsLogReport.a(context).a(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                        }
                        d = str;
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + d);
                        int b2 = b(context, d);
                        if (b2 == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.a(context).a(203, "apk version is 0!");
                            i.unlock();
                            j.unlock();
                            b();
                            return;
                        }
                        ai.a(context).a("install_apk_path", d);
                        ai.a(context).b(b2, 0);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (!a(context, new File(d), true)) {
                                TbsLogReport.a(context).a(207, "unzipTbsApk failed", EventType.TYPE_INSTALL_DECOUPLE);
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                        } else if (!a(context, new File(d))) {
                            TbsLogReport.a(context).a(207, "unzipTbsApk failed");
                            i.unlock();
                            j.unlock();
                            b();
                            return;
                        }
                        if (z) {
                            c = ai.a(context).b("unlzma_status");
                            if (c > 5) {
                                TbsLogReport.a(context).a(223, "exceed unlzma retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                F(context);
                                ag.c(context);
                                TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_FULL_PACKAGE, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).commit();
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                            ai.a(context).d(c + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        b = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_RESPONSECODE, 0);
                        if (i(context) != 0) {
                            Object a2 = QbSdk.a(context, "can_unlzma", null);
                            tryLock = (a2 == null || !(a2 instanceof Boolean)) ? false : ((Boolean) a2).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", b);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    bundle.putString("unzip_temp_path", p(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", t(context).getAbsolutePath());
                                }
                                a2 = QbSdk.a(context, "unlzma", bundle);
                                if (a2 == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    TbsLogReport.a(context).a(222, "unlzma is null");
                                } else if (a2 instanceof Boolean) {
                                    if (((Boolean) a2).booleanValue()) {
                                        TbsLog.i("TbsInstaller", "unlzma success");
                                        i3 = 1;
                                    } else {
                                        TbsLog.i("TbsInstaller", "unlzma return false");
                                        TbsLogReport.a(context).a(222, "unlzma return false");
                                    }
                                } else if (a2 instanceof Bundle) {
                                    i3 = 1;
                                } else if (a2 instanceof Throwable) {
                                    TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) a2));
                                    TbsLogReport.a(context).a(222, (Throwable) a2);
                                }
                                if (i3 == 0) {
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        ai.a(context).b(b2, 1);
                        c = b2;
                    } else {
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (str == null) {
                                d = ai.a(context).d("install_apk_path");
                                if (d == null) {
                                    TbsLogReport.a(context).a(202, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    return;
                                }
                            }
                            d = str;
                            a(context, new File(d), true);
                        }
                        c = 0;
                    }
                    if (i4 < 2) {
                        if (z) {
                            b = ai.a(context).c("dexopt_retry_num");
                            if (b > 10) {
                                TbsLogReport.a(context).a(208, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                F(context);
                                i.unlock();
                                j.unlock();
                                b();
                                return;
                            }
                            ai.a(context).a(b + 1);
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (d(context, 0)) {
                            ai.a(context).b(c, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + i);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            if (i == 88888888) {
                                a(i, str, context);
                            }
                            if (this.k) {
                                TbsLogReport a3 = TbsLogReport.a(context);
                                if (ai.a(context).d() == 1) {
                                    i2 = 221;
                                }
                                a3.a(i2, "continueInstallWithout core success");
                            } else {
                                TbsLogReport.a(context).a(ai.a(context).d() == 1 ? 221 : 200, "success");
                            }
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            i.unlock();
                            j.unlock();
                            b();
                            return;
                        }
                    } else if (i4 == 2) {
                        QbSdk.m.onInstallFinish(200);
                    }
                } catch (Throwable th) {
                    i.unlock();
                    j.unlock();
                    b();
                }
                i.unlock();
                j.unlock();
                b();
                return;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            b();
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
        }
    }

    private boolean b(Context context, File file) {
        try {
            File[] listFiles = file.listFiles(new av(this));
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase("com.tencent.tbs")) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            return true;
        } catch (Exception e2) {
            TbsLogReport.a(context).a(209, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            return false;
        }
    }

    private boolean c(Context context, File file) {
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            Object a = g.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a)) {
                TbsLogReport.a(context).a(226, "can not find oat command");
                return false;
            }
            for (File file4 : file.listFiles(new aw(this))) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + a.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + a().q(context) + File.separator + substring + ".jar").waitFor();
            }
            return true;
        } catch (Throwable e) {
            TbsLogReport.a(context).a(226, e);
            return false;
        }
    }

    private synchronized boolean c(Context context, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (w(context)) {
                    boolean tryLock = i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =" + tryLock);
                    if (tryLock) {
                        int b = ai.a(context).b("copy_status");
                        int a = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =" + b);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =" + a);
                        if (b == 1) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                B(context);
                                z2 = true;
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                B(context);
                                z2 = true;
                            }
                        }
                        i.unlock();
                    }
                    b();
                }
            } catch (Throwable th) {
                TbsLogReport.a(context).a(215, th.toString());
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
            }
        }
        return z2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(android.content.Context r9, int r10) {
        /*
        r8 = this;
        r2 = 1;
        r3 = 0;
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;
        r4 = "TbsInstaller-doTbsDexOpt start - dirMode: ";
        r1.<init>(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        switch(r10) {
            case 0: goto L_0x0033;
            case 1: goto L_0x00a1;
            case 2: goto L_0x00a6;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = "TbsInstaller";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0089 }
        r4 = "doDexoptOrDexoat mode error: ";
        r1.<init>(r4);	 Catch:{ Exception -> 0x0089 }
        r1 = r1.append(r10);	 Catch:{ Exception -> 0x0089 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0089 }
        com.tencent.smtt.utils.TbsLog.e(r0, r1);	 Catch:{ Exception -> 0x0089 }
        r2 = r3;
    L_0x0032:
        return r2;
    L_0x0033:
        r0 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ Exception -> 0x0089 }
        r0 = r0.mPreferences;	 Catch:{ Exception -> 0x0089 }
        r1 = "tbs_downloaddecouplecore";
        r4 = 0;
        r0 = r0.getInt(r1, r4);	 Catch:{ Exception -> 0x0089 }
        if (r0 == r2) goto L_0x0032;
    L_0x0043:
        r0 = r8.t(r9);	 Catch:{ Exception -> 0x0089 }
    L_0x0047:
        r1 = "java.vm.version";
        r1 = java.lang.System.getProperty(r1);	 Catch:{ Throwable -> 0x00ad }
        if (r1 == 0) goto L_0x00ab;
    L_0x0050:
        r4 = "2";
        r1 = r1.startsWith(r4);	 Catch:{ Throwable -> 0x00ad }
        if (r1 == 0) goto L_0x00ab;
    L_0x0059:
        r1 = r2;
    L_0x005a:
        r4 = r1;
    L_0x005b:
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0089 }
        r5 = 23;
        if (r1 != r5) goto L_0x00b9;
    L_0x0061:
        r1 = r2;
    L_0x0062:
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ Exception -> 0x0089 }
        r5 = r5.mPreferences;	 Catch:{ Exception -> 0x0089 }
        r6 = "tbs_stop_preoat";
        r7 = 0;
        r5 = r5.getBoolean(r6, r7);	 Catch:{ Exception -> 0x0089 }
        if (r4 == 0) goto L_0x0077;
    L_0x0072:
        if (r1 == 0) goto L_0x0077;
    L_0x0074:
        if (r5 != 0) goto L_0x0077;
    L_0x0076:
        r3 = r2;
    L_0x0077:
        if (r3 == 0) goto L_0x00bb;
    L_0x0079:
        r1 = r8.c(r9, r0);	 Catch:{ Exception -> 0x0089 }
        if (r1 == 0) goto L_0x00bb;
    L_0x007f:
        r0 = "TbsInstaller";
        r1 = "doTbsDexOpt -- doDexoatForArtVm";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0032;
    L_0x0089:
        r0 = move-exception;
        r1 = com.tencent.smtt.sdk.TbsLogReport.a(r9);
        r3 = 209; // 0xd1 float:2.93E-43 double:1.033E-321;
        r0 = r0.toString();
        r1.a(r3, r0);
    L_0x0097:
        r0 = "TbsInstaller";
        r1 = "TbsInstaller-doTbsDexOpt done";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        goto L_0x0032;
    L_0x00a1:
        r0 = r8.v(r9);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0047;
    L_0x00a6:
        r0 = r8.q(r9);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0047;
    L_0x00ab:
        r1 = r3;
        goto L_0x005a;
    L_0x00ad:
        r1 = move-exception;
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r9);	 Catch:{ Exception -> 0x0089 }
        r5 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;
        r4.a(r5, r1);	 Catch:{ Exception -> 0x0089 }
        r4 = r3;
        goto L_0x005b;
    L_0x00b9:
        r1 = r3;
        goto L_0x0062;
    L_0x00bb:
        if (r4 == 0) goto L_0x00c7;
    L_0x00bd:
        r0 = "TbsInstaller";
        r1 = "doTbsDexOpt -- is ART mode, skip!";
        com.tencent.smtt.utils.TbsLog.i(r0, r1);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0097;
    L_0x00c7:
        r1 = "TbsInstaller";
        r3 = "doTbsDexOpt -- doDexoptForDavlikVM";
        com.tencent.smtt.utils.TbsLog.i(r1, r3);	 Catch:{ Exception -> 0x0089 }
        r2 = r8.b(r9, r0);	 Catch:{ Exception -> 0x0089 }
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.an.d(android.content.Context, int):boolean");
    }

    private static boolean d(Context context, String str) {
        File file = new File(context.getDir("tbs", 0), str);
        if (!file.exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
            return false;
        } else if (new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            return true;
        } else {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
            return false;
        }
    }

    private synchronized boolean d(Context context, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + z);
            try {
                if (w(context)) {
                    boolean tryLock = i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + tryLock);
                    if (tryLock) {
                        int c = ai.a(context).c();
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + c);
                        int a = a(false, context);
                        if (c == 2) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                A(context);
                                z2 = true;
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                A(context);
                                z2 = true;
                            }
                        }
                        i.unlock();
                    }
                    b();
                }
            } catch (Exception e) {
                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + e);
            } catch (Throwable th) {
                i.unlock();
            }
        }
        return z2;
    }

    private Context e(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + i);
        if (i <= 0) {
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i2 = 0;
        while (i2 < coreProviderAppList.length) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && e(context, coreProviderAppList[i2])) {
                Context a = a(context, coreProviderAppList[i2]);
                if (a == null) {
                    continue;
                } else if (f(a)) {
                    int i3 = i(a);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i3);
                    if (i3 != 0 && i3 == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i2]);
                        return a;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        return null;
    }

    private boolean e(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private synchronized boolean e(Context context, boolean z) {
        return false;
    }

    private void f(Context context, boolean z) {
        if (context == null) {
            TbsLogReport.a(context).a(225, "setTmpFolderCoreToRead context is null");
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                j.b(file);
            } else if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            TbsLogReport.a(context).a(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
        }
    }

    static File s(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_private");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    private static boolean x(Context context) {
        if (context == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
            return true;
        }
        try {
            if (new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                return true;
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
            return false;
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
            return true;
        }
    }

    private void y(Context context) {
        boolean z = true;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
        }
        if (z && l != null) {
            j.a(context, l);
        }
    }

    private boolean z(Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        try {
            tbsCoreLoadRenameFileLockEnable = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        if (tbsCoreLoadRenameFileLockEnable) {
            l = j.f(context);
        } else {
            l = bv.a().a(context);
        }
        return l != null;
    }

    int a(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        if (str != null) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(new File(str), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property != null) {
                            i = Integer.parseInt(property);
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        } else if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                    }
                }
                throw th;
            }
        }
        return i;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    public int a(boolean z, Context context) {
        if (z || ((Integer) a.get()).intValue() <= 0) {
            a.set(Integer.valueOf(i(context)));
        }
        return ((Integer) a.get()).intValue();
    }

    Context a(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (Exception e) {
            return null;
        }
    }

    void a(Context context, Bundle bundle) {
        if (bundle != null && context != null) {
            Object obj = new Object[]{context, bundle};
            Message message = new Message();
            message.what = 3;
            message.obj = obj;
            m.sendMessage(message);
        }
    }

    void a(Context context, String str, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object obj = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        m.sendMessage(message);
    }

    void a(Context context, boolean z) {
        String str = -1;
        boolean z2 = false;
        if (z) {
            this.k = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        int i = "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName();
        TbsLog.i("TbsInstaller", i);
        if (w(context)) {
            int c;
            int b;
            int c2;
            String str2 = null;
            if (i.tryLock()) {
                try {
                    c = ai.a(context).c();
                    b = ai.a(context).b();
                    str = ai.a(context).d("install_apk_path");
                    c2 = ai.a(context).c("copy_core_ver");
                    i = ai.a(context).b("copy_status");
                    str2 = str;
                } finally {
                    z2 = i;
                    z2.unlock();
                }
            } else {
                c2 = 0;
                i = -1;
                b = 0;
                c = -1;
            }
            b();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + c);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + b);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + c2);
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i);
            if (TbsShareManager.isThirdPartyApp(context)) {
                b(context, TbsShareManager.a(context, z2));
                return;
            }
            int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_RESPONSECODE, z2);
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                z2 = true;
            }
            if (!(z2 || i2 == 0)) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (c >= 0 && c < 2) {
                a(context, str2, b);
            }
            if (i == 0) {
                a(context, c2);
            }
        }
    }

    boolean a(Context context, int i) {
        if (TbsDownloader.getOverSea(context)) {
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (e(context, i) != null) {
            Object obj = new Object[]{e(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = obj;
            m.sendMessage(message);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        return false;
    }

    public synchronized boolean a(Context context, Context context2) {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (!p) {
            p = true;
            new ar(this, context2, context).start();
        }
        return true;
    }

    int b(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        return packageArchiveInfo != null ? packageArchiveInfo.versionCode : 0;
    }

    File b(Context context, Context context2) {
        File file = new File(context2.getDir("tbs", 0), "core_share");
        return !file.isDirectory() ? ((context == null || !TbsShareManager.isThirdPartyApp(context)) && !file.mkdir()) ? null : file : file;
    }

    synchronized void b() {
        int i = this.e;
        this.e = i - 1;
        if (i > 1 || !this.h) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            j.a(this.f, this.g);
            this.h = false;
        }
    }

    public void b(Context context) {
        f(context, true);
        ai.a(context).b(h(context), 2);
    }

    void b(Context context, int i) {
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i > 0) {
            int i2 = i(context);
            if (i2 != i) {
                Context e = TbsShareManager.e(context);
                if (e != null || TbsShareManager.getHostCorePathAppDefined() != null) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
                    a(context, e);
                } else if (i2 <= 0) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                    QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
                }
            }
        }
    }

    void b(Context context, Bundle bundle) {
        Throwable e;
        if (c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle != null && context != null) {
            if (!j.b(context)) {
                TbsLogReport.a(context).a(210, "rom is not enough when patching tbs core! curAvailROM=" + v.a() + ",minReqRom=" + TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace());
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            } else if (w(context)) {
                boolean tryLock = j.tryLock();
                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=" + tryLock);
                if (tryLock) {
                    Bundle bundle2 = null;
                    int i;
                    try {
                        QbSdk.setTBSInstallingStatus(true);
                        if (i(context) <= 0 || ai.a(context).d() == 1) {
                            QbSdk.setTBSInstallingStatus(false);
                            j.unlock();
                            b();
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            QbSdk.setTBSInstallingStatus(false);
                            return;
                        }
                        i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_RESPONSECODE, 0);
                        tryLock = i == 1 || i == 2 || i == 4;
                        if (!(tryLock || i == 0)) {
                            int c = ai.a(context).c("incrupdate_retry_num");
                            if (c > 5) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                                Object string = bundle.getString("old_apk_location");
                                Object string2 = bundle.getString("new_apk_location");
                                Object string3 = bundle.getString("diff_file_location");
                                if (!TextUtils.isEmpty(string)) {
                                    j.b(new File(string));
                                }
                                if (!TextUtils.isEmpty(string2)) {
                                    j.b(new File(string2));
                                }
                                if (!TextUtils.isEmpty(string3)) {
                                    j.b(new File(string3));
                                }
                                TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                TbsDownloadConfig.getInstance(context).commit();
                                TbsLogReport.a(context).a(224, "incrUpdate exceed retry max num");
                                j.unlock();
                                b();
                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                            ai.a(context).a("incrupdate_retry_num", c + 1);
                            File s = s(context);
                            if (s != null && new File(s, "x5.tbs").exists()) {
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                                bundle2 = QbSdk.a(context, bundle);
                                if (bundle2 == null) {
                                    try {
                                        TbsLogReport.a(context).a(228, "result null : " + bundle.getInt("new_core_ver"));
                                        i = 1;
                                        j.unlock();
                                        b();
                                        if (i != 0) {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                            ai.a(context).a("incrupdate_retry_num", 0);
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                            ai.a(context).b(0, -1);
                                            ai.a(context).c(1);
                                            String string4 = bundle2.getString("apk_path");
                                            ag.a(new File(string4), context);
                                            b(context, string4, bundle2.getInt("tbs_core_ver"));
                                        } else if (i == 2) {
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                        } else {
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                            TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                            TbsDownloadConfig.getInstance(context).commit();
                                            TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        i = 1;
                                        try {
                                            TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                            try {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                                TbsLogReport.a(context).a(218, e.toString());
                                                j.unlock();
                                                b();
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                TbsDownloadConfig.getInstance(context).commit();
                                                TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + 1);
                                                QbSdk.setTBSInstallingStatus(false);
                                                return;
                                            } catch (Throwable th) {
                                                e = th;
                                                i = 1;
                                                j.unlock();
                                                b();
                                                if (i != 0) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                    ai.a(context).a("incrupdate_retry_num", 0);
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                    ai.a(context).b(0, -1);
                                                    ai.a(context).c(1);
                                                    String string5 = bundle2.getString("apk_path");
                                                    ag.a(new File(string5), context);
                                                    b(context, string5, bundle2.getInt("tbs_core_ver"));
                                                } else if (i == 2) {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                                } else {
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                    TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                    TbsDownloadConfig.getInstance(context).commit();
                                                    TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                                                }
                                                QbSdk.setTBSInstallingStatus(false);
                                                throw e;
                                            }
                                        } catch (Throwable th2) {
                                            e = th2;
                                            j.unlock();
                                            b();
                                            if (i != 0) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                ai.a(context).a("incrupdate_retry_num", 0);
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                ai.a(context).b(0, -1);
                                                ai.a(context).c(1);
                                                String string52 = bundle2.getString("apk_path");
                                                ag.a(new File(string52), context);
                                                b(context, string52, bundle2.getInt("tbs_core_ver"));
                                            } else if (i == 2) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                            } else {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                                TbsDownloadConfig.getInstance(context).commit();
                                                TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                                            }
                                            QbSdk.setTBSInstallingStatus(false);
                                            throw e;
                                        }
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                    return;
                                }
                                i = bundle2.getInt("patch_result");
                                try {
                                    TbsLogReport.a(context).a(228, "result " + i + " : " + bundle.getInt("new_core_ver"));
                                    j.unlock();
                                    b();
                                    if (i != 0) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                        ai.a(context).a("incrupdate_retry_num", 0);
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                        ai.a(context).b(0, -1);
                                        ai.a(context).c(1);
                                        String string42 = bundle2.getString("apk_path");
                                        ag.a(new File(string42), context);
                                        b(context, string42, bundle2.getInt("tbs_core_ver"));
                                    } else if (i == 2) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                    } else {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                        TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                                        TbsDownloadConfig.getInstance(context).commit();
                                        TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                return;
                            }
                        }
                        i = 2;
                        j.unlock();
                        b();
                        if (i != 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            ai.a(context).a("incrupdate_retry_num", 0);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                            ai.a(context).b(0, -1);
                            ai.a(context).c(1);
                            String string422 = bundle2.getString("apk_path");
                            ag.a(new File(string422), context);
                            b(context, string422, bundle2.getInt("tbs_core_ver"));
                        } else if (i == 2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                            TbsDownloadConfig.getInstance(context).commit();
                            TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        return;
                    } catch (Exception e4) {
                        e = e4;
                        i = 2;
                    } catch (Throwable th3) {
                        e = th3;
                        i = 2;
                        j.unlock();
                        b();
                        if (i != 0) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                            ai.a(context).a("incrupdate_retry_num", 0);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                            ai.a(context).b(0, -1);
                            ai.a(context).c(1);
                            String string522 = bundle2.getString("apk_path");
                            ag.a(new File(string522), context);
                            b(context, string522, bundle2.getInt("tbs_core_ver"));
                        } else if (i == 2) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                            TbsDownloadConfig.getInstance(context).a.put(TbsDownloadConfig$TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.valueOf(true));
                            TbsDownloadConfig.getInstance(context).commit();
                            TbsLogReport.a(context).a(217, "incrUpdate fail! patch ret=" + i);
                        }
                        QbSdk.setTBSInstallingStatus(false);
                        throw e;
                    }
                }
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
                b();
            } else {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            }
        }
    }

    void b(Context context, boolean z) {
        if (!QbSdk.b) {
            if (VERSION.SDK_INT < 8) {
                TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
                return;
            }
            try {
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    File u = u(context);
                    if (u != null && u.exists()) {
                        j.a(u, false);
                        new File(s(context), "x5.tbs").delete();
                    }
                }
            } catch (Throwable th) {
            }
            if (!x(context)) {
                return;
            }
            if (d(context, "core_unzip_tmp") && d(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
            } else if (d(context, "core_share_backup_tmp") && e(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
            } else if (d(context, "core_copy_tmp") && c(context, z)) {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
            } else {
                TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            }
        }
    }

    public String c(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            bufferedInputStream = null;
            try {
                File file = new File(q(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        str2 = properties.getProperty(str);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (Exception e) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e2) {
                            }
                        }
                        throw th;
                    }
                } else if (str2 != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                bufferedInputStream = str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = str2;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                    }
                }
                throw th;
            }
        }
        return str2;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean c(android.content.Context r11) {
        /*
        r10 = this;
        r1 = 1;
        r2 = 0;
        r0 = r10.q(r11);
        r5 = new java.io.File;
        r3 = "tbs.conf";
        r5.<init>(r0, r3);
        r0 = r5.exists();
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r2;
    L_0x0015:
        r0 = new java.util.Properties;
        r0.<init>();
        r4 = 0;
        r6 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r6.<init>(r5);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r3.<init>(r6);	 Catch:{ Throwable -> 0x007b, all -> 0x0086 }
        r0.load(r3);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4 = "tbs_local_installation";
        r6 = "false";
        r0 = r0.getProperty(r4, r6);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        r4 = r0.booleanValue();	 Catch:{ Throwable -> 0x0094, all -> 0x0092 }
        if (r4 == 0) goto L_0x009c;
    L_0x003c:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r8 = r5.lastModified();	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r6 = r6 - r8;
        r8 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0077;
    L_0x004c:
        r0 = r1;
    L_0x004d:
        r5 = "TbsInstaller";
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r7 = "TBS_LOCAL_INSTALLATION is:";
        r6.<init>(r7);	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r6 = r6.append(r4);	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r7 = " expired=";
        r6 = r6.append(r7);	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r6 = r6.append(r0);	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ Throwable -> 0x0098, all -> 0x0092 }
        if (r0 != 0) goto L_0x0079;
    L_0x0070:
        r0 = r4 & r1;
        r3.close();	 Catch:{ IOException -> 0x008e }
    L_0x0075:
        r2 = r0;
        goto L_0x0014;
    L_0x0077:
        r0 = r2;
        goto L_0x004d;
    L_0x0079:
        r1 = r2;
        goto L_0x0070;
    L_0x007b:
        r0 = move-exception;
        r1 = r4;
        r0 = r2;
    L_0x007e:
        if (r1 == 0) goto L_0x0075;
    L_0x0080:
        r1.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x0075;
    L_0x0084:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0086:
        r0 = move-exception;
        r3 = r4;
    L_0x0088:
        if (r3 == 0) goto L_0x008d;
    L_0x008a:
        r3.close();	 Catch:{ IOException -> 0x0090 }
    L_0x008d:
        throw r0;
    L_0x008e:
        r1 = move-exception;
        goto L_0x0075;
    L_0x0090:
        r1 = move-exception;
        goto L_0x008d;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0088;
    L_0x0094:
        r0 = move-exception;
        r1 = r3;
        r0 = r2;
        goto L_0x007e;
    L_0x0098:
        r0 = move-exception;
        r1 = r3;
        r0 = r4;
        goto L_0x007e;
    L_0x009c:
        r0 = r2;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.an.c(android.content.Context):boolean");
    }

    boolean c(Context context, int i) {
        try {
            File q;
            File file;
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                q = q(context);
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context));
                if (file.getAbsolutePath().contains("com.tencent.tbs")) {
                    return true;
                }
                q = file;
            } else {
                TbsLog.e("TbsInstaller", "321");
                return false;
            }
            if (q != null) {
                for (Long[] lArr : n) {
                    if (i == lArr[0].intValue()) {
                        file = new File(q, "libmttwebview.so");
                        if (file.exists() && file.length() == lArr[1].longValue()) {
                            TbsLog.d("TbsInstaller", "check so success: " + i + "; file: " + file);
                            return true;
                        }
                        if (!isThirdPartyApp) {
                            j.b(context.getDir("tbs", 0));
                        }
                        a.set(Integer.valueOf(0));
                        TbsLog.e("TbsInstaller", "322");
                        return false;
                    }
                }
                return true;
            }
            TbsLog.e("TbsInstaller", "323");
            return false;
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            return false;
        }
    }

    public void d(Context context) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        try {
            File file = new File(q(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = null;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
                try {
                    properties.setProperty("tbs_local_installation", "false");
                    properties.store(bufferedOutputStream, null);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e3) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e5) {
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e22) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                bufferedOutputStream2 = null;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e52) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e222) {
                    }
                }
                throw th;
            }
        } catch (Throwable th4) {
        }
    }

    public boolean e(Context context) {
        try {
            File file = new File(j.a(context, 4), "x5.tbs.decouple");
            File u = a().u(context);
            j.a(u);
            j.a(u, true);
            j.a(file, u);
            String[] list = u.list();
            for (String file2 : list) {
                File file3 = new File(u, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            a().f(context, true);
            file = p(context);
            j.a(file, true);
            u.renameTo(file);
            TbsShareManager.b(context);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean f(Context context) {
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            return context.getPackageName().equals("com.tencent.mtt") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.tencent.mm") ? signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499") : context.getPackageName().equals("com.tencent.mobileqq") ? signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049") : context.getPackageName().equals("com.tencent.tbs") ? signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a") : context.getPackageName().equals("com.qzone") ? signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677") : !context.getPackageName().equals("com.tencent.qqpimsecure") || signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            return false;
        }
    }

    int g(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File t = t(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is " + t);
            File file = new File(t, "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Exception e) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e22) {
                }
            }
            throw th;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    int h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(p(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return i;
                    }
                    i = Integer.parseInt(property);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    return i;
                } catch (Exception e) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e2) {
                        }
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e3) {
                }
            }
            return i;
        } catch (Exception e4) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e22) {
                }
            }
            throw th;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        return i;
    }

    int i(Context context) {
        BufferedInputStream bufferedInputStream;
        Exception e;
        Throwable th;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(q(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                            }
                        }
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (o == 0) {
                        o = parseInt;
                    }
                    if (bufferedInputStream == null) {
                        return parseInt;
                    }
                    try {
                        bufferedInputStream.close();
                        return parseInt;
                    } catch (IOException e3) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e3.toString());
                        return parseInt;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString());
                    }
                }
                return 0;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e32) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e32.toString());
                }
            }
            throw th;
        }
        return 0;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString());
                }
            }
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e322) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e322.toString());
                }
            }
            throw th;
        }
    }

    int j(Context context) {
        return o != 0 ? o : i(context);
    }

    void k(Context context) {
        if (o == 0) {
            o = i(context);
        }
    }

    boolean l(Context context) {
        return new File(q(context), "tbs.conf").exists();
    }

    int m(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        if (!w(context)) {
            return -1;
        }
        boolean tryLock = i.tryLock();
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=" + tryLock);
        if (tryLock) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(q(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                }
                            }
                            try {
                                if (i.isHeldByCurrentThread()) {
                                    i.unlock();
                                }
                            } catch (Throwable th2) {
                                TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th2);
                            }
                            b();
                            return 0;
                        }
                        a.set(Integer.valueOf(Integer.parseInt(property)));
                        int intValue = ((Integer) a.get()).intValue();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                            }
                        }
                        try {
                            if (i.isHeldByCurrentThread()) {
                                i.unlock();
                            }
                        } catch (Throwable th3) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th3);
                        }
                        b();
                        return intValue;
                    } catch (Exception e4) {
                        e = e4;
                    }
                } else {
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e22) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                        }
                    }
                    try {
                        if (i.isHeldByCurrentThread()) {
                            i.unlock();
                        }
                    } catch (Throwable th22) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th22);
                    }
                    b();
                    return 0;
                }
            } catch (Exception e5) {
                e = e5;
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th4) {
                th22 = th4;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e32) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                    }
                }
                try {
                    if (i.isHeldByCurrentThread()) {
                        i.unlock();
                    }
                } catch (Throwable th32) {
                    TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th32);
                }
                b();
                throw th22;
            }
        }
        b();
        return 0;
        b();
        return 0;
        try {
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
        } catch (Throwable th222) {
            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: " + th222);
        }
        b();
        return 0;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                }
            }
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
            b();
            return 0;
        } catch (Throwable th5) {
            th222 = th5;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e322) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e322.toString());
                }
            }
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
            b();
            throw th222;
        }
    }

    public boolean n(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File q = q(context);
        File p = p(context);
        try {
            j.a(p, true);
            j.a(q, p, new au(this));
            TbsShareManager.b(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    void o(Context context) {
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        ai.a(context).a(0);
        ai.a(context).b(0);
        ai.a(context).d(0);
        ai.a(context).a("incrupdate_retry_num", 0);
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig$TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
            ai.a(context).b(0, -1);
            ai.a(context).a("");
            ai.a(context).a("copy_retry_num", 0);
            ai.a(context).c(-1);
            ai.a(context).a(0, -1);
            j.a(t(context), true);
            j.a(v(context), true);
        }
    }

    File p(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File q(Context context) {
        return b(null, context);
    }

    File r(Context context) {
        File file = new File(context.getDir("tbs", 0), "share");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File t(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File u(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    File v(Context context) {
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        return (file.isDirectory() || file.mkdir()) ? file : null;
    }

    synchronized boolean w(Context context) {
        boolean z = true;
        synchronized (this) {
            this.e++;
            if (this.h) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
            } else {
                this.g = j.b(context, true, "tbslock.txt");
                if (this.g != null) {
                    this.f = j.a(context, this.g);
                    if (this.f == null) {
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.h = true;
                    }
                } else {
                    z = false;
                }
            }
        }
        return z;
    }
}
