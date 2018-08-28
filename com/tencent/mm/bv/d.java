package com.tencent.mm.bv;

import android.os.Debug;
import android.os.Environment;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.p;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public final class d implements EventListener {
    static ag dvh = new 2();
    public static d tfC;
    private static int tfD = 5242880;
    public static final String tfF = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/tracedog/");
    public static a tfx = null;
    private volatile boolean egv;
    private volatile boolean tfE;
    private LinkedBlockingQueue<a> tfG;
    ExecutorService tfH;
    public WeakReference<b> tfI;

    public static d cov() {
        if (tfC == null) {
            tfC = new d();
        }
        return tfC;
    }

    private void a(a aVar) {
        if (!this.tfE) {
            if (c.zZ()) {
                cow();
                try {
                    File file = new File(tfF);
                    if (aVar.ccC != 6 && file.exists()) {
                        x.i("MicroMsg.TraceDebugManager", "TRACE delete all file ");
                        R(file);
                    }
                    file.mkdirs();
                    Debug.startMethodTracing(aVar.savePath, aVar.tfL <= 0 ? tfD : (aVar.tfL * 1024) * 1024);
                    this.tfE = true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
                } catch (Throwable e2) {
                    this.tfE = false;
                    x.printErrStackTrace("MicroMsg.TraceDebugManager", e2, "TRACE startMethodTracing ERROR", new Object[0]);
                }
                if (aVar.ccC == 6) {
                    x.i("MicroMsg.TraceDebugManager", "TRACE startTrace uploadType is CLIENT ");
                    return;
                } else if (this.tfE) {
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = aVar;
                    if (bi.oW(aVar.className) || aVar.ccC == 5) {
                        dvh.sendMessageDelayed(obtain, 15000);
                        return;
                    } else {
                        dvh.sendMessageDelayed(obtain, 10000);
                        return;
                    }
                } else {
                    return;
                }
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE sdcard is invalid");
        }
    }

    private static void cow() {
        dvh.removeMessages(0);
        dvh.removeMessages(2);
        dvh.removeMessages(1);
    }

    private static void R(File file) {
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                file.delete();
                return;
            }
            for (File R : listFiles) {
                R(R);
            }
            file.delete();
        }
    }

    public final boolean b(a aVar) {
        cow();
        if (!this.tfE || this.egv) {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace hasStartTrace : %b ,isUploading :%b  ", new Object[]{Boolean.valueOf(this.tfE), Boolean.valueOf(this.egv)});
            return false;
        } else if (c.zZ()) {
            this.tfH.execute(new 1(this, aVar));
            return true;
        } else {
            x.i("MicroMsg.TraceDebugManager", "TRACE stopTrace sdcard invalid");
            return false;
        }
    }

    private static String S(File file) {
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory()) {
            x.i("MicroMsg.TraceDebugManager", "TRACE currentPath is dir");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                x.e("MicroMsg.TraceDebugManager", " get file list failed");
                return null;
            }
            for (Object add : listFiles) {
                arrayList.add(add);
            }
        } else {
            arrayList.add(file);
        }
        File file2 = new File(tfF + bi.VF() + ".zip");
        try {
            p.a(arrayList, file2);
            for (int i = 0; i < arrayList.size(); i++) {
                ((File) arrayList.get(i)).delete();
            }
            if (file2.length() <= 3145728) {
                return file2.getAbsolutePath();
            }
            x.e("MicroMsg.TraceDebugManager", "trace file is too large:%d ", new Object[]{Long.valueOf(file2.length())});
            return null;
        } catch (Throwable e) {
            x.e("MicroMsg.TraceDebugManager", "exception:%s", new Object[]{bi.i(e)});
            x.e("MicroMsg.TraceDebugManager", "zip file failed msg:%s ", new Object[]{e.getMessage()});
            return null;
        }
    }

    private d() {
    }

    public final void dh(String str, int i) {
        if (this.tfG != null && this.tfG.size() > 0) {
            x.i("MicroMsg.TraceDebugManager", "TRACE gatherData : isUploading : %b  hasStart :%b currentClass : %s currentCode %d ", new Object[]{Boolean.valueOf(this.egv), Boolean.valueOf(this.tfE), str, Integer.valueOf(i)});
            if (!this.egv && !this.tfE) {
                Iterator it = this.tfG.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.className == null) {
                        a(null);
                        this.tfG.remove(aVar);
                        return;
                    } else if (aVar.className.equals(str) && aVar.ccC == i) {
                        a(aVar);
                        this.tfG.remove(aVar);
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: ZP */
    final void a(String str) {
        if (str != null) {
            this.egv = true;
            if (bi.oW(str)) {
                x.e("MicroMsg.TraceDebugManager", "TRACE error uploadPath %s ", new Object[]{str});
            } else if (c.zZ()) {
                File file = new File(str);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        str = S(file);
                    }
                    if (str != null && new File(str).length() >= 131072) {
                        if (tfx == null) {
                            x.e("MicroMsg.TraceDebugManager", "TRACE upload : no file upload impl set!");
                        } else {
                            x.i("MicroMsg.TraceDebugManager", "TRACE upload : %b", new Object[]{Boolean.valueOf(tfx.Jz(str))});
                            if (tfx.Jz(str)) {
                                e.k(new File(tfF));
                            }
                        }
                    }
                } else {
                    x.e("MicroMsg.TraceDebugManager", "TRACE upload file is not exist");
                }
            } else {
                x.e("MicroMsg.TraceDebugManager", "TRACE sdcard invalid.");
            }
            this.egv = false;
        }
    }

    public final void c(a aVar) {
        if (aVar.ccC > 0) {
            if (this.tfH == null) {
                this.tfH = Executors.newSingleThreadExecutor();
            }
            if (this.egv || this.tfE) {
                x.i("MicroMsg.TraceDebugManager", "TRACE isUloading or hasStartTrace %b %b", new Object[]{Boolean.valueOf(this.egv), Boolean.valueOf(this.tfE)});
                return;
            }
            dvh.removeMessages(0);
            if (aVar.tfM == 4 || aVar.tfM == 5) {
                final int i = aVar.tfM;
                this.tfH.execute(new Runnable() {
                    public final void run() {
                        d.this.a(i == 4 ? "/data/anr/" : d.tfF);
                    }
                });
            } else if (aVar.ccC == 6 || aVar.ccC == 5) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.obj = aVar;
                if (aVar.ccC == 5) {
                    dvh.sendMessage(obtain);
                } else {
                    dvh.sendMessageDelayed(obtain, 500);
                }
            } else {
                if (this.tfG == null) {
                    this.tfG = new LinkedBlockingQueue();
                }
                this.tfG.clear();
                this.tfG.add(aVar);
            }
            x.i("MicroMsg.TraceDebugManager", "TRACE PUSH : class : %s  code :%s type :%s", new Object[]{aVar.className, Integer.valueOf(aVar.ccC), Integer.valueOf(aVar.tfM)});
        }
    }
}
