package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import com.tencent.magicbrush.a.c$f;
import com.tencent.magicbrush.engine.d;
import com.tencent.magicbrush.handler.MBFontManagerJNI;
import com.tencent.magicbrush.handler.MBImageHandlerJNI;
import com.tencent.magicbrush.handler.MBJavaHandler;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.game.b.a.1;
import com.tencent.mm.plugin.appbrand.game.b.a.2;
import com.tencent.mm.plugin.appbrand.game.b.b.3;
import com.tencent.mm.plugin.appbrand.game.b.b.a;
import com.tencent.mm.plugin.appbrand.game.b.b.c;
import com.tencent.mm.plugin.appbrand.game.b.b.e;
import com.tencent.mm.plugin.appbrand.game.c.f;
import com.tencent.mm.plugin.appbrand.game.c.h;
import com.tencent.mm.plugin.appbrand.game.c.i;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.Map.Entry;

public final class b implements GameGLSurfaceView$n, c {
    volatile boolean dti = false;
    g fdO;
    k fzI;
    boolean fzJ = false;
    private boolean fzK = false;
    private d fzL;
    com.tencent.mm.plugin.appbrand.game.k.b fzM;
    private long fzN = -1;
    private long fzO = System.currentTimeMillis();
    private boolean gnI = false;
    private Context mContext;

    public b(k kVar) {
        this.fzI = kVar;
        this.mContext = this.fzI.getContext();
        this.fdO = this.fzI.getRuntime();
        this.fzL = new d();
        MBJavaHandler.setCallbackProxy(new 1(this));
        MBFontManagerJNI.registerFontManager(new 1(this.fdO), new 2());
        g gVar = this.fdO;
        3 3 = new 3(new b$1(this), new com.tencent.mm.plugin.appbrand.game.b.b.2());
        3.a(new c((byte) 0), false);
        3.a(new com.tencent.mm.plugin.appbrand.game.b.b.b((byte) 0), false);
        3.a(new com.tencent.mm.plugin.appbrand.game.b.b.d(gVar, (byte) 0), true);
        3.boJ = new a();
        com.tencent.magicbrush.a.a.a(new e((byte) 0));
        MBImageHandlerJNI.register(3);
        c$f.a(new d$1());
        com.tencent.magicbrush.a.c.a.a(new d$2());
        if (this.fzI.getRuntime() != null && this.fzI.getRuntime().fcu != null) {
            AppBrandSysConfig appBrandSysConfig = this.fzI.getRuntime().fcu;
            i iVar = i.fCa;
            x.i("MicroMsg.WAGamePerfManager", "init() called with: appId = [%s]", new Object[]{appBrandSysConfig.appId});
            iVar.mAppId = r2;
            if (iVar.fCb != null) {
                iVar.fCb.lnJ.quit();
                iVar.fCb = null;
            }
            if (i.b(appBrandSysConfig.uin, appBrandSysConfig.frn.fpW)) {
                i.fCa.fCh = true;
                iVar = i.fCa;
                x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.enableReport interval = [%d]", new Object[]{Integer.valueOf(appBrandSysConfig.frn.fpX)});
                iVar.fCf = new com.tencent.mm.plugin.appbrand.game.c.e(iVar.mAppId, r0);
            }
        }
    }

    public final void afS() {
        x.i("MicroMsg.GameRenderer", "onSurfaceCreated mInitialized:%s", new Object[]{Boolean.valueOf(this.dti)});
        if (!this.dti) {
            f fVar = j.fAf.fAg;
            if (fVar == null) {
                throw new IllegalStateException("There is no mainJsContext here.");
            }
            this.fzL.a(fVar.fzY, this.mContext, this.fdO.mAppId);
            x.i("MicroMsg.GameRenderer", "hy: created.");
            this.fzN = bi.VG();
            this.dti = true;
        }
        if (this.fzM != null) {
            this.fzM.afZ();
        }
        i iVar = i.fCa;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameStart");
        synchronized (i.fCa) {
            long j;
            iVar.fCi = true;
            if (iVar.fCh) {
                f fVar2 = iVar.fCc;
                fVar2.eVk = new al(iVar.agy().lnJ.getLooper(), new f.a(fVar2, (byte) 0), true);
                j = (long) fVar2.fBR;
                fVar2.eVk.J(j, j);
            }
            iVar.fCe.fBZ = h.b(h.agu());
            if (iVar.fCf != null) {
                com.tencent.mm.plugin.appbrand.game.c.e eVar = iVar.fCf;
                eVar.eOf = new al(iVar.agy().lnJ.getLooper(), new com.tencent.mm.plugin.appbrand.game.c.e.1(eVar), true);
                j = (long) (eVar.fBz * BaseReportManager.MAX_READ_COUNT);
                eVar.eOf.J(j, j);
            }
            iVar.fCj = System.currentTimeMillis();
        }
    }

