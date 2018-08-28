package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.a;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiLogin$LoginTask$1 implements a {
    final /* synthetic */ LoginTask fJD;

    JsApiLogin$LoginTask$1(LoginTask loginTask) {
        this.fJD = loginTask;
    }

    public final void qe(String str) {
        x.i("MicroMsg.JsApiLogin", "onSuccess !");
        this.fJD.code = str;
        this.fJD.fJw = "ok";
        LoginTask.a(this.fJD);
    }

    public final void aid() {
        x.i("MicroMsg.JsApiLogin", "onFailure !");
        this.fJD.fJw = "fail";
        LoginTask.b(this.fJD);
    }

    public final void a(LinkedList<bio> linkedList, String str, String str2, String str3) {
        x.i("MicroMsg.JsApiLogin", "onConfirm !");
        this.fJD.fJy = linkedList.size();
        int i = 0;
        while (i < this.fJD.fJy) {
            try {
                this.fJD.fJz.putByteArray(String.valueOf(i), ((bio) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiLogin", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                this.fJD.fJw = "fail";
                LoginTask.c(this.fJD);
                return;
            }
        }
        this.fJD.fHN = str3;
        this.fJD.mAppName = str;
        this.fJD.fyq = str2;
        this.fJD.fJw = "needConfirm";
        LoginTask.d(this.fJD);
    }
}
