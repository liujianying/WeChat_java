package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ p fJO;
    final /* synthetic */ b fJP;

    b$1(b bVar, p pVar, int i) {
        this.fJP = bVar;
        this.fJO = pVar;
        this.doP = i;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            x.i("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData success");
            this.fJO.E(this.doP, this.fJP.f("ok", null));
            return;
        }
        x.e("MicroMsg.JsApiDeleteUserAutoFillData", "deleteUserAutoFillData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        this.fJO.E(this.doP, this.fJP.f("fail:cgi fail", null));
    }
}
