package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.y;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.x;

class b$5 extends y {
    final /* synthetic */ b pOa;
    final /* synthetic */ String pOh;

    b$5(b bVar, String str) {
        this.pOa = bVar;
        this.pOh = str;
    }

    public final void b(boolean z, String str, boolean z2) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[]{"onSearchWAWidgetOnTapCallback"});
        x.i("FTSSearchWidgetMgr", "on widget call %s , hasHandler %s, eventId %s,res %s", new Object[]{"onSearchWAWidgetOnTapCallback", Boolean.valueOf(z), str, Boolean.valueOf(z2)});
        d a = b.a(this.pOa);
        if (!z) {
            z2 = false;
        }
        a.a(str, z2, "", this.pOh);
    }
}
