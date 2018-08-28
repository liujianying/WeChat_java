package com.tencent.mm.plugin.appbrand.launching;

import android.os.HandlerThread;
import android.support.v4.e.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchErrorAction.a;
import com.tencent.mm.plugin.appbrand.launching.d.2;
import com.tencent.mm.plugin.appbrand.launching.d.3;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class d$1 implements Runnable {
    final /* synthetic */ HandlerThread gfA;
    final /* synthetic */ d gfB;

    d$1(d dVar, HandlerThread handlerThread) {
        this.gfB = dVar;
        this.gfA = handlerThread;
    }

    public final void run() {
        try {
            h hVar;
            d dVar = this.gfB;
            d dVar2 = this.gfB;
            AppBrandSysConfig rU = q.rU(dVar2.appId);
            if (rU == null) {
                x.um(c.getMMString(j.app_brand_preparing_attr_sync_timeout, new Object[]{""}));
            }
            if (rU == null) {
                x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "get null config!!!");
                hVar = d.gfz;
            } else {
                Object obj;
                ((d) e.x(d.class)).u(q.rY(dVar2.appId), bi.VE());
                com.tencent.mm.plugin.appbrand.q.h hVar2 = new com.tencent.mm.plugin.appbrand.q.h();
                String str = rU.appId;
                String str2 = rU.bGy;
                2 2 = new 2(dVar2, rU.appId, dVar2.fmv, dVar2.fqx, dVar2.gfw, e.aba().f(str, new String[]{"versionInfo"}).ael());
                Future futureTask = new FutureTask(2);
                com.tencent.mm.sdk.f.e.post(futureTask, 2.getTag());
                t akL = new aa(str, dVar2.fmv, dVar2.cbB, dVar2.gfw, dVar2.fqx, dVar2.fqA, dVar2.gfx, dVar2.gfy).akL();
                if (akL == null) {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null launchInfo", new Object[]{rU.bGy});
                    obj = null;
                } else {
                    a aVar = AppBrandLaunchErrorAction.CREATOR;
                    AppBrandLaunchErrorAction a = a.a(str, dVar2.fmv, akL);
                    if (a != null) {
                        hVar2.value = a;
                        x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, launch ban code %d", new Object[]{rU.bGy, Integer.valueOf(akL.field_launchAction.qZk)});
                        obj = null;
                    } else if (akL.field_jsapiInfo == null || akL.field_jsapiInfo.rsl == null) {
                        x.e("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, get null jsapi_info", new Object[]{rU.bGy});
                        obj = null;
                    } else {
                        akL.c(rU);
                        if (akL.field_launchAction.rSL) {
                            g.l(com.tencent.mm.plugin.appbrand.widget.recentview.d.class);
                            rU.fqN = !g.Ei().DT().getBoolean(aa.a.sTU, false);
                            g.Ei().DT().a(aa.a.sTU, Boolean.valueOf(true));
                        } else {
                            rU.fqN = false;
                        }
                        WxaPkgWrappingInfo wxaPkgWrappingInfo = (WxaPkgWrappingInfo) futureTask.get();
                        if (wxaPkgWrappingInfo == null) {
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig null app pkg, username %s appId %s", new Object[]{rU.bGy, rU.appId});
                            obj = null;
                        } else {
                            rU.frm.a(wxaPkgWrappingInfo);
                            if (rU.frm.fih != 0) {
                                rU.frm.fii = 0;
                            }
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig username %s, appId %s, app pkg %s", new Object[]{rU.bGy, rU.appId, rU.frm});
                            rU.frn = AppBrandGlobalSystemConfig.adZ();
                            com.tencent.mm.sdk.f.e.post(new 3(dVar2, str2), "AppLaunchPrepareProcess#ExtraWorks");
                            x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig ok username %s, appId %s", new Object[]{rU.bGy, rU.appId});
                            obj = 1;
                        }
                    }
                }
                if (obj == null) {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "fillConfig, false, username %s, appId %s", new Object[]{rU.bGy, rU.appId});
                    hVar = h.e(null, hVar2.value);
                } else {
                    x.i("MicroMsg.AppBrand.AppLaunchPrepareProcess", "prepare ok, just go weapp, username %s, appId %s", new Object[]{rU.bGy, rU.appId});
                    hVar = h.e(rU, null);
                }
            }
            d.a(dVar, hVar);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrand.AppLaunchPrepareProcess", e, "call() exp ", new Object[0]);
            x.lc(j.app_brand_launching_failed);
            d.a(this.gfB, d.akD());
        }
        this.gfA.quit();
    }
}
