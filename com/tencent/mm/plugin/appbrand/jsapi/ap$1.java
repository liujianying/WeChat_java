package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;

class ap$1 implements a {
    final /* synthetic */ l fCl;
    final /* synthetic */ ap fGo;

    ap$1(ap apVar, l lVar) {
        this.fGo = apVar;
        this.fCl = lVar;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            this.fCl.E(this.fGo.fFw, this.fGo.f("ok", null));
            x.i("MicroMsg.JsApiOpenCard", "view card result is cancel!");
        } else if (i2 == 0) {
            this.fCl.E(this.fGo.fFw, this.fGo.f("cancel", null));
            x.e("MicroMsg.JsApiOpenCard", "view card result is cancel!");
        } else {
            this.fCl.E(this.fGo.fFw, this.fGo.f("fail", null));
            x.e("MicroMsg.JsApiOpenCard", "view card result is fail!");
        }
    }
}
