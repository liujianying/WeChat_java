package com.tencent.mm.plugin.appbrand.jsapi.g;

import com.tencent.mm.plugin.appbrand.i.a.b;
import com.tencent.mm.plugin.appbrand.i.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements b {
    final /* synthetic */ l fCl;
    final /* synthetic */ a fVX;

    a$1(a aVar, l lVar) {
        this.fVX = aVar;
        this.fCl = lVar;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: loadResult: %s", new Object[]{dVar.toString()});
        switch (a$3.fVY[dVar.ordinal()]) {
            case 1:
                a.a(this.fCl, this.fVX.fEl, "success", this.fVX.fVW, 100, this.fVX.mTotalSize, this.fVX.mTotalSize);
                return;
            case 2:
                a.a(this.fCl, this.fVX.fEl, "fail", this.fVX.fVW, 0, -1, -1);
                return;
            case 3:
                x.w("MicroMsg.JsApiCreateLoadSubPackageTask", "hy: should not happen cancel!!");
                a.a(this.fCl, this.fVX.fEl, "fail", this.fVX.fVW, 0, -1, -1);
                return;
            default:
                return;
        }
    }
}
