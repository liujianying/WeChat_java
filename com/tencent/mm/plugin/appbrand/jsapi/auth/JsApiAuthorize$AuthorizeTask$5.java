package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.protocal.c.aos;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import com.tencent.mm.u.a.b.a;

class JsApiAuthorize$AuthorizeTask$5 implements a<b> {
    final /* synthetic */ AuthorizeTask fJA;
    final /* synthetic */ AuthorizeTask.a fJC;
    final /* synthetic */ int fvO;

    JsApiAuthorize$AuthorizeTask$5(AuthorizeTask authorizeTask, AuthorizeTask.a aVar, int i) {
        this.fJA = authorizeTask;
        this.fJC = aVar;
        this.fvO = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        b bVar = (b) lVar;
        x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.fJC.aid();
        } else if (!(bVar instanceof b)) {
        } else {
            if (this.fvO == 2) {
                x.d("MicroMsg.JsApiAuthorize", "press reject button");
                return;
            }
            aos CV = bVar.CV();
            int i3 = CV.rRd.bMH;
            String str2 = CV.rRd.bMI;
            x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                this.fJC.onSuccess();
                return;
            }
            x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
            this.fJC.aid();
        }
    }
}
