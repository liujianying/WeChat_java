package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.SparseArray;
import android.view.Choreographer.FrameCallback;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageInfoTask;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"DefaultLocale"})
public final class AppBrandPerformanceManager {
    private static SparseArray<a> gpr = new SparseArray();

    private static class a implements Runnable {
        private c fBP;
        volatile boolean fcO = false;
        private volatile boolean gaH = false;
        private volatile double gpt = 0.0d;
        private volatile int gpu = 4;
        volatile boolean gpv = false;
        d gpw;
        com.tencent.mm.plugin.appbrand.performance.d.a gpx = new com.tencent.mm.plugin.appbrand.performance.d.a() {
            public final void r(double d) {
                if (Math.round(a.this.gpt) != Math.round(d)) {
                    a.this.gpt = d;
                    AppBrandPerformanceManager.o(a.this.mAppId, 303, Math.round(a.this.gpt) + " fps");
                    a.a(a.this.mAppId, "Hardware", "FPS", a.this.gpt);
                }
            }
        };
        b gpy = new 3(this);
        final String mAppId;
        volatile boolean yr = true;

        public a(String str) {
            this.mAppId = str;
            this.fBP = new c(Process.myPid());
            g pY = com.tencent.mm.plugin.appbrand.a.pY(str);
            if (pY != null && pY.aaq()) {
                this.gaH = true;
            }
            if (amg()) {
                this.gpw = new d();
                this.gpw.mInterval = 100;
                this.gpw.gpx = this.gpx;
            }
        }

        static boolean amg() {
            return VERSION.SDK_INT >= 16;
        }

        public final void run() {
            if (this.yr && !this.fcO) {
                double ami = this.fBP.ami();
                AppBrandPerformanceManager.o(this.mAppId, 101, ((int) ami) + "%");
                a.a(this.mAppId, "Hardware", "CPU", ami);
                int fY = bi.fY(((h) com.tencent.mm.kernel.g.Ef().DM()).dsQ);
                AppBrandPerformanceManager.o(this.mAppId, 102, fY + "m");
                a.a(this.mAppId, "Hardware", "MEMORY", (double) fY);
                if (this.gaH) {
                    synchronized (i.fCa) {
                        if (i.fCa.fCi) {
                            com.tencent.mm.plugin.appbrand.game.c.h agv = i.fCa.agv();
                            if (agv != null) {
                                fY = agv.a(com.tencent.mm.plugin.appbrand.game.c.h.agu());
                            }
                        }
                        fY = Integer.MAX_VALUE;
                    }
                    if (fY != Integer.MAX_VALUE) {
                        AppBrandPerformanceManager.o(this.mAppId, 103, fY + "m");
                    }
                }
                this.gpu++;
                if (this.gpu >= 4) {
                    this.gpu = 0;
                    JsApiGetStorageInfoTask jsApiGetStorageInfoTask = new JsApiGetStorageInfoTask();
                    jsApiGetStorageInfoTask.appId = this.mAppId;
                    jsApiGetStorageInfoTask.fFC = new 1(this, jsApiGetStorageInfoTask);
                    jsApiGetStorageInfoTask.ahA();
                    AppBrandMainProcessService.a(jsApiGetStorageInfoTask);
                }
            }
            if (this.yr) {
                c.Em().h(this, 3000);
            }
        }
    }

    public static final void vf(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "startMonitoring, appId: %s", new Object[]{str});
        a aVar = (a) gpr.get(str.hashCode());
        if (aVar == null) {
            aVar = new a(str);
            gpr.put(str.hashCode(), aVar);
        }
        aVar.yr = true;
        c.Em().H(aVar);
        e.a(aVar.mAppId, aVar.gpy);
        if (a.amg() && aVar.gpw != null) {
            FrameCallback frameCallback = aVar.gpw;
            frameCallback.yr = true;
            frameCallback.btz.postFrameCallback(frameCallback);
        }
        if (!aVar.gpv) {
            GetPkgDownloadCostTask getPkgDownloadCostTask = new GetPkgDownloadCostTask((byte) 0);
            GetPkgDownloadCostTask.a(getPkgDownloadCostTask, aVar.mAppId);
            AppBrandMainProcessService.a(getPkgDownloadCostTask);
            aVar.gpv = true;
        }
    }

    public static final void vg(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "enablePanel for AppId %s", new Object[]{str});
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
        SetAppPerformanceModeTask.a(setAppPerformanceModeTask, str);
        SetAppPerformanceModeTask.a(setAppPerformanceModeTask, true);
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final void vh(String str) {
        x.d("MicroMsg.AppBrandPerformanceManager", "disablePanel for AppId %s", new Object[]{str});
        SetAppPerformanceModeTask setAppPerformanceModeTask = new SetAppPerformanceModeTask((byte) 0);
        SetAppPerformanceModeTask.a(setAppPerformanceModeTask, str);
        SetAppPerformanceModeTask.a(setAppPerformanceModeTask, false);
        AppBrandMainProcessService.a(setAppPerformanceModeTask);
    }

    public static final boolean vi(String str) {
        if (DebuggerShell.aeq()) {
            return true;
        }
        AppBrandSysConfig qa = com.tencent.mm.plugin.appbrand.a.qa(str);
        if (qa != null && qa.fqM && qa.frm.fih == 1) {
            return true;
        }
        return false;
    }

    public static final void b(String str, int i, long j) {
        o(str, i, String.format("%d ms", new Object[]{Long.valueOf(j)}));
    }

    public static final void o(String str, int i, String str2) {
        com.tencent.mm.plugin.appbrand.ui.h qc = com.tencent.mm.plugin.appbrand.a.qc(str);
        if (qc == null) {
            u.Hx().v(str.hashCode() + "performance_data", true).p(String.valueOf(i), str2);
        } else {
            qc.P(i, str2);
        }
    }

    public static final void H(String str, String str2, String str3) {
        com.tencent.mm.plugin.appbrand.ui.h qc = com.tencent.mm.plugin.appbrand.a.qc(str);
        if (qc == null) {
            u.Hx().v(str.hashCode() + "performance_custom_data", true).p(str2, str3);
        } else {
            qc.bN(str2, str3);
        }
    }

    public static final void vj(String str) {
        com.tencent.mm.plugin.appbrand.ui.h qc = com.tencent.mm.plugin.appbrand.a.qc(str);
        u$b ib = u.Hx().ib(str.hashCode() + "performance_data");
        if (qc == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData panel is not ready.");
        } else if (ib == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedPerformanceData cache is empty.");
        } else {
            for (String str2 : ib.Hy()) {
                String str3 = (String) ib.get(str2);
                if (str3 != null) {
                    qc.P(Integer.valueOf(str2).intValue(), str3);
                }
            }
        }
        vk(str);
    }

    private static final void vk(String str) {
        com.tencent.mm.plugin.appbrand.ui.h qc = com.tencent.mm.plugin.appbrand.a.qc(str);
        u$b ib = u.Hx().ib(str.hashCode() + "performance_custom_data");
        if (qc == null) {
            x.e("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData panel is not ready.");
        } else if (ib == null) {
            x.d("MicroMsg.AppBrandPerformanceManager", "insertCachedCustomData cache is empty.");
        } else {
            for (String str2 : ib.Hy()) {
                String str3 = (String) ib.get(str2);
                if (str3 != null) {
                    qc.bN(str2, str3);
                }
            }
        }
    }

    public static final void v(String str, long j) {
        com.tencent.mm.plugin.appbrand.app.e.abf().bd(str + "_PkgDownloadCost", String.valueOf(j));
    }
}
