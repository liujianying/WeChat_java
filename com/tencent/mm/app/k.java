package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver$Stub;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.ConditionVariable;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.a.c;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni;
import com.tencent.mm.sdk.platformtools.CrashMonitorForJni.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.Recovery;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.xweb.WebView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k implements c, d {
    public static final long byF = bi.VF();
    private static final String byN;
    private static final String byO;
    private static String byP = "";
    private static final String byQ = ("version:" + com.tencent.mm.protocal.d.qVN);
    private static long[] byR = new long[]{0, 0, 0};
    private static a sCrashExtraMessageGetter = new 1();
    private ak byG = null;
    private a byH;
    private volatile long byI = 0;
    HashSet<String> byJ;
    String byK;
    String byL;
    ConditionVariable byM;
    volatile b byS;

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
    }

    private static String uX() {
        String I = at.dBv.I("login_weixin_username", "");
        if (bi.oW(I)) {
            return at.dBv.I("login_user_name", "never_login_crash");
        }
        return I;
    }

    public static boolean cN(String str) {
        Object obj = null;
        byP = str;
        if (com.tencent.mm.plugin.y.d.bfB() == null) {
            Object cls;
            try {
                cls = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "setup sanbox Failed printing stack trace1.", new Object[0]);
                cls = obj;
            }
            try {
                obj = Class.forName("com.tencent.mm.plugin.sandbox.SubCoreSandBox", true, ad.getContext().getClassLoader());
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "setup sanbox Failed printing stack trace2.", new Object[0]);
            }
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test1: " + cls + " thisProcName: " + byP);
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass test2: " + obj + " thisProcName: " + byP);
            Class fI = com.tencent.mm.bg.d.fI("sandbox", ".SubCoreSandBox");
            x.i("MicroMsg.MMCrashReporter", "setup sanbox loadClass clz: " + fI + " thisProcName: " + byP);
            if (fI != null) {
                try {
                    com.tencent.mm.plugin.y.c cVar = (com.tencent.mm.plugin.y.c) fI.newInstance();
                    com.tencent.mm.plugin.y.d.a(cVar);
                    x.i("MicroMsg.MMCrashReporter", "setup sanbox mgr:" + cVar + " thisProcName: " + byP);
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "", new Object[0]);
                    x.w("MicroMsg.MMCrashReporter", "setup sanbox e type:%s, e msg:%s", new Object[]{e3.getClass().getSimpleName(), e3.getMessage()});
                }
            }
        }
        try {
            c cVar2 = (c) Class.forName("com.tencent.mm.crash.RDMCrashReporter").newInstance();
            cVar2.aX(ad.getContext());
            at.dBv.I("last_login_uin", byO);
            b.a(cVar2);
            2 2 = new 2();
            return true;
        } catch (Exception e4) {
            x.w("MicroMsg.MMCrashReporter", "rdm crash reporter load failed");
            k kVar = new k();
            kVar.aX(ad.getContext());
            b.a(kVar);
            String str2 = y.get("ro.product.cpu.abi");
            if (str2 == null || str2.length() == 0 || !(str2.equals("x86") || str2.equals("x86-64"))) {
                com.tencent.mm.compatible.util.k.b("wechatCrashForJni", k.class.getClassLoader());
                str2 = byQ;
                if (str.contains(":tools") || str.contains(":appbrand") || str.contains(":support")) {
                    str2 = str2 + "\n" + WebView.getCrashExtraMessage(ad.getContext()) + String.format(Locale.US, "client_version:%s;", new Object[]{com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION}) + "\n";
                    x.i("MicroMsg.MMCrashReporter", "append crash extra message : %s", new Object[]{str2});
                }
                CrashMonitorForJni.setCrashExtraMessageGetter(sCrashExtraMessageGetter);
                CrashMonitorForJni.setClientVersionMsg(str2);
            }
            cb.iO(e.duN);
            return false;
        }
    }

    public static void a(ak.c cVar) {
        ak.a(cVar);
    }

    private static void cO(String str) {
        while (str.length() > 896) {
            try {
                int lastIndexOf = str.substring(0, 896).lastIndexOf("\n");
                if (-1 == lastIndexOf) {
                    break;
                }
                x.e("MicroMsg.MMCrashReporter", str.substring(0, lastIndexOf));
                str = str.substring(lastIndexOf + 1);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed printing stack trace.", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.MMCrashReporter", str);
    }

    public final void aX(Context context) {
        Throwable e;
        BufferedReader bufferedReader;
        ak.a(this);
        if (byP.endsWith(":push")) {
            String str;
            try {
                str = y.get("dalvik.vm.stack-trace-file");
                if (str == null || str.length() == 0) {
                    str = "/data/anr/traces.txt";
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed finding out ANR trace file path, using default.", new Object[0]);
                str = "/data/anr/traces.txt";
            }
            File file = new File(str);
            this.byK = file.getParent();
            if (this.byK == null || this.byK.length() == 0) {
                this.byK = "/";
            }
            this.byL = file.getName();
            this.byM = new ConditionVariable();
            x.i("MicroMsg.MMCrashReporter", "Initialize ANR Observer, trace file: " + str);
            this.byJ = new HashSet();
            this.byH = new a(this, this.byK);
            this.byH.startWatching();
            File[] listFiles = new File(context.getFilesDir(), "crash").listFiles(new 3(this, context));
            if (listFiles != null) {
                StringBuilder stringBuilder = new StringBuilder(16384);
                Pattern compile = Pattern.compile("^signal (\\d+) \\([A-Z]+\\), code ");
                for (File file2 : listFiles) {
                    int i = -1;
                    x.i("MicroMsg.MMCrashReporter", "Uploading previous crash: " + file2);
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            stringBuilder.setLength(0);
                            while (true) {
                                Object readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                if (i < 0) {
                                    Matcher matcher = compile.matcher(readLine);
                                    if (matcher.matches()) {
                                        i = bi.getInt(matcher.group(1), 0);
                                    }
                                }
                                stringBuilder.append(readLine).append(10);
                            }
                            if (stringBuilder.toString().startsWith(byQ)) {
                                String substring = stringBuilder.toString().substring(stringBuilder.toString().indexOf(byQ) + byQ.length());
                                if (substring != null && substring.trim().length() > 0) {
                                    b(i, substring, true);
                                }
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        } catch (IOException e4) {
                            e2 = e4;
                            try {
                                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                file2.delete();
                            } catch (Throwable th) {
                                e2 = th;
                            }
                        }
                    } catch (IOException e6) {
                        e2 = e6;
                        bufferedReader = null;
                        x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "Failed uploading previous crash: " + file2, new Object[0]);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e52) {
                            }
                        }
                        file2.delete();
                    } catch (Throwable th2) {
                        e2 = th2;
                        bufferedReader = null;
                    }
                    file2.delete();
                }
                return;
            }
            return;
        }
        return;
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException e7) {
            }
        }
        throw e2;
        throw e2;
    }

    public final void A(String str, String str2) {
        if (com.tencent.mm.plugin.y.d.bfB() != null) {
            Intent intent = new Intent();
            intent.setAction("custom_exception");
            intent.putExtra("userName", uX());
            intent.putExtra("tag", str2);
            intent.putExtra("exceptionMsg", str);
            com.tencent.mm.plugin.y.d.bfB().t(ad.getContext(), intent);
        }
    }

    public final void a(com.tencent.mm.sdk.a.a aVar) {
        ak.a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.sdk.platformtools.ak r8, java.lang.String r9, java.lang.Throwable r10) {
        /*
        r7 = this;
        r6 = 0;
        r2 = "";
        r0 = r10 instanceof junit.framework.AssertionFailedError;
        if (r0 == 0) goto L_0x0073;
    L_0x0008:
        r3 = r10.getMessage();
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r0 != 0) goto L_0x0073;
    L_0x0012:
        r0 = r8.sGR;
        r0 = r0.entrySet();
        r4 = r0.iterator();
        if (r4 == 0) goto L_0x006f;
    L_0x001e:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x006f;
    L_0x0024:
        r0 = r4.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r0.getKey();
        r1 = (java.lang.String) r1;
        r5 = android.text.TextUtils.isEmpty(r1);
        if (r5 != 0) goto L_0x001e;
    L_0x0036:
        r5 = android.text.TextUtils.isEmpty(r3);
        if (r5 != 0) goto L_0x001e;
    L_0x003c:
        r1 = r3.startsWith(r1);
        if (r1 == 0) goto L_0x001e;
    L_0x0042:
        r0 = r0.getValue();
        r0 = (com.tencent.mm.sdk.platformtools.ak.b) r0;
        r0 = r0.JF();
    L_0x004c:
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r1 != 0) goto L_0x0073;
    L_0x0052:
        com.tencent.mm.app.p.b(r10);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 1;
        r0 = l(r0, r2);
        r0 = r1.append(r0);
        r0 = r0.append(r9);
        r0 = r0.toString();
        a(r0, r6, r6);
        return;
    L_0x006f:
        r0 = "";
        goto L_0x004c;
    L_0x0073:
        r0 = r2;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.k.a(com.tencent.mm.sdk.platformtools.ak, java.lang.String, java.lang.Throwable):void");
    }

    private static void a(String str, int i, boolean z) {
        cO(str);
        h.mEJ.a(11338, true, true, new Object[]{Integer.valueOf(2)});
        h.mEJ.a(25, 0, 1, true);
        if (ad.getProcessName().endsWith(":push")) {
            h.mEJ.a(25, 2, 1, true);
        } else if (ad.getProcessName().endsWith(":tools")) {
            h.mEJ.a(25, 3, 1, true);
        } else if (ad.getProcessName().endsWith(":exdevice")) {
            h.mEJ.a(25, 4, 1, true);
        } else if (ad.cic()) {
            h.mEJ.a(25, 1, 1, true);
        }
        h hVar = h.mEJ;
        h.brU();
        if (f.aV(ad.getContext()) == 1) {
            int aW = f.aW(ad.getContext());
            x.i("MicroMsg.MMCrashReporter", "google play crash size limit %s", new Object[]{Integer.valueOf(aW)});
            if (str.length() > aW) {
                str = str.substring(0, aW);
            }
        }
        f.g(ad.getContext(), ad.getProcessName(), z ? "jni" : "java");
        if (i > 0 && str.length() > i) {
            str = str.substring(0, i);
        }
        if (com.tencent.mm.plugin.y.d.bfB() != null) {
            Intent intent = new Intent();
            intent.setAction("uncatch_exception");
            intent.putExtra("exceptionPid", Process.myPid());
            intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
            intent.putExtra("userName", uX());
            intent.putExtra("exceptionMsg", Base64.encodeToString(str.getBytes(), 2));
            com.tencent.mm.plugin.y.d.bfB().t(ad.getContext(), intent);
        }
    }

    public final void l(int i, String str) {
        b(i, str, false);
    }

    private static void b(int i, String str, boolean z) {
        String str2 = null;
        if (i == 6) {
            try {
                String uY = uY();
                if (uY != null) {
                    str2 = a(uY, Process.myPid(), System.currentTimeMillis(), null);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed reporting JNI crash.", new Object[0]);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(1024);
        stringBuilder.append("#[jin_crash]sig=").append(i).append(10);
        stringBuilder.append("#crash.previous=").append(z).append(10);
        stringBuilder.append(l("", false));
        stringBuilder.append(str).append(10);
        if (str2 != null) {
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str2);
        }
        a(stringBuilder.toString(), i == 6 ? 0 : 8192, true);
        x.e("MicroMsg.MMCrashReporter", "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc");
        if (!z) {
            x.appenderClose();
        }
    }

    private static String uY() {
        String str;
        try {
            str = y.get("dalvik.vm.stack-trace-file");
            if (str == null || str.length() == 0) {
                str = "/data/anr/traces.txt";
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed finding out ANR trace file path, using default.", new Object[0]);
            str = "/data/anr/traces.txt";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            String processName = ad.getProcessName();
            if (processName == null || processName.length() == 0) {
                processName = "com.tencent.mm";
            }
            processName = str.substring(0, lastIndexOf) + '_' + processName + str.substring(lastIndexOf);
            if (new File(processName).isFile()) {
                return processName;
            }
        }
        return !new File(str).isFile() ? null : str;
    }

    static String a(String str, int i, long j, ProcessErrorStateInfo processErrorStateInfo) {
        Throwable e;
        Object obj = null;
        StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str2 = "----- pid " + i + " at ";
        if (processErrorStateInfo != null) {
            stringBuilder.append(processErrorStateInfo.longMsg).append(10);
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        switch (obj) {
                            case null:
                                if (!readLine.startsWith(str2)) {
                                    break;
                                }
                                int length = str2.length();
                                long time = simpleDateFormat.parse(readLine.substring(length, length + 19)).getTime() - j;
                                if (time >= -60000 && time <= 60000) {
                                    obj = 1;
                                    break;
                                }
                            case 1:
                                stringBuilder.append(readLine).append(10);
                                if (!readLine.startsWith("DALVIK THREADS")) {
                                    if (!readLine.startsWith("-----")) {
                                        break;
                                    }
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                    }
                                    return null;
                                }
                                obj = 2;
                                break;
                            case 2:
                                if (!readLine.startsWith("----- end ")) {
                                    stringBuilder.append(readLine).append(10);
                                    break;
                                }
                                String stringBuilder2 = stringBuilder.toString();
                                try {
                                    bufferedReader.close();
                                    return stringBuilder2;
                                } catch (IOException e3) {
                                    return stringBuilder2;
                                }
                            default:
                                break;
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e4) {
                    }
                } catch (Exception e5) {
                    e = e5;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            try {
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e, "Failed parsing ANR trace file.", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e7) {
                    }
                }
                return null;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e82) {
                }
            }
            throw e;
        }
        return null;
    }

    final void r(String str, int i) {
        Recovery.cEQ();
        h.mEJ.a(11339, true, true, new Object[]{Integer.valueOf(Downloads.MIN_RETYR_AFTER), Integer.valueOf(0)});
        h.mEJ.a(26, 0, 1, true);
        cO(str);
        h hVar = h.mEJ;
        h.brU();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.byI >= 120000) {
            this.byI = currentTimeMillis;
            f.g(ad.getContext(), ad.getProcessName(), "anr");
            StringBuilder stringBuilder = new StringBuilder(Downloads.RECV_BUFFER_SIZE);
            stringBuilder.append(l("", true));
            stringBuilder.append("******* ANR Trace *******\n");
            stringBuilder.append(str);
            if (com.tencent.mm.plugin.y.d.bfB() != null) {
                Intent intent = new Intent();
                intent.setAction("uncatch_exception");
                intent.putExtra("tag", "anr");
                intent.putExtra("exceptionPid", i);
                intent.putExtra("exceptionTime", SystemClock.elapsedRealtime());
                intent.putExtra("userName", at.dBv.I("login_user_name", "never_login_crash"));
                intent.putExtra("exceptionMsg", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                com.tencent.mm.plugin.y.d.bfB().t(ad.getContext(), intent);
            }
        }
    }

    private static String l(String str, boolean z) {
        Throwable e;
        String format;
        Throwable e2;
        int[] iArr;
        MemoryInfo[] processMemoryInfo;
        StringBuilder stringBuilder = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
        Context context = ad.getContext();
        stringBuilderPrinter.println("#client.version=" + com.tencent.mm.protocal.d.qVN);
        stringBuilderPrinter.println("#client.verhistory=" + cb.IT());
        stringBuilderPrinter.println("#client.imei=" + q.zy());
        stringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.d.REV);
        stringBuilderPrinter.println("#accinfo.uin=" + at.dBv.I("last_login_uin", byO));
        stringBuilderPrinter.println("#accinfo.dev=" + byN);
        stringBuilderPrinter.println("#accinfo.runtime=" + (bi.VF() - byF) + "(" + bi.oV(byP) + ")");
        stringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.d.TIME + ":" + com.tencent.mm.sdk.platformtools.d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bxk);
        stringBuilderPrinter.println("#qbrwoser.corever=" + WebView.getInstalledTbsCoreVersion(context));
        stringBuilderPrinter.println("#qbrowser.ver=" + WebView.getTbsSDKVersion(context));
        if (z) {
            stringBuilderPrinter.println(sCrashExtraMessageGetter.va());
        }
        stringBuilderPrinter.println("#accinfo.env=" + (b.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + b.sFc);
        String str2 = "";
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnC);
            int memoryClass = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
            int largeMemoryClass = ((ActivityManager) context.getSystemService("activity")).getLargeMemoryClass();
            Context context2 = ad.getContext();
            String packageName = ad.getContext().getPackageName();
            synchronized (byR) {
                try {
                    PackageManager.class.getMethod("getPackageSizeInfo", new Class[]{String.class, IPackageStatsObserver.class}).invoke(context2.getPackageManager(), new Object[]{packageName, new IPackageStatsObserver$Stub() {
                        public final void onGetStatsCompleted(PackageStats packageStats, boolean z) {
                            if (packageStats != null) {
                                try {
                                    k.byR[0] = packageStats.cacheSize;
                                    k.byR[1] = packageStats.dataSize;
                                    k.byR[2] = packageStats.codeSize;
                                    x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted succeeded[%b] cacheSize :%d ,dataSize :%d ,codeSize :%d ", new Object[]{Boolean.valueOf(z), Long.valueOf(packageStats.cacheSize), Long.valueOf(packageStats.dataSize), Long.valueOf(packageStats.codeSize)});
                                } catch (Throwable th) {
                                    x.printErrStackTrace("MicroMsg.MMCrashReporter", th, "onGetStatsCompleted", new Object[0]);
                                    return;
                                }
                            }
                            x.i("MicroMsg.MMCrashReporter", "onGetStatsCompleted pStats is null succeeded[%b]", new Object[]{Boolean.valueOf(z)});
                            synchronized (k.byR) {
                                k.byR.notify();
                            }
                        }
                    }});
                    byR.wait(500);
                } catch (Throwable e3) {
                    byR[0] = -1;
                    byR[1] = -1;
                    byR[2] = -1;
                    x.printErrStackTrace("MicroMsg.MMCrashReporter", e3, "crash e:", new Object[0]);
                    synchronized (byR) {
                        byR.notify();
                    }
                }
            }
            format = String.format("%dMB %dMB %s:%d:%d:%d %d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), Long.valueOf(byR[0]), Long.valueOf(byR[1]), Long.valueOf(byR[2]), e.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e4) {
            x.e("MicroMsg.MMCrashReporter", "check data size failed :%s", new Object[]{e4.getMessage()});
            format = str2;
        }
        stringBuilderPrinter.println("#accinfo.data=" + format);
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        String str3 = "";
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = 0;
        if (com.tencent.mm.compatible.util.d.fR(16)) {
            j = memoryInfo.totalMem;
        } else {
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    char[] toCharArray = randomAccessFile.readLine().toCharArray();
                    int length = toCharArray.length;
                    int i = 0;
                    while (i < length) {
                        if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                            stringBuffer.append(toCharArray[i]);
                        }
                        i++;
                    }
                    long j2 = bi.getLong(stringBuffer.toString(), -1);
                    if (j2 > 0) {
                        j = j2 << 10;
                    }
                    try {
                        randomAccessFile.close();
                    } catch (Exception e5) {
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    try {
                        x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e7) {
                            }
                        }
                        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                        iArr = new int[]{Process.myPid()};
                        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                        if (processMemoryInfo != null) {
                        }
                        format = str2;
                        stringBuilderPrinter.println("#accinfo.memory=" + format);
                        if (!bi.oW(str)) {
                            stringBuilderPrinter.println("#" + str);
                        }
                        stringBuilderPrinter.println("#crashContent=");
                        return stringBuilder.toString();
                    } catch (Throwable th) {
                        e3 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e8) {
                            }
                        }
                        throw e3;
                    }
                }
            } catch (Exception e9) {
                e2 = e9;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.MMCrashReporter", e2, "", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e72) {
                    }
                }
                str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
                iArr = new int[]{Process.myPid()};
                processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
                if (processMemoryInfo != null) {
                }
                format = str2;
                stringBuilderPrinter.println("#accinfo.memory=" + format);
                if (bi.oW(str)) {
                    stringBuilderPrinter.println("#" + str);
                }
                stringBuilderPrinter.println("#crashContent=");
                return stringBuilder.toString();
            } catch (Throwable th2) {
                e3 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e82) {
                    }
                }
                throw e3;
            }
        }
        str2 = (str3 + "[total: " + j + " " + memoryInfo.availMem + " " + memoryInfo.threshold + " " + memoryInfo.lowMemory + "]") + "[native: " + Debug.getNativeHeapSize() + " " + Debug.getNativeHeapAllocatedSize() + " " + Debug.getNativeHeapFreeSize() + "]";
        iArr = new int[]{Process.myPid()};
        processMemoryInfo = activityManager.getProcessMemoryInfo(iArr);
        if (processMemoryInfo != null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null) {
            format = str2;
        } else {
            MemoryInfo memoryInfo2 = processMemoryInfo[0];
            format = str2 + "[pid(" + iArr[0] + "):" + (memoryInfo2.getTotalPss() << 10) + " " + (memoryInfo2.getTotalPrivateDirty() << 10) + " " + (memoryInfo2.getTotalSharedDirty() << 10) + "]";
        }
        stringBuilderPrinter.println("#accinfo.memory=" + format);
        if (bi.oW(str)) {
            stringBuilderPrinter.println("#" + str);
        }
        stringBuilderPrinter.println("#crashContent=");
        return stringBuilder.toString();
    }
}
