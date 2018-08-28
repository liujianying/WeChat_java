package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.l.a;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ d fXR;

    d$1(d dVar, l lVar) {
        this.fXR = dVar;
        this.fCl = lVar;
    }

    public final void ajy() {
        if (this.fXR.fXP != null) {
            p d = d.d(this.fCl);
            if (d == null) {
                x.w("MicroMsg.JsApiShowToast", "current page view is null.");
                return;
            }
            FrameLayout aha = d.aha();
            if (aha == null) {
                x.w("MicroMsg.JsApiShowToast", "pageArea is null, err");
            } else {
                d.a(this.fXR, aha);
            }
        }
    }
}
