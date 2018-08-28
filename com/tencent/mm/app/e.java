package com.tencent.mm.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.mm.ab.q;
import com.tencent.mm.booter.CoreService;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b.4;
import com.tencent.mm.kernel.b.5;
import com.tencent.mm.kernel.b.6;
import com.tencent.mm.kernel.b.7;
import com.tencent.mm.kernel.b.8;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.f;
import com.tencent.mm.network.i;
import com.tencent.mm.protocal.n;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.concurrent.locks.ReentrantLock;
import junit.framework.Assert;

public final class e implements ServiceConnection {
    private static boolean bye = false;
    private static Object lock = new Object();
    private ReentrantLock byf = new ReentrantLock();
    private boolean byg = false;
    private IBinder byh = null;
    private Runnable byi = new 5(this);

    static /* synthetic */ void a(e eVar) {
        try {
            eVar.byf.lock();
            eVar.byg = false;
            eVar.byh = null;
            g.Eg();
            if (!a.Dw() || a.Dr()) {
                g.Ek();
                g.Eh().dpP.Lj();
                g.Ek();
                g.Eh().dpP.reset();
                return;
            }
            g.Ek();
            g.Eh().dpP.Li();
            eVar.aU(ad.getContext());
        } finally {
            eVar.byf.unlock();
        }
    }

