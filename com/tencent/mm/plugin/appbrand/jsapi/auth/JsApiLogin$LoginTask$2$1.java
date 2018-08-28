package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiLogin.LoginTask.2;
import com.tencent.mm.plugin.appbrand.widget.c.c$a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiLogin$LoginTask$2$1 implements c$a {
    final /* synthetic */ 2 fJE;

    JsApiLogin$LoginTask$2$1(2 2) {
        this.fJE = 2;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiLogin", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
                this.fJE.fJD.fJv = "loginConfirm";
                this.fJE.fJD.fJu = bundle;
                this.fJE.fJD.fJx = i;
                AppBrandMainProcessService.a(this.fJE.fJD);
                if (i == 2) {
                    this.fJE.fJD.fJr.a(this.fJE.fJD.fJs, this.fJE.fJD.fFd, "fail auth deny");
                    this.fJE.fJD.fJt.aia();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.JsApiLogin", "press back button!");
                this.fJE.fJD.fJr.a(this.fJE.fJD.fJs, this.fJE.fJD.fFd, "fail auth cancel");
                this.fJE.fJD.fJt.aia();
                return;
        }
    }
}
