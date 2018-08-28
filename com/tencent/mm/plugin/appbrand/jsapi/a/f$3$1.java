package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.f.3;
import com.tencent.mm.sdk.platformtools.x;

class f$3$1 implements a {
    final /* synthetic */ 3 fKB;

    f$3$1(3 3) {
        this.fKB = 3;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            x.i("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData success");
            return;
        }
        x.e("MicroMsg.JsApiRequestAuthUserAutoFillData", "requestAuthUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
    }
}
