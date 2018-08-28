package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.b;
import com.tencent.mm.plugin.appbrand.ui.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, g> fbM = new HashMap();
    private static Map<String, android.support.v4.app.a.a> fbN = new HashMap();
    private static Map<String, h> fbO = new HashMap();

    public static void a(g gVar) {
        if (bi.oW(gVar.mAppId)) {
            x.e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
            return;
        }
        synchronized (fbM) {
            g gVar2 = (g) fbM.get(gVar.mAppId);
            if (gVar2 == null || gVar2 == gVar) {
                fbM.put(gVar.mAppId, null);
            } else {
                x.e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", new Object[]{bi.i(new Throwable())});
            }
        }
    }

    public static void b(g gVar) {
        if (bi.oW(gVar.mAppId)) {
            x.e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
            return;
        }
        synchronized (fbM) {
            fbM.put(gVar.mAppId, gVar);
        }
        if (gVar.fct != null) {
            b.aL(gVar.mAppId, gVar.fct.bGM);
        }
    }

    public static g pY(String str) {
        if (bi.oW(str)) {
            return null;
        }
        g gVar;
        synchronized (fbM) {
            gVar = (g) fbM.get(str);
        }
        return gVar;
    }

    public static void a(String str, android.support.v4.app.a.a aVar) {
        fbN.put(str, aVar);
    }

    public static void a(String str, int i, String[] strArr, int[] iArr) {
        if (fbN.containsKey(str)) {
            ((android.support.v4.app.a.a) fbN.remove(str)).onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public static void pZ(String str) {
        fbN.remove(str);
    }

    public static AppBrandSysConfig qa(String str) {
        g pY = pY(str);
        return pY == null ? null : pY.fcu;
    }

    public static AppBrandStatObject qb(String str) {
        g pY = pY(str);
        return pY == null ? null : pY.fcE;
    }

    public static void a(String str, h hVar) {
        fbO.put(str, hVar);
    }

    public static h qc(String str) {
        return (h) fbO.get(str);
    }

    public static void qd(String str) {
        fbO.remove(str);
    }
}
