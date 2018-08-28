package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.a.a;

class JsApiAuthorize$AuthorizeTask$4 implements a<com.tencent.mm.u.a.a> {
    final /* synthetic */ AuthorizeTask fJA;
    final /* synthetic */ AuthorizeTask.a fJC;

    JsApiAuthorize$AuthorizeTask$4(AuthorizeTask authorizeTask, AuthorizeTask.a aVar) {
        this.fJA = authorizeTask;
        this.fJC = aVar;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        com.tencent.mm.u.a.a aVar = (com.tencent.mm.u.a.a) lVar;
        x.d("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.fJC.aid();
        } else if (aVar instanceof com.tencent.mm.u.a.a) {
            aou CU = aVar.CU();
            int i3 = CU.rRd.bMH;
            String str2 = CU.rRd.bMI;
            x.i("MicroMsg.JsApiAuthorize", "stev NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                this.fJC.a(CU.rEI, CU.jSv, CU.rbh);
            } else if (i3 == 0) {
                this.fJC.onSuccess();
            } else {
                x.e("MicroMsg.JsApiAuthorize", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                this.fJC.aid();
            }
        }
    }
}
