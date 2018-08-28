package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.protocal.c.aid;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class c$3 implements a {
    final /* synthetic */ p fIY;
    final /* synthetic */ c fPu;
    final /* synthetic */ c.a fPv;
    final /* synthetic */ AppBrandSysConfig fdg;

    c$3(c cVar, c.a aVar, p pVar, AppBrandSysConfig appBrandSysConfig) {
        this.fPu = cVar;
        this.fPv = aVar;
        this.fIY = pVar;
        this.fdg = appBrandSysConfig;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            x.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", ((aid) bVar.dIE.dIL).rKU);
            ah.A(new 1(this, r0));
            return;
        }
        x.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL);
        if (this.fPv != null) {
            this.fPv.a(false, "fail:cgi fail", null);
        }
    }
}
