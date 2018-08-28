package com.tencent.mm.plugin.appbrand.launching;

import android.database.Cursor;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public final class a extends c<qu> {
    public a() {
        this.sFo = qu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qu quVar = (qu) bVar;
        if (bi.oW(quVar.cbq.userName)) {
            quVar.cbr.cbD = false;
            quVar.cbr.cbE = "invalid username or appId";
            return true;
        }
        if (!(bi.oW(quVar.cbq.appId) || bi.oW(quVar.cbq.cbz.dFz))) {
            ((h) e.x(h.class)).n(quVar.cbq.appId, quVar.cbq.cbt, quVar.cbq.cbz.dFz);
        }
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = quVar.cbq.scene;
        appBrandStatObject.bGG = quVar.cbq.bGG;
        appBrandStatObject.cbB = com.tencent.mm.plugin.appbrand.report.c.h(appBrandStatObject.scene, quVar.cbq.bJx);
        appBrandStatObject.cbC = com.tencent.mm.plugin.appbrand.report.c.i(appBrandStatObject.scene, quVar.cbq.bJx);
        if (quVar.cbq.scene == 1037 || quVar.cbq.scene == 1018) {
            appBrandStatObject.cbA = quVar.cbq.cbA;
        } else {
            appBrandStatObject.cbA = quVar.cbq.scene;
        }
        switch (quVar.cbq.cbt) {
            case 0:
            case 2:
                AppBrandLaunchProxyUI.a(quVar.cbq.context, quVar.cbq.userName, quVar.cbq.appId, quVar.cbq.cbs, quVar.cbq.cbt, quVar.cbq.cbu <= 0 ? -1 : quVar.cbq.cbu, appBrandStatObject, null, quVar.cbq.cbz);
                break;
            case 1:
                if (!quVar.cbq.cbx) {
                    if (!bi.oW(quVar.cbq.appId)) {
                        if (!bi.oW(quVar.cbq.cbv) && !bi.oW(quVar.cbq.cbw)) {
                            if (e.abi().a(quVar.cbq.appId, quVar.cbq.cbt, quVar.cbq.cbv, quVar.cbq.cbw, 0, 0)) {
                                com.tencent.mm.plugin.appbrand.task.e.aN(quVar.cbq.appId, quVar.cbq.cbt);
                            } else if (!e.abi().ah(quVar.cbq.appId, quVar.cbq.cbt)) {
                                quVar.cbr.cbD = false;
                                quVar.cbr.cbE = "install app failed";
                                return true;
                            }
                            appBrandStatObject.bGG = quVar.cbq.cbv;
                            AppBrandLaunchProxyUI.a(quVar.cbq.context, quVar.cbq.userName, quVar.cbq.cbs, quVar.cbq.cbt, -1, appBrandStatObject, quVar.cbq.cbz);
                            break;
                        }
                        quVar.cbr.cbD = false;
                        quVar.cbr.cbE = "invalid downloadURL or checkSumMd5";
                        return true;
                    }
                    quVar.cbr.cbD = false;
                    quVar.cbr.cbE = "invalid username or appId";
                    return true;
                }
                com.tencent.mm.g.a.qu.a aVar = quVar.cbq;
                String rW = q.rW(quVar.cbq.userName);
                aVar.appId = rW;
                if (!bi.oW(rW)) {
                    String str;
                    ap abi = e.abi();
                    rW = quVar.cbq.appId;
                    int i = quVar.cbq.cbt;
                    Cursor query = abi.fhY.query("AppBrandWxaPkgManifestRecord", new String[]{"pkgPath"}, String.format(Locale.US, "%s=? and %s=?", new Object[]{"appId", "debugType"}), new String[]{rW, String.valueOf(i)}, null, null, null);
                    if (query == null) {
                        str = null;
                    } else {
                        str = query.moveToFirst() ? query.getString(0) : null;
                        query.close();
                    }
                    if (bi.oW(str) || !com.tencent.mm.a.e.cn(str)) {
                        Object obj;
                        ap abi2 = e.abi();
                        String str2 = quVar.cbq.appId;
                        int i2 = quVar.cbq.cbt;
                        if ((com.tencent.mm.plugin.appbrand.appcache.d.a.ho(i2) ? 1 : abi2.aj(str2, i2)) < 0) {
                            x.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), not records", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.d.a.ho(i2) ? 1 : abi2.aj(str2, i2))});
                        } else {
                            String format = String.format(Locale.US, "where %s like '%s$%%' and %s=%d and %s=%d", new Object[]{"appId", str2, "debugType", Integer.valueOf(i2), "version", Integer.valueOf(com.tencent.mm.plugin.appbrand.appcache.d.a.ho(i2) ? 1 : abi2.aj(str2, i2))});
                            query = abi2.fhY.b(String.format(Locale.US, "select count(*) from %s %s", new Object[]{"AppBrandWxaPkgManifestRecord", format}), null, 2);
                            int i3;
                            if (query == null || query.isClosed()) {
                                x.e("MicroMsg.AppBrandWxaPkgStorage", "hasModuleList, appId(%s), type(%s), version(%d), cursor nil", new Object[]{str2, Integer.valueOf(i2), Integer.valueOf(i3)});
                            } else {
                                i3 = query.moveToFirst() ? query.getInt(0) : 0;
                                query.close();
                                if (i3 > 0) {
                                    obj = 1;
                                    if (obj != null) {
                                        quVar.cbr.cbD = true;
                                        x.i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", new Object[]{quVar.cbq.appId, Integer.valueOf(quVar.cbq.cbt)});
                                        AppBrandLaunchProxyUI.a(quVar.cbq.context, quVar.cbq.userName, quVar.cbq.cbs, quVar.cbq.cbt, 0, appBrandStatObject, quVar.cbq.cbz);
                                        return true;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj != null) {
                            quVar.cbr.cbD = true;
                            x.i("MicroMsg.AppBrandLaunchFromOuterEventListener", "callback with appId(%s) type(%d), hasModuleList=true", new Object[]{quVar.cbq.appId, Integer.valueOf(quVar.cbq.cbt)});
                            AppBrandLaunchProxyUI.a(quVar.cbq.context, quVar.cbq.userName, quVar.cbq.cbs, quVar.cbq.cbt, 0, appBrandStatObject, quVar.cbq.cbz);
                            return true;
                        }
                    }
                    quVar.cbr.cbD = true;
                    AppBrandLaunchProxyUI.a(quVar.cbq.context, quVar.cbq.userName, quVar.cbq.cbs, quVar.cbq.cbt, 0, appBrandStatObject, quVar.cbq.cbz);
                    return true;
                }
                quVar.cbr.cbD = false;
                quVar.cbr.cbE = "local pkg not exists";
                if (quVar.cbq.cby) {
                    rW = null;
                    if (quVar.cbq.cbt == 1) {
                        rW = com.tencent.mm.plugin.appbrand.r.c.getMMString(j.app_brand_debug_app_from_share_card_can_not_open, new Object[0]);
                    } else if (quVar.cbq.cbt == 2) {
                        rW = com.tencent.mm.plugin.appbrand.r.c.getMMString(j.app_brand_not_beta_pkg, new Object[0]);
                    }
                    com.tencent.mm.plugin.appbrand.ipc.a.a(quVar.cbq.context, rW, com.tencent.mm.plugin.appbrand.r.c.getMMString(j.app_tip, new Object[0]), com.tencent.mm.plugin.appbrand.r.c.getMMString(j.app_ok, new Object[0]), "", null, null, null);
                }
                return true;
                break;
            default:
                quVar.cbr.cbD = false;
                quVar.cbr.cbE = "invalid openType";
                return true;
        }
        quVar.cbr.cbD = true;
        return true;
    }
}
