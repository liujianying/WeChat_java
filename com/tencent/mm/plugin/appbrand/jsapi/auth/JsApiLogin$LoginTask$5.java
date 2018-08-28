package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.d;
import com.tencent.mm.u.a.d.a;

class JsApiLogin$LoginTask$5 implements a<d> {
    final /* synthetic */ LoginTask fJD;
    final /* synthetic */ LoginTask.a fJF;
    final /* synthetic */ int fvO;

    JsApiLogin$LoginTask$5(LoginTask loginTask, LoginTask.a aVar, int i) {
        this.fJD = loginTask;
        this.fJF = aVar;
        this.fvO = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        d dVar = (d) lVar;
        x.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            this.fJF.aid();
        } else if (!(dVar instanceof d)) {
            x.i("MicroMsg.JsApiLogin", "not jslogin cgi reqeust");
            this.fJF.aid();
        } else if (this.fvO == 2) {
            x.i("MicroMsg.JsApiLogin", "press reject button");
            this.fJF.aid();
        } else {
            aow CX = dVar.CX();
            int i3 = CX.rRd.bMH;
            String str2 = CX.rRd.bMI;
            x.i("MicroMsg.JsApiLogin", "stev NetSceneJSLoginConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                this.fJF.qe(CX.rRg);
                x.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                return;
            }
            this.fJF.aid();
            x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLoginConfirm %s", new Object[]{str2});
        }
    }
}
