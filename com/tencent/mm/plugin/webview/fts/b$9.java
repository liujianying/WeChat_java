package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.x;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.43;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;
import java.util.Map;

class b$9 extends x {
    final /* synthetic */ b pOa;

    b$9(b bVar) {
        this.pOa = bVar;
    }

    public final void Z(String str, String str2) {
        com.tencent.mm.sdk.platformtools.x.v("FTSSearchWidgetMgr", "on widget data push, widgetId[%s], respData[%s]", new Object[]{str, str2});
        String a = b.a(this.pOa, str);
        if (bi.oW(a)) {
            com.tencent.mm.sdk.platformtools.x.e("FTSSearchWidgetMgr", "onWidgetDataPush widget cache key not found!");
            return;
        }
        d a2 = b.a(this.pOa);
        if (a2.qhq) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", a);
            hashMap.put("data", str2);
            ah.A(new 43(a2, a.a("onSearchWAWidgetDataPush", hashMap, a2.qhs, a2.qht)));
            return;
        }
        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
    }
}
