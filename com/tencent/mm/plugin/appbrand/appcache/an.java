package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.ab.d;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.debugger.b;
import com.tencent.mm.plugin.appbrand.debugger.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class an implements a {
    public static final Map<String, c> fhL;

    static /* synthetic */ void qQ(String str) {
        if (e.abi() == null) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            return;
        }
        Map z = bl.z(str, "sysmsg");
        if (z == null || z.size() <= 0) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            return;
        }
        String str2 = (String) z.get(".sysmsg.$type");
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", new Object[]{str2});
        if (!bi.oW(str2)) {
            c cVar = (c) fhL.get(str2);
            if (cVar != null) {
                cVar.u(z);
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b((byte) 0));
        hashMap.put("AppPublicLibraryNotify", new d((byte) 0));
        hashMap.put("mmbizwxaconfig", new a((byte) 0));
        hashMap.put("ForceOpenAppNotify", new c());
        hashMap.put("AppBrandForceKill", new b());
        fhL = Collections.unmodifiableMap(hashMap);
    }

    public final void a(d.a aVar) {
        String a = ab.a(aVar.dIN.rcl);
        if (bi.oW(a)) {
            x.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
        } else {
            com.tencent.mm.plugin.appbrand.r.c.Em().H(new 1(this, a));
        }
    }
}
