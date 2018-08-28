package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.os.Looper;
import android.support.v4.e.h;
import com.tencent.mm.plugin.appbrand.appcache.l;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class d implements ILaunchWxaAppInfoNotify {
    private static final android.support.v4.e.a<String, d> gfs = new android.support.v4.e.a();
    static final h<AppBrandSysConfig, AppBrandLaunchErrorAction> gfz = h.e(null, null);
    final String appId;
    final int cbB;
    final int fmv;
    final AppBrandLaunchReferrer fqA;
    final String fqx;
    final boolean geV;
    final boolean gft;
    volatile b gfu;
    volatile h<AppBrandSysConfig, AppBrandLaunchErrorAction> gfv;
    final int gfw;
    final String gfx;
    final int gfy;
    volatile boolean started;

    private static final class a extends al {
        public a(String str) {
            super(Looper.getMainLooper(), new 1(str), false);
        }
    }

    static /* synthetic */ void a(d dVar, h hVar) {
        x.v("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] onPrepareDone %s %d in mm process", new Object[]{dVar.appId, Integer.valueOf(dVar.fmv)});
        dVar.a(hVar);
        LaunchBroadCast.a(dVar.appId, dVar.fmv, dVar.gfw, ((AppBrandSysConfig) hVar.first) != null);
    }

    static /* synthetic */ void b(d dVar) {
        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "postDownload, appId %s, versionType %d", new Object[]{dVar.appId, Integer.valueOf(dVar.fmv)});
        if (dVar.gfu != null) {
            b bVar = dVar.gfu;
        }
    }

    static d uk(String str) {
        d dVar;
        synchronized (gfs) {
            dVar = (d) gfs.remove(str);
        }
        return dVar;
    }

    static d ul(String str) {
        d dVar;
        synchronized (gfs) {
            dVar = (d) gfs.get(str);
        }
        return dVar;
    }

    public d(AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        this(appBrandInitConfig.appId, appBrandInitConfig.fig, appBrandStatObject.cbB, appBrandStatObject.scene, appBrandInitConfig.fqx, appBrandInitConfig.fqA, appBrandInitConfig.fdE, -1, true, appBrandInitConfig.aaq());
        if (appBrandInitConfig.aaq()) {
            l.qE(appBrandInitConfig.appId);
        }
    }

    public d(String str, int i, int i2, int i3, String str2, AppBrandLaunchReferrer appBrandLaunchReferrer, String str3, int i4, boolean z, boolean z2) {
        this.appId = str;
        this.fmv = i;
        this.cbB = i2;
        this.gfw = i3;
        this.fqx = str2;
        this.fqA = appBrandLaunchReferrer;
        this.gfx = str3;
        this.gfy = i4;
        this.geV = z2;
        this.gft = z;
    }

    final void a(h<AppBrandSysConfig, AppBrandLaunchErrorAction> hVar) {
        this.gfv = hVar;
        if (this.gfu != null) {
            this.gfu.a((AppBrandSysConfig) hVar.first, (AppBrandLaunchErrorAction) hVar.second);
            uk(this.gfx);
        }
    }

    public final void a(String str, int i, String str2, t tVar) {
        if (this.gfv != null) {
            com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a aVar = AppBrandLaunchErrorAction.CREATOR;
            AppBrandLaunchErrorAction a = com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a.a(this.appId, this.fmv, tVar);
            if (a != null) {
                this.gfv = h.e(null, a);
                return;
            }
            AppBrandSysConfig appBrandSysConfig = (AppBrandSysConfig) this.gfv.first;
            if (appBrandSysConfig == null) {
                x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "notifyLaunchInfoUpdate null config with appId(%s)", new Object[]{str});
                return;
            }
            tVar.c(appBrandSysConfig);
            this.gfv = h.e(appBrandSysConfig, null);
        }
    }

    public final void akB() {
        if (!this.started) {
            this.started = true;
            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "[applaunch] startPrepare in mm %s %d", new Object[]{this.appId, Integer.valueOf(this.fmv)});
            if (this.gft) {
                synchronized (gfs) {
                    gfs.put(this.gfx, this);
                }
                a aVar = new a(this.gfx);
                long toMillis = TimeUnit.SECONDS.toMillis(300);
                aVar.J(toMillis, toMillis);
            }
            HandlerThread Xs = e.Xs(String.format(Locale.US, "AppLaunchPrepareProcess[%s %d]", new Object[]{this.appId, Integer.valueOf(this.fmv)}));
            Xs.start();
            new ag(Xs.getLooper()).post(new 1(this, Xs));
        }
    }
}
