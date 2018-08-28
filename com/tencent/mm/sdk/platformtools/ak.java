package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.by.j;
import com.tencent.recovery.crash.DefaultExceptionHandler;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public final class ak implements UncaughtExceptionHandler {
    private static ak sGN = null;
    private d sGO;
    private com.tencent.mm.sdk.a.a sGP;
    public a sGQ;
    public Map<String, b> sGR;
    private UncaughtExceptionHandler sGS;
    private boolean sGT;
    private List<c> sGU;

    public interface a {
        void uV();
    }

    public interface b {
        String JF();
    }

    public interface c {
        void c(String str, Throwable th);
    }

    public interface d {
        void a(ak akVar, String str, Throwable th);
    }

    public static synchronized void a(d dVar) {
        synchronized (ak.class) {
            if (sGN == null) {
                sGN = new ak();
            }
            sGN.sGO = dVar;
        }
    }

    public static synchronized void a(com.tencent.mm.sdk.a.a aVar) {
        synchronized (ak.class) {
            if (sGN == null) {
                sGN = new ak();
            }
            sGN.sGP = aVar;
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (ak.class) {
            if (sGN == null) {
                sGN = new ak();
            }
            sGN.sGQ = aVar;
        }
    }

    public static synchronized void a(String str, b bVar) {
        synchronized (ak.class) {
            if (sGN == null) {
                sGN = new ak();
            }
            sGN.sGR.put(str, bVar);
        }
    }

    public static synchronized void r(String str, final String str2, boolean z) {
        synchronized (ak.class) {
            a(str, new b() {
                public final String JF() {
                    return "subinfo=" + str2;
                }
            });
            Assert.assertTrue(str, z);
        }
    }

    public static synchronized void a(c cVar) {
        synchronized (ak.class) {
            if (cVar != null) {
                if (sGN == null) {
                    sGN = new ak();
                }
                sGN.sGU.add(cVar);
            }
        }
    }

    private ak() {
        this.sGO = null;
        this.sGP = null;
        this.sGQ = null;
        this.sGR = new HashMap();
        this.sGS = null;
        this.sGT = false;
        this.sGU = new LinkedList();
        this.sGS = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(this));
    }

    private static String Ws(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }

    public static String j(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th.getCause() != null) {
            try {
                th = th.getCause();
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        th.printStackTrace(printStream);
        String Ws = Ws(byteArrayOutputStream.toString());
        return Ws;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        if (!this.sGT) {
            this.sGT = true;
            try {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                Throwable th2 = th;
                while (th2.getCause() != null) {
                    th2 = th2.getCause();
                }
                th2.printStackTrace(printStream);
                final String Ws = Ws(byteArrayOutputStream.toString());
                if (!(this.sGP == null || Ws == null)) {
                    HandlerThread handlerThread = new HandlerThread("close-db-while-crash");
                    handlerThread.start();
                    final j jVar = new j();
                    new Handler(handlerThread.getLooper()).post(new Runnable() {
                        public final void run() {
                            ak.this.sGP.ge(Ws);
                            j jVar = jVar;
                            synchronized (jVar.dol) {
                                if (jVar.dol[0] == (byte) 0) {
                                    jVar.dol[0] = (byte) 1;
                                    jVar.dol.notifyAll();
                                    x.i("MicroMsg.WxTimeoutLock", "notify done %s", jVar);
                                }
                            }
                        }
                    });
                    synchronized (jVar.dol) {
                        if (jVar.dol[0] != (byte) 0) {
                            x.i("MicroMsg.WxTimeoutLock", "no need lock %s", jVar);
                        } else {
                            try {
                                jVar.dol.wait(3000);
                            } catch (Throwable th22) {
                                x.printErrStackTrace("MicroMsg.WxTimeoutLock", th22, "", new Object[0]);
                            }
                        }
                    }
                }
                if (!(this.sGO == null || Ws == null)) {
                    this.sGO.a(this, Ws, th);
                    this.sGQ.uV();
                }
                for (c cVar : this.sGU) {
                    if (cVar != null) {
                        try {
                            cVar.c(Ws, th);
                        } catch (Exception e) {
                        }
                    }
                }
                byteArrayOutputStream.close();
            } catch (Exception e2) {
            }
            x.appenderClose();
            if (com.tencent.mm.loader.stub.a.DEBUG) {
                this.sGS.uncaughtException(thread, th);
                return;
            }
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }
}
