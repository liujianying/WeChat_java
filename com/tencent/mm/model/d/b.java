package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.r;
import com.tencent.mm.bt.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements c$a {
    private static final String byN;
    private static final String byO;
    private static b dFd;
    public static final String dFe = (e.bnC + "/tencent/MicroMsg/SQLTrace/");
    public static List<String> dFn = Arrays.asList(new String[]{"FTS5IndexMicroMsg.db"});
    long[] byR = new long[]{0, 0, 0};
    private long dEJ = 0;
    public volatile boolean dEK = false;
    public long dFf;
    public long dFg;
    public long dFh;
    public long dFi;
    long dFj;
    private long dFk;
    private long dFl;
    private long dFm;
    private SharedPreferences duR = ad.chZ();

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
    }

    public static b JG() {
        if (dFd == null) {
            dFd = new b();
        }
        return dFd;
    }

    public b() {
        JH();
    }

    private void JH() {
        this.dFf = this.duR.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.dFg = this.duR.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.dFh = this.duR.getLong("sql_trace_child_thread_interval_time", 1500);
        long bG = bG(ad.getContext());
        if (bG > 0) {
            this.dFf += bG;
            this.dFg += bG;
            this.dFh += bG;
            x.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", new Object[]{Long.valueOf(bG)});
        }
        this.dFi = this.duR.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.dFm = this.duR.getLong("sql_trace_file_full_size", 30720);
        this.dFj = this.duR.getLong("sql_trace_log_file_max_size", 35840);
        this.dFk = this.duR.getLong("sql_trace_upload_file_min_size", 10240);
        this.dFl = this.duR.getLong("sql_upload_time_interval", 21600000);
        q(new File(dFe, "MMSQL.trace"));
        x.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", new Object[]{Long.valueOf(this.dFf), Long.valueOf(this.dFg), Long.valueOf(this.dFh), Long.valueOf(this.dFi), Long.valueOf(this.dFm), Long.valueOf(this.dFj), Long.valueOf(this.dFk), Long.valueOf(this.dFl)});
    }

    public static void setup() {
        if (ad.sGA) {
            x.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + com.tencent.mm.a.e.deleteFile(dFe + "MMSQL.trace"));
        }
    }

    final void q(File file) {
        boolean z = true;
        if (file.exists()) {
            this.dEK = file.length() > this.dFm;
            if (this.dEK) {
                long bF = bF(ad.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (bF == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (bF == 0) {
                    d(ad.getContext(), System.currentTimeMillis());
                    return;
                }
                return;
            }
            return;
        }
        this.dEK = false;
    }

    public static String jd(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.bv.e.bF(bArr));
                try {
                    fileInputStream2.close();
                    return str2;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e2, "", new Object[0]);
                    return str2;
                }
            } catch (IOException e3) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e4 = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e22, "", new Object[0]);
                    }
                }
                throw e4;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e42, "", new Object[0]);
                }
            }
            return null;
        } catch (Throwable th2) {
            e42 = th2;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.SQLTraceManager", e222, "", new Object[0]);
                }
            }
            throw e42;
        }
    }

    private static long a(String str, h hVar) {
        Cursor b = hVar.b("select count(*) from " + str, null, 2);
        long j = 0;
        if (b.moveToFirst()) {
            j = b.getLong(0);
        }
        b.close();
        return j;
    }

    private String JB() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.qVN);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.d.REV);
        printStream.println("#accinfo.uin=" + at.dBv.I("last_login_uin", byO));
        printStream.println("#accinfo.dev=" + byN);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.d.TIME + ":" + com.tencent.mm.sdk.platformtools.d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bxk);
        String str = "";
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnC);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.SQLTraceManager", "check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long bG = bG(ad.getContext());
        if (bG > 0) {
            printStream.println("#logfile.autoAdapteTime :" + bG);
        }
        if (bF(ad.getContext()) != 0) {
            long bF = bF(ad.getContext()) - bE(ad.getContext());
            printStream.println("#logfile.fulllast :" + bF);
            if (bF > 0 && bF < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(ad.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", bG + 100).commit();
                x.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", new Object[]{Long.valueOf(bG)});
                JH();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - bE(ad.getContext())));
        }
        m[] ik = r.Qp().ik(21);
        if (ik == null || ik.length == 0 || ik[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + ik[0].id + " version=" + ik[0].version);
        }
        if (this.byR[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.byR[0] + " data size= " + this.byR[1] + " code size =" + this.byR[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        au.HU();
        printStream.println(stringBuilder.append(new File(c.DR()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        au.HU();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.Gp()).append("SnsMicroMsg.db").toString()).length()).toString());
        au.HU();
        a(c.FP(), printStream, Arrays.asList(new String[]{"message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static void a(h hVar, PrintStream printStream, List<String> list) {
        if (hVar == null || !hVar.isOpen()) {
            x.i("MicroMsg.SQLTraceManager", "db is not open!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor b = hVar.b("select name from sqlite_master where type='table' ", null, 2);
            while (b.moveToNext()) {
                String string = b.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, hVar));
            }
            b.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, hVar));
            }
        }
        x.i("MicroMsg.SQLTraceManager", "dump all table count last %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(":").append(str2).append(" ");
    }

    public final void jf(String str) {
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String I = at.dBv.I("login_weixin_username", "");
        if (bi.oW(I)) {
            I = at.dBv.I("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, I);
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((JB() + str).getBytes(), 2));
        ad.getContext().startService(intent);
    }

    final void b(File file, boolean z) {
        x.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", new Object[]{Boolean.valueOf(z)});
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            q(file);
        }
        try {
            file.createNewFile();
            Context context = ad.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(ad.getContext(), 0);
        } catch (IOException e) {
            x.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        q(file);
    }

    public static void c(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
    }

    public static long bD(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
    }

    private static long bE(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
    }

    private static void d(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
    }

    private static long bF(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
    }

    private static long bG(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
    }

    public final void JC() {
        x.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        JH();
    }
}
