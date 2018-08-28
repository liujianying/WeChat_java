package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.c;
import com.tencent.mm.u.a.c.a;
import java.util.LinkedList;

class JsApiLogin$LoginTask$4 implements a<c> {
    final /* synthetic */ LoginTask fJD;
    final /* synthetic */ LoginTask.a fJF;

    JsApiLogin$LoginTask$4(LoginTask loginTask, LoginTask.a aVar) {
        this.fJD = loginTask;
        this.fJF = aVar;
    }

    public final /* synthetic */ void b(int i, int i2, String str, l lVar) {
        c cVar = (c) lVar;
        x.i("MicroMsg.JsApiLogin", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0 && cVar != null) {
            aoy CW = cVar.CW();
            int i3 = CW.rRd.bMH;
            String str2 = CW.rRd.bMI;
            String str3 = CW.rRf;
            x.i("MicroMsg.JsApiLogin", "stev NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                LinkedList linkedList = CW.rEI;
                x.i("MicroMsg.JsApiLogin", "stev appName %s, appIconUrl %s", new Object[]{CW.jSv, CW.rbh});
                this.fJF.a(linkedList, str2, r0, str3);
                return;
            } else if (i3 == 0) {
                this.fJF.qe(CW.rRg);
                x.i("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[]{r0});
                return;
            } else if (i3 == -12001) {
                this.fJF.aid();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Scope %s", new Object[]{str2});
                return;
            } else if (i3 == -12002) {
                this.fJF.aid();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid Data %s", new Object[]{str2});
                return;
            } else if (i3 == -12003) {
                this.fJF.aid();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin Invalid ApiName %s", new Object[]{str2});
                return;
            } else {
                this.fJF.aid();
                x.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                return;
            }
        }
        this.fJF.aid();
    }
}
