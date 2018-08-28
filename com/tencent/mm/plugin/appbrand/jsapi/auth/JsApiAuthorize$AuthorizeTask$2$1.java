package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.2;
import com.tencent.mm.plugin.appbrand.widget.c.c.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiAuthorize$AuthorizeTask$2$1 implements a {
    final /* synthetic */ 2 fJB;

    JsApiAuthorize$AuthorizeTask$2$1(2 2) {
        this.fJB = 2;
    }

    public final void f(int i, Bundle bundle) {
        x.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
            case 2:
                this.fJB.fJA.fJv = "authorizeConfirm";
                this.fJB.fJA.fJu = bundle;
                this.fJB.fJA.fJx = i;
                AppBrandMainProcessService.a(this.fJB.fJA);
                if (i == 2) {
                    this.fJB.fJA.fJr.a(this.fJB.fJA.fJs, this.fJB.fJA.fFd, "fail auth deny");
                    this.fJB.fJA.fJt.aia();
                    return;
                }
                return;
            default:
                x.d("MicroMsg.JsApiAuthorize", "press back button!");
                this.fJB.fJA.fJr.a(this.fJB.fJA.fJs, this.fJB.fJA.fFd, "fail auth cancel");
                this.fJB.fJA.fJt.aia();
                return;
        }
    }
}
