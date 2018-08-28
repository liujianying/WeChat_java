package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.g.a.n;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$20 extends c<n> {
    final /* synthetic */ e ffn;

    e$20(e eVar) {
        this.ffn = eVar;
        this.sFo = n.class.getName().hashCode();
    }

    private static boolean a(n nVar) {
        String str = nVar.bGE.bGy;
        String str2 = nVar.bGE.appId;
        int i = nVar.bGE.bGF;
        int i2 = nVar.bGE.scene;
        String str3 = nVar.bGE.bGG;
        String str4 = nVar.bGE.bGH;
        int i3 = nVar.bGE.action;
        String str5 = nVar.bGE.bGI;
        long j = nVar.bGE.bGJ;
        int i4 = nVar.bGE.bGK;
        int i5 = nVar.bGE.bGL;
        int i6 = 3;
        if (!bi.oW(str)) {
            String str6 = "";
            if (!bi.oW(str4) && str4.contains(".html")) {
                str6 = str4.substring(0, str4.lastIndexOf(".html") + 5);
            }
            str4 = "";
            try {
                str4 = p.encode(bi.oV(str6), "UTF-8");
            } catch (Throwable e) {
                x.e("MicroMsg.AppBrandReporterManager", "encode page path error!");
                x.printErrStackTrace("MicroMsg.AppBrandReporterManager", e, "", new Object[0]);
            }
            String oV = bi.oV(str3);
            str3 = bi.oV(str5);
            str5 = bi.oV(str2);
            int vn = a.vn(str2);
            if (i > 0) {
                i6 = i - 1;
                i6 = e.abh().aq(str, i6) ? 1 : e.abg().ar(str, i6) ? 2 : 3;
            }
            x.d("MicroMsg.AppBrandReporterManager", "stev report(%s), scene : %d, sceneNote %s, appid %s, appversion %d, appState %d, usedState %d, pagePath %s, action %d, actionNote %s,actionTime %s, actionResult %d, actionErrorcode %d, appType %d", new Object[]{Integer.valueOf(13540), Integer.valueOf(i2), oV, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str6, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(vn)});
            h.mEJ.h(13540, new Object[]{Integer.valueOf(i2), oV, str5, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i6), str4, Integer.valueOf(i3), str3, Long.valueOf(j), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(vn)});
        }
        return true;
    }
}