    public final void bI(int i, int i2) {
        x.i("MicroMsg.GameRenderer", "[alex] WindowSize onSurfaceChanged width = [%d], height = [%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.fzL != null) {
            this.fzL.bnF.Changed(i, i2);
        }
        m.fAw.bJ(i, i2);
        if (this.fdO != null) {
            g gVar = this.fdO;
            k kVar = gVar.fcK;
            x.i("MicroMsg.AppBrandOnWindowSizeChangedEvent", "hy: on resizeWindow");
            kVar.a(gVar.fcy).ahM();
        }
    }

    public final void cC(boolean z) {
        if (this.fzL != null) {
            boolean Render = this.fzL.bnF.Render();
            if (!z) {
                if (Render) {
                    if (!this.fzJ) {
                        x.w("MicroMsg.GameRenderer", "hy: onDrawFrame mFirstFrameRendered. using %d ms", new Object[]{Long.valueOf(bi.bI(this.fzN))});
                        this.fzJ = true;
                        this.fzI.agj();
                    }
                } else if (!this.fzK) {
                    this.fzK = true;
                    if (this.fdO != null) {
                        this.fdO.fcJ.o(9, System.currentTimeMillis() - this.fzO);
                    }
                }
                this.fzI.setSwapNow(Render);
            }
            com.tencent.mm.plugin.appbrand.game.c.g gVar = i.fCa.fCd;
            if (!gVar.fBY) {
                long currentTimeMillis;
                if (gVar.fBV <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.fBV = currentTimeMillis;
                    gVar.fBT = currentTimeMillis;
                    return;
                }
                gVar.fBU++;
                if (gVar.fBU % 20 <= 0) {
                    currentTimeMillis = System.currentTimeMillis();
                    gVar.fBW = 20000.0d / ((double) (currentTimeMillis - gVar.fBT));
                    if (gVar.fBX <= 0.0d) {
                        gVar.fBX = gVar.fBW;
                    } else if (gVar.fBW < gVar.fBX) {
                        gVar.fBX = gVar.fBW;
                    }
                    gVar.fBT = currentTimeMillis;
                }
            }
        }
    }

    public final void onCreateEglSurface() {
        x.i("MicroMsg.GameRenderer", "onCreateEglSurface ");
        if (this.fzL != null) {
            this.fzL.bnF.onCreateEglSurface();
        }
    }

    public final void onResume() {
        x.i("MicroMsg.GameRenderer", "onResume ");
        if (this.fzL != null) {
            this.fzL.bnF.Resume();
        }
    }

    public final void onPause() {
        x.i("MicroMsg.GameRenderer", "onPause ");
        if (this.fzL != null) {
            this.fzL.bnF.Pause();
        }
    }

    public final void afT() {
        x.i("MicroMsg.GameRenderer", "onFinalize ");
        if (this.gnI) {
            x.w("MicroMsg.GameRenderer", "hy: called onFinalize multiple times! ");
            return;
        }
        this.gnI = true;
        if (this.fzL != null) {
            this.fzL.bnF.Finalize();
        }
        i iVar = i.fCa;
        x.i("MicroMsg.WAGamePerfManager", "WAGamePerfManager.gameDestroy");
        synchronized (i.fCa) {
            iVar.fCi = false;
        }
        x.i("MicroMsg.WAGamePerfManager", "release() called");
        if (iVar.fCb != null) {
            iVar.fCb.lnJ.quit();
            iVar.fCb = null;
        }
        if (iVar.fCf != null) {
            com.tencent.mm.plugin.appbrand.game.c.e eVar = iVar.fCf;
            if (eVar.eOf != null) {
                eVar.eOf.SO();
            }
            iVar.fCf = null;
        }
        iVar.fCd.fBY = true;
        if (iVar.fCh) {
            f fVar = iVar.fCc;
            synchronized (fVar) {
                if (fVar.eVk != null) {
                    fVar.eVk.SO();
                }
            }
            iVar.fCh = false;
        }
        iVar.fCe.fBZ = Integer.MAX_VALUE;
        j jVar = j.fAf;
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm start");
        for (Entry entry : jVar.fAi.entrySet()) {
            if (jVar.fAg != entry.getValue()) {
                com.tencent.mm.plugin.appbrand.g.a aVar = (com.tencent.mm.plugin.appbrand.g.a) entry.getValue();
                if (aVar != null) {
                    aVar.destroy();
                }
            }
        }
        jVar.fAi.clear();
        if (jVar.fAg != null) {
            jVar.fAg.destroy();
            jVar.fAg = null;
        }
        x.i("MicroMsg.V8JsVmManager", "GameRenderer.disposeJsVm finished");
    }

    public final void e(Runnable runnable) {
        if (this.fzI != null) {
            this.fzI.queueEvent(runnable);
        }
    }
}
