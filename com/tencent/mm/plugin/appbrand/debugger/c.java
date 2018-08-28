package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Intent;
import com.tencent.mm.g.a.qu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.debugger.DebuggerShell.a;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class c implements com.tencent.mm.plugin.appbrand.appcache.an.c, a {
    public final void u(Map<String, String> map) {
        if (DebuggerShell.aeq()) {
            String str = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
            String str2 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
            int i = bi.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
            int i2 = bi.getInt((String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
            String str3 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
            String str4 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
            String str5 = (String) map.get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
            if (i >= 0) {
                if (i != 0) {
                    if (e.abi() != null && !bi.oW(str4) && !bi.oW(str5)) {
                        if (e.abi().a(str, i, str4, str5, bi.VE(), bi.VE() + 432000)) {
                            com.tencent.mm.plugin.appbrand.task.e.aN(str, i);
                        }
                    } else {
                        return;
                    }
                }
                x.i("MicroMsg.AppBrand.ForceOpenAppNotify", "before start weapp");
                qu quVar = new qu();
                quVar.cbq.appId = str;
                quVar.cbq.userName = str2;
                quVar.cbq.cbt = i;
                quVar.cbq.cbs = str3;
                quVar.cbq.cbu = i2;
                quVar.cbq.cbv = str4;
                quVar.cbq.cbw = str5;
                quVar.cbq.cbx = false;
                quVar.cbq.scene = 1030;
                com.tencent.mm.sdk.b.a.sFg.m(quVar);
            }
        }
    }

    public final String name() {
        return "ForceOpenAppNotify";
    }

    public final void s(Intent intent) {
        String stringExtra = intent.getStringExtra("appId");
        int intExtra = intent.getIntExtra("versionType", 0);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1030;
        ((d) g.l(d.class)).a(null, null, stringExtra, intExtra, 0, null, appBrandStatObject);
    }
}
