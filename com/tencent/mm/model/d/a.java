package com.tencent.mm.model.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.r;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.at;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class a implements com.tencent.mm.model.d.c.a {
    private static final String byN;
    private static final String byO;
    public static String byP = "";
    private static a dEG;
    private static final String dEH = (e.bnC + "/tencent/MicroMsg/Handler/");
    public static final String dEI = (dEH + "Handler.trace");
    private static final long dEL = Looper.getMainLooper().getThread().getId();
    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    long[] byR;
    private long dEJ;
    private volatile boolean dEK;
    private long dEM;
    private long dEN;
    private long dEO;
    private long dEP;
    private long dEQ;
    private long dER;
    private long dES;
    private int dET;
    private int dEU;
    private int dEV;
    private Long[] dEW;
    public long dEX;
    private String dEY;
    private LinkedList<a> dEZ;
    private SharedPreferences duR;

    static /* synthetic */ void a(a aVar, String str, String str2) {
        Throwable e;
        if (f.zZ()) {
            File file;
            try {
                file = new File(dEH);
                if (!file.exists()) {
                    file.mkdirs();
                }
                aVar.b(new File(dEH, "Handler.trace"), false);
            } catch (Exception e2) {
            }
            file = new File(str);
            if (file.length() > aVar.dEP) {
                x.e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                aVar.b(file, true);
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(com.tencent.mm.bv.e.bF(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Exception e3) {
                    }
                } catch (IOException e4) {
                    e = e4;
                    try {
                        x.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e5) {
                            }
                        }
                        aVar.q(new File(dEI));
                        return;
                    } catch (Throwable th) {
                        e = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (IOException e7) {
                e = e7;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e52) {
                    }
                }
                aVar.q(new File(dEI));
                return;
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Exception e62) {
                    }
                }
                throw e;
            }
            aVar.q(new File(dEI));
            return;
        }
        x.i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
    }

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
    }

    private a() {
        this.byR = new long[]{0, 0, 0};
        this.dEJ = 0;
        this.dEK = false;
        this.dEM = 8000;
        this.dEN = 800;
        this.dEO = 25600;
        this.dEP = 35840;
        this.dEQ = 86400000;
        this.dER = 180000;
        this.dES = 5000;
        this.dET = 120;
        this.dEU = 50;
        this.dEV = 1800000;
        this.duR = ad.chZ();
        this.dEW = new Long[18];
        this.dEX = 0;
        this.dEY = "";
        this.dEZ = new LinkedList();
        this.dEM = this.duR.getLong("handler_debug_log_time", 8000);
        this.dEN = this.duR.getLong("handler_debug_log_time_main", 800);
        this.dEO = this.duR.getLong("handler_trace_file_full_size", 25600);
        this.dEP = this.duR.getLong("handler_log_file_max_size", 35840);
        this.dEQ = this.duR.getLong("handler_upload_time_interval", 86400000);
        Arrays.fill(this.dEW, Long.valueOf(0));
    }

    public static a JA() {
        if (dEG == null) {
            synchronized (a.class) {
                if (dEG == null) {
                    dEG = new a();
                }
            }
        }
        return dEG;
    }

    private void q(File file) {
        boolean z = true;
        if (file.exists()) {
            this.dEK = file.length() > this.dEO;
            if (this.dEK) {
                long j = this.duR.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str, str2, objArr);
                if (j == 0) {
                    this.duR.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                    return;
                }
                return;
            }
            return;
        }
        this.dEK = false;
    }

    final String JB() {
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
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.bnC);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.bnC, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            x.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", new Object[]{e.getMessage()});
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :" + (this.duR.getLong("handler_trace_log_file_full_time", 0) - this.duR.getLong("handler_trace_log_file_create_time", 0)));
        if (this.byR[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.byR[0] + " data size=" + this.byR[1] + " code size=" + this.byR[2]);
        }
        m[] ik = r.Qp().ik(21);
        if (ik == null || ik.length == 0 || ik[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + ik[0].id + " version=" + ik[0].version);
        }
        printStream.println("#handler.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static String jd(String str) {
        FileInputStream fileInputStream;
        Throwable th;
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
                } catch (Exception e) {
                    return str2;
                }
            } catch (IOException e2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e32) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception e42) {
                }
            }
            throw th;
        }
    }

    private void b(File file, boolean z) {
        x.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", new Object[]{Boolean.valueOf(z)});
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            q(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            x.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.duR.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        q(file);
    }

    public final void JC() {
        x.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.dEM = this.duR.getLong("handler_debug_log_time", 8000);
        this.dEN = this.duR.getLong("handler_debug_log_time_main", 800);
        this.dEO = this.duR.getLong("handler_trace_file_full_size", 25600);
        this.dEP = this.duR.getLong("handler_log_file_max_size", 35840);
        this.dEQ = this.duR.getLong("handler_upload_time_interval", 86400000);
        this.dER = this.duR.getLong("handler_worker_assert_time", 180000);
        this.dES = this.duR.getLong("handler_worker_warn_time", 5000);
        this.dET = (int) this.duR.getLong("handler_worker_warn_task_max_size", 120);
        this.dEU = (int) this.duR.getLong("handler_worker_warn_task_keep_size", 50);
        this.dEV = (int) this.duR.getLong("handler_worker_warn_task_keep_size", 1800000);
        q(new File(dEI));
    }
}