    static /* synthetic */ void a(e eVar, IBinder iBinder) {
        com.tencent.mm.blink.a.ey("onServiceConnected");
        synchronized (lock) {
            x.i("MicroMsg.CoreServiceConnection", "remove zombie killer.");
            ah.M(eVar.byi);
            bye = false;
        }
        if (iBinder == null) {
            Assert.assertTrue("WorkerProfile onServiceConnected binder == null", false);
            b.A("WorkerProfile onServiceConnected binder == null", "it will result in accInfo being null");
        }
        try {
            eVar.byf.lock();
            eVar.byg = false;
            eVar.byh = iBinder;
            q qVar = new q(f.a.B(iBinder));
            try {
                qVar.dJJ.a(new 2(eVar));
            } catch (Throwable e) {
                x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e)});
            }
            try {
                qVar.dJJ.a(new 3(eVar));
            } catch (Throwable e2) {
                x.e("MicroMsg.RDispatcher", "exception:%s", new Object[]{bi.i(e2)});
            }
            g.Ek();
            com.tencent.mm.kernel.b Eh = g.Eh();
            x.w("MMKernel.CoreNetwork", "setting up remote dispatcher " + qVar);
            Eh.dpO.b(qVar);
            qVar.a(new 4(Eh));
            try {
                i Ls = qVar.Ls();
                if (Ls != null) {
                    Ls.c(Eh.dpR);
                }
            } catch (Throwable e22) {
                x.e("MMKernel.CoreNetwork", "exception:%s", new Object[]{bi.i(e22)});
            }
            qVar.a(new 5(Eh));
            c Lr = qVar.Lr();
            if (Lr == null) {
                x.f("MMKernel.CoreNetwork", "accInfo is null, it would assert before!!!");
                Eh.dpP.reset();
                Eh.dpP.Lj();
            } else {
                String str;
                b.a(new 6(Eh));
                g.Ek();
                w wVar = g.Ei().dqk;
                Assert.assertTrue("setAutoAuth, getSysCfg() is null, stack = " + bi.cjd(), wVar != null);
                int Di = wVar.Di(47);
                String str2 = (String) wVar.get(2);
                String str3 = (String) wVar.get(3);
                String str4 = (String) wVar.get(25);
                String str5 = (String) wVar.get(24);
                n.a fJ = n.fJ((String) wVar.get(6), (String) wVar.get(7));
                x.d("MMKernel.CoreNetwork", "dkidc host[s:%s l:%s] builtin[s:%s l:%s] ports[%s] timeout[%s] mmtls[%d]", new Object[]{str5, str4, str2, str3, str, r6, Integer.valueOf(Di)});
                Assert.assertTrue("setAutoAuth, autoAuth is null, stack = " + bi.cjd(), true);
                qVar.a(false, str2, str3, fJ.qWI, fJ.qWJ, fJ.qWK, fJ.qWL, str5, str4);
                qVar.bF((Di & 1) == 0);
                g.Ek();
                g.Eg();
                Assert.assertTrue("setAutoAuth, accInfo is null, stack = " + bi.cjd(), Lr != null);
                if (g.Eg().Dx() && g.Eg().dpD) {
                    Eh.dpP.d(qVar);
                    com.tencent.mm.network.b.a(new 8(Eh));
                    x.i("MMKernel.CoreNetwork", "setAutoAuth differrent accStg uin[%d], accInfo uin[%d], acc init[%b]", new Object[]{Integer.valueOf(a.Df()), Integer.valueOf(Lr.Df()), Boolean.valueOf(g.Eg().Dx())});
                    if (a.Df() != Lr.Df()) {
                        x.w("MMKernel.CoreNetwork", "update acc info with acc stg: uin =" + Lr.Df());
                        str = "setAutoAuth, getConfigStg() is null, stack = " + bi.cjd();
                        g.Ek();
                        Assert.assertTrue(str, g.Ei().DT() != null);
                        g.Ek();
                        String str6 = (String) g.Ei().DT().get(2, null);
                        Lr.x(new byte[0], a.Df());
                        Lr.setUsername(str6);
                    }
                } else {
                    x.w("MMKernel.CoreNetwork", "need to clear acc info and maybe stop networking accHasReady():%b isInitializedNotifyAllDone:%b", new Object[]{Boolean.valueOf(g.Eg().Dx()), Boolean.valueOf(g.Eg().dpD)});
                    com.tencent.mm.plugin.report.f.mDy.a(148, g.Eg().Dx() ? 44 : 43, 1, false);
                    Lr.reset();
                    qVar.reset();
                    Eh.dpP.d(qVar);
                    com.tencent.mm.network.b.a(new 7(Eh));
                    if (a.Df() != Lr.Df()) {
                        com.tencent.mm.plugin.report.f.mDy.a(148, 45, 1, false);
                        x.w("MMKernel.CoreNetwork", "summerauth update acc info with acc stg: old acc uin=%d, acc stg uin=%d, acc init %b %b", new Object[]{Integer.valueOf(Lr.Df()), Integer.valueOf(a.Df()), Boolean.valueOf(g.Eg().Dx()), Boolean.valueOf(g.Eg().dpD)});
                        Lr.eK(a.Df());
                    } else {
                        x.i("MMKernel.CoreNetwork", "acc info uin same with acc stg", new Object[]{Integer.valueOf(Lr.Df()), Integer.valueOf(a.Df())});
                    }
                }
            }
            if (com.tencent.mm.model.a.FJ()) {
                try {
                    g.Ek();
                    if (g.Eg().dps != null) {
                        g.Ek();
                        if (g.Eh().dpP.dJs != null) {
                            g.Ek();
                            com.tencent.mm.model.a aVar = g.Eg().dps;
                            g.Ek();
                            c Lr2 = g.Eh().dpP.dJs.Lr();
                            long VF = bi.VF();
                            if (Lr2 == null) {
                                x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  accinfo == null");
                                com.tencent.mm.plugin.report.f.mDy.a(226, 6, 1, false);
                            } else {
                                x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush islogin:%b cache:%s", new Object[]{Boolean.valueOf(Lr2.Ln()), Integer.valueOf(aVar.FI())});
                                if (Lr2.Ln()) {
                                    if (aVar.FI() > 0) {
                                        com.tencent.mm.plugin.report.f.mDy.a(226, 7, 1, false);
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush  something Error! islogin && isCacheValid . Clean Cache Now !");
                                        aVar.dzX = null;
                                    } else {
                                        x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush Here, DANGER! . HERE means worker just init , try set from push now!");
                                        com.tencent.mm.plugin.report.f.mDy.a(226, 8, 1, false);
                                    }
                                    aVar.dzX = Lr2.Lq();
                                    com.tencent.mm.plugin.report.f.mDy.a(226, aVar.FI() > 0 ? 9 : 10, 1, false);
                                } else if (aVar.FI() <= 0) {
                                    com.tencent.mm.plugin.report.f.mDy.a(226, 11, 1, false);
                                    x.w("MicroMsg.AccInfoCacheInWorker", "reuseToPush something is null. give up %s", new Object[]{aVar.toString()});
                                } else {
                                    int I = Lr2.I(aVar.dzX);
                                    x.i("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s time:%s  cache:%s", new Object[]{Integer.valueOf(I), Long.valueOf(bi.bH(VF)), Integer.valueOf(aVar.FI())});
                                    if (I != 0) {
                                        x.e("MicroMsg.AccInfoCacheInWorker", "reuseToPush parseBuf ret:%s", new Object[]{Integer.valueOf(I)});
                                        aVar.dzX = null;
                                    } else {
                                        aVar.dzY = 0;
                                    }
                                    com.tencent.mm.plugin.report.f.mDy.a(226, (long) (I + 20), 1, false);
                                }
                            }
                        }
                    }
                    r4 = new Object[2];
                    g.Ek();
                    r4[0] = g.Eg().dps;
                    g.Ek();
                    r4[1] = g.Eh().dpP.dJs;
                    x.i("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush but object is null [%s, %s]", r4);
                } catch (Throwable th) {
                    x.e("MicroMsg.AccInfoCacheInWorker", "tryReuseToPush Exception:%s", new Object[]{bi.i(th)});
                }
            }
            if (g.Eg().Dx()) {
                g.Ek();
                if (g.Eh().dpP != null) {
                    g.Ek();
                    if (g.Eh().dpP.dJs != null) {
                        g.Ek();
                        g.Eh().dpP.dJs.bD(true);
                    }
                }
            }
            com.tencent.mm.blink.a.ey("onServiceConnected done");
        } finally {
            eVar.byf.unlock();
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceConnected ");
        com.tencent.mm.blink.b.xi().g(new 1(this, componentName, iBinder));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        x.w("MicroMsg.CoreServiceConnection", "onServiceDisconnected ");
        com.tencent.mm.blink.b.xi().g(new 4(this, componentName));
    }

    public final void aU(Context context) {
        boolean z = false;
        com.tencent.mm.blink.a.ey("bindCore");
        try {
            this.byf.lock();
            if (this.byh != null && this.byh.isBinderAlive()) {
                z = true;
            }
            x.i("MicroMsg.CoreServiceConnection", "enter bindCore, isBinding: %b, binderAlive: %b", new Object[]{Boolean.valueOf(this.byg), Boolean.valueOf(z)});
            if (this.byg || z) {
                x.w("MicroMsg.CoreServiceConnection", "bindCore reenter, isBinding: %b, binderAlive: %b, return directly.", new Object[]{Boolean.valueOf(this.byg), Boolean.valueOf(z)});
                return;
            }
            this.byf.unlock();
            if (com.tencent.mm.booter.b.v(context, "noop")) {
                Intent intent = new Intent(context, CoreService.class);
                x.i("MicroMsg.CoreServiceConnection", "prepare dispatcher / bind core service");
                if (context.bindService(intent, this, 1)) {
                    try {
                        this.byf.lock();
                        this.byg = true;
                        synchronized (lock) {
                            if (!bye) {
                                bye = true;
                                x.i("MicroMsg.CoreServiceConnection", "ZombieWaker posted.");
                                ah.i(this.byi, 10000);
                            }
                        }
                        return;
                    } finally {
                        this.byf.unlock();
                    }
                } else {
                    x.e("MicroMsg.CoreServiceConnection", "bindService failed, may be caused by some crashes");
                    return;
                }
            }
            x.i("MicroMsg.CoreServiceConnection", "ensureServiceInstance return false");
        } finally {
            this.byf.unlock();
        }
    }

    private static int cL(String str) {
        Throwable th;
        Throwable th2;
        int i = -1;
        BufferedReader bufferedReader = null;
        for (File file : new File("/proc").listFiles()) {
            try {
                i = bi.getInt(file.getName(), -1);
                try {
                    File file2 = new File(file, "cmdline");
                    if (file2.canRead()) {
                        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null && readLine.startsWith(str)) {
                                if (readLine.length() == str.length()) {
                                    x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", new Object[]{str, Integer.valueOf(i)});
                                    try {
                                        bufferedReader2.close();
                                        break;
                                    } catch (Throwable th3) {
                                    }
                                } else {
                                    char charAt = readLine.charAt(str.length());
                                    if (charAt <= ' ' || charAt >= 127) {
                                        x.i("MicroMsg.CoreServiceConnection", "found process [%s] with pid [%d]", new Object[]{str, Integer.valueOf(i)});
                                        try {
                                            bufferedReader2.close();
                                            break;
                                        } catch (Throwable th4) {
                                        }
                                    }
                                }
                            }
                            try {
                                bufferedReader2.close();
                            } catch (Throwable th5) {
                            }
                            bufferedReader = null;
                        } catch (Throwable th6) {
                            th2 = th6;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Throwable th7) {
                                }
                            }
                            throw th2;
                        }
                    } else if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th8) {
                        }
                        bufferedReader = null;
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            } catch (Throwable th10) {
                x.printErrStackTrace("MicroMsg.CoreServiceConnection", th10, "", new Object[0]);
            }
        }
        return i;
    }
}
