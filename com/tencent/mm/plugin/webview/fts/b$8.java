package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.aa;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.40;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class b$8 extends aa {
    final /* synthetic */ b pOa;

    b$8(b bVar) {
        this.pOa = bVar;
    }

    public final void ju(String str) {
        x.v("FTSSearchWidgetMgr", "on widget reload data, widgetId[%s]", new Object[]{str});
        String a = b.a(this.pOa, str);
        if (bi.oW(a)) {
            x.e("FTSSearchWidgetMgr", "onWidgetReloadData widget cache key not found!");
            return;
        }
        d a2 = b.a(this.pOa);
        if (a2.qhq) {
            x.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
            Map hashMap = new HashMap();
            hashMap.put("widgetId", a);
            ah.A(new 40(a2, a.a("onSearchWAWidgetReloadData", hashMap, a2.qhs, a2.qht)));
            return;
        }
        x.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
    }
}
