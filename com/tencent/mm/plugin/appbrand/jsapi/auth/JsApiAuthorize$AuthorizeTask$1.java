package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiAuthorize.AuthorizeTask.a;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class JsApiAuthorize$AuthorizeTask$1 implements a {
    final /* synthetic */ AuthorizeTask fJA;

    JsApiAuthorize$AuthorizeTask$1(AuthorizeTask authorizeTask) {
        this.fJA = authorizeTask;
    }

    public final void onSuccess() {
        x.d("MicroMsg.JsApiAuthorize", "onSuccess !");
        this.fJA.fJw = "ok";
        AuthorizeTask.a(this.fJA);
    }

    public final void aid() {
        x.e("MicroMsg.JsApiAuthorize", "onFailure !");
        this.fJA.fJw = "fail";
        AuthorizeTask.b(this.fJA);
    }

    public final void a(LinkedList<bio> linkedList, String str, String str2) {
        x.d("MicroMsg.JsApiAuthorize", "onConfirm !");
        this.fJA.fJy = linkedList.size();
        int i = 0;
        while (i < this.fJA.fJy) {
            try {
                this.fJA.fJz.putByteArray(String.valueOf(i), ((bio) linkedList.get(i)).toByteArray());
                i++;
            } catch (Throwable e) {
                x.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                this.fJA.fJw = "fail";
                AuthorizeTask.c(this.fJA);
                return;
            }
        }
        this.fJA.mAppName = str;
        this.fJA.fyq = str2;
        this.fJA.fJw = "needConfirm";
        AuthorizeTask.d(this.fJA);
    }
}
