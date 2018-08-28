package com.tencent.mm.plugin.normsg.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import com.tencent.mm.ipcinvoker.wx_extension.a.a.b;
import com.tencent.mm.plugin.normsg.b.b.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class a implements g {
    public static final a<String> lFM;
    private long lFN;
    private long lFO;
    private long lFP;
    private long lFQ;
    private long lFR;
    private int lFS;
    private boolean lFT;
    private long lFU;

    private static final class a<T> extends HashSet<T> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final boolean add(T t) {
            if (!contains(t)) {
                return super.add(t);
            }
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            throw new UnsupportedOperationException();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    static {
        a aVar = new a();
        lFM = aVar;
        aVar.add("");
        lFM.add(":tools");
        lFM.add(":appbrand");
    }

    public static a bjF() {
        return b.lFV;
    }

    private a() {
        this.lFN = 0;
        this.lFO = 0;
        this.lFP = 0;
        this.lFQ = 0;
        this.lFR = 0;
        this.lFS = 0;
        this.lFT = false;
        this.lFU = 0;
        bjH();
    }

    public final synchronized void uc(int i) {
        this.lFS = i;
    }

    public final void a(int i, View view, List<AccessibilityNodeInfo> list) {
        boolean z;
        int i2 = 0;
        String view2 = view != null ? view.toString() : "";
        String ud = ud(i);
        String str = "MircoMsg.AEDHLP";
        String str2 = "[tomys] ae about searching, pid:%d, pname:%s, vwinfo:%s, is_found:%b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = ud;
        objArr[2] = view2;
        if (list == null || list.size() <= 0) {
            z = false;
        } else {
            z = true;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (list != null) {
            i2 = list.size();
        }
        bQ(ud, i2);
        if (c.bjK() && ud != null && ud.contains(d.IO(">\u0010r\u001bc\u0001xV")) && list != null) {
            list.clear();
        }
    }

    public final boolean a(int i, int i2, View view) {
        String view2 = view != null ? view.toString() : "";
        String ud = ud(i2);
        x.i("MircoMsg.AEDHLP", "[tomys] ae about action, pid:%d, pname:%s, vwinfo:%s, action:%d", new Object[]{Integer.valueOf(i2), ud, view2, Integer.valueOf(i)});
        e(i, view);
        n(i, ud, view2);
        if (c.bjK() && ud != null && ud.contains(d.IO(">\u0010r\u001bc\u0001xV"))) {
            return false;
        }
        return true;
    }

    public final void f(Throwable th) {
        x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] unexpected error happens.", new Object[0]);
        g(th);
    }

    public final synchronized long bjG() {
        return this.lFR;
    }

    private synchronized void bjH() {
        Throwable th;
        Closeable dataInputStream;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(ad.getContext().getCacheDir(), d.IO("ãçÜºÈ­Üòù")))));
            try {
                if (((long) dataInputStream.readInt()) != -606158847) {
                    throw new IllegalStateException("bad magic.");
                }
                this.lFN = dataInputStream.readLong();
                this.lFO = dataInputStream.readLong();
                this.lFP = dataInputStream.readLong();
                this.lFQ = dataInputStream.readLong();
                long readLong = dataInputStream.readLong();
                if (readLong > 0 && this.lFR <= 0) {
                    this.lFR = readLong;
                }
                bi.d(dataInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to load rec.", new Object[0]);
                    this.lFN = 0;
                    this.lFO = 0;
                    this.lFP = 0;
                    this.lFQ = System.currentTimeMillis();
                    this.lFR = 0;
                    bjI();
                    bi.d(dataInputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(dataInputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            bi.d(dataInputStream);
            throw th;
        }
    }

    private synchronized void bjI() {
        Throwable th;
        Closeable dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(ad.getContext().getCacheDir(), d.IO("ãçÜºÈ­Üòù")))));
            try {
                dataOutputStream.writeInt(-606158847);
                dataOutputStream.writeLong(this.lFN);
                dataOutputStream.writeLong(this.lFO);
                dataOutputStream.writeLong(this.lFP);
                dataOutputStream.writeLong(this.lFQ);
                dataOutputStream.writeLong(this.lFR);
                bi.d(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th, "[tomys] failure to save rec.", new Object[0]);
                    bi.d(dataOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    bi.d(dataOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            bi.d(dataOutputStream);
            throw th;
        }
    }

    private synchronized void e(int i, View view) {
        if (view != null && i == 16) {
            synchronized (this) {
                if (this.lFS != 0) {
                    if ((view instanceof Button) && view.getId() == this.lFS) {
                        this.lFR++;
                        bjI();
                    }
                }
            }
        }
    }

    private synchronized void bQ(String str, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lFN > 86400000) {
            h.mEJ.c("Normsg_AED", "findview, pkg: " + str + ", res_count: " + i, null);
            this.lFN = currentTimeMillis;
            bjI();
        }
        if (com.tencent.mm.compatible.util.h.Ae() && c.bjM()) {
            bjJ();
        }
    }

    private synchronized void n(int i, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lFO > 86400000) {
            h.mEJ.c("Normsg_AED", "action: " + i + ", pkg: " + str + ", view: " + str2, null);
            this.lFO = currentTimeMillis;
            bjI();
        }
        if (com.tencent.mm.compatible.util.h.Ae() && c.bjM()) {
            bjJ();
        }
    }

    private synchronized void bjJ() {
        if (!this.lFT) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lFU >= 2000) {
                this.lFU = currentTimeMillis;
                this.lFT = true;
                d.mOw.vJ(-2147483647);
            }
        }
    }

    public final synchronized void g(Throwable th) {
        Throwable th2;
        Closeable closeable;
        if (th != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lFP > 86400000) {
                Writer stringWriter = new StringWriter();
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(stringWriter);
                    try {
                        th.printStackTrace(printWriter);
                        bi.d(printWriter);
                    } catch (Throwable th3) {
                        th2 = th3;
                        closeable = printWriter;
                        bi.d(closeable);
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    closeable = null;
                    bi.d(closeable);
                    throw th2;
                }
                h.mEJ.c("Normsg_AED_Errors", "error:" + stringWriter.toString(), null);
                this.lFP = currentTimeMillis;
                bjI();
            }
        }
    }

    private static String ud(int i) {
        Throwable th;
        ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
        if (activityManager == null) {
            return "";
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        return runningAppProcessInfo.processName;
                    }
                }
            }
        } catch (Throwable th2) {
            x.printErrStackTrace("MircoMsg.AEDHLP", th2, "[tomys] failure on step1.", new Object[0]);
        }
        try {
            List<RunningServiceInfo> runningServices = activityManager.getRunningServices(16384);
            if (runningServices != null) {
                for (RunningServiceInfo runningServiceInfo : runningServices) {
                    if (runningServiceInfo.pid == i) {
                        return runningServiceInfo.process;
                    }
                }
            }
        } catch (Throwable th3) {
            x.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step2.", new Object[0]);
        }
        Closeable closeable = null;
        Closeable bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(String.format(Locale.ENGLISH, d.IO("ÃìîâÍè£À­É¥Ì¢Ç"), new Object[]{Integer.valueOf(i)})));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    readLine = readLine.trim();
                    bi.d(bufferedReader);
                    return readLine;
                }
                bi.d(bufferedReader);
                return "";
            } catch (Throwable th4) {
                th3 = th4;
                try {
                    x.printErrStackTrace("MircoMsg.AEDHLP", th3, "[tomys] failure on step3.", new Object[0]);
                    bi.d(bufferedReader);
                    return "";
                } catch (Throwable th5) {
                    th3 = th5;
                    closeable = bufferedReader;
                    bi.d(closeable);
                    throw th3;
                }
            }
        } catch (Throwable th6) {
            th3 = th6;
            bi.d(closeable);
            throw th3;
        }
    }

    public static String IQ(String str) {
        int indexOf = str.indexOf(58);
        return indexOf != -1 ? str.substring(indexOf) : "";
    }

    private static String dZ(String str, String str2) {
        try {
            com.tencent.mm.kernel.g.Eg().Ds();
            try {
                com.tencent.mm.ipcinvoker.wx_extension.a.a aVar = b.dnp;
                c fJ = com.tencent.mm.ipcinvoker.wx_extension.a.a.fJ("100373");
                if (fJ == null || !fJ.isValid()) {
                    x.w("MircoMsg.AEDHLP", "check point 1, explained by src code.");
                    return str2;
                }
                Map ckq = fJ.ckq();
                if (ckq == null) {
                    x.w("MircoMsg.AEDHLP", "check point 2, explained by src code.");
                    return str2;
                }
                String str3 = (String) ckq.get(str);
                if (str3 == null || str3.length() <= 0) {
                    return str2;
                }
                return str3;
            } catch (com.tencent.mm.model.b e) {
                x.printErrStackTrace("MircoMsg.AEDHLP", e, "check point 1-1, explained by src code.", new Object[0]);
                return str2;
            }
        } catch (com.tencent.mm.model.b e2) {
            x.w("MircoMsg.AEDHLP", "check point 0, explained by src code.");
            return str2;
        }
    }
}
