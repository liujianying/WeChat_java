package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.modelappbrand.z;
import com.tencent.mm.sdk.platformtools.x;

class b$6 extends z {
    final /* synthetic */ b pOa;
    final /* synthetic */ String pOh;

    b$6(b bVar, String str) {
        this.pOa = bVar;
        this.pOh = str;
    }

    public final void jt(String str) {
        x.v("FTSSearchWidgetMgr", "on widget call %s ", new Object[]{"onOpenApp"});
        b.a(this.pOa, str, this.pOh);
    }
}
