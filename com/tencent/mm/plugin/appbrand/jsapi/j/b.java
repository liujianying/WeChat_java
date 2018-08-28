package com.tencent.mm.plugin.appbrand.jsapi.j;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 280;
    private static final String NAME = "getRegionData";
    private static final AtomicReference<String> fXg = new AtomicReference();

    public final void a(p pVar, JSONObject jSONObject, final int i) {
        final WeakReference weakReference = new WeakReference(pVar);
        e.post(new Runnable() {
            public final void run() {
                Object ct;
                String ct2 = null;
                String str = (String) b.fXg.get();
                if (bi.oW(str)) {
                    String str2;
                    if (ad.cig()) {
                        try {
                            str2 = ((IPCString) XIPCInvoker.a("com.tencent.mm", IPCVoid.dnk, a.class)).value;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e, "query updated address path", new Object[0]);
                            str2 = ct2;
                        }
                    } else {
                        str2 = "";
                    }
                    if (bi.oW(str2)) {
                        ct2 = str;
                    } else {
                        try {
                            ct2 = com.tencent.mm.a.e.ct(str2);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e2, "read address from file %s", new Object[]{str2});
                        }
                    }
                    if (bi.oW(ct2)) {
                        try {
                            ct2 = bi.convertStreamToString(ad.getContext().getAssets().open("address"));
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.AppBrand.JsApiGetRegionData", e22, "read address from assets", new Object[0]);
                        }
                    }
                    if (!bi.oW(ct2)) {
                        b.fXg.set(ct2);
                    }
                } else {
                    ct2 = str;
                }
                p pVar = (p) weakReference.get();
                if (pVar != null && pVar.isRunning()) {
                    Map hashMap = new HashMap(1);
                    hashMap.put("data", ct2);
                    pVar.E(i, b.this.f("ok", hashMap));
                }
            }
        }, "AppBrandJsApiGetRegionData");
    }
}
