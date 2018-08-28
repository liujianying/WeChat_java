package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class c$5 implements a {
    final /* synthetic */ c fKg;
    final /* synthetic */ p fKi;

    c$5(c cVar, p pVar) {
        this.fKg = cVar;
        this.fKi = pVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        this.fKi.dismiss();
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "checkVerifyCode success");
            this.fKg.fJQ.getContentView().post(new 1(this, (ov) bVar.dIE.dIL));
            return;
        }
        x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber checkVerifyCode cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        this.fKg.fJQ.E(this.fKg.fFd, this.fKg.f("fail:checkVerifyCode cgi fail", null));
        h.mEJ.h(14249, new Object[]{this.fKg.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.fKg.fKd), Integer.valueOf(this.fKg.fKe), Integer.valueOf(this.fKg.fKc)});
    }
}
