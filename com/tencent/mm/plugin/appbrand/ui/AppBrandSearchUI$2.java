package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.52;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class AppBrandSearchUI$2 implements Runnable {
    final /* synthetic */ AppBrandSearchUI gvD;
    final /* synthetic */ String gvE;
    final /* synthetic */ int gvF;
    final /* synthetic */ int gvG;

    AppBrandSearchUI$2(AppBrandSearchUI appBrandSearchUI, String str, int i, int i2) {
        this.gvD = appBrandSearchUI;
        this.gvE = str;
        this.gvF = i;
        this.gvG = i2;
    }

    public final void run() {
        if (AppBrandSearchUI.b(this.gvD) != null) {
            d c = AppBrandSearchUI.c(this.gvD);
            String str = this.gvE;
            int i = this.gvF;
            int i2 = this.gvG;
            if (c.qhq) {
                x.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
                Map hashMap = new HashMap();
                hashMap.put("json", str);
                hashMap.put("isCacheData", Integer.valueOf(i));
                hashMap.put("isExpired", Integer.valueOf(i2));
                ah.A(new 52(c, a.a("onSearchGuideDataReady", hashMap, c.qhs, c.qht)));
                return;
            }
            x.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
        }
    }
}
