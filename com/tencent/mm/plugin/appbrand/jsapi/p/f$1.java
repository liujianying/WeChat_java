package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.s.d;

class f$1 implements Runnable {
    final /* synthetic */ p fIY;
    final /* synthetic */ f gdm;

    f$1(f fVar, p pVar) {
        this.gdm = fVar;
        this.fIY = pVar;
    }

    public final void run() {
        r rVar = this.fIY.gnt;
        rVar.setPullDownEnabled(true);
        rVar.cE(false);
        rVar.aK("light", a.g(this.fIY.mContext, d.webview_logo_bg_color));
    }
}
