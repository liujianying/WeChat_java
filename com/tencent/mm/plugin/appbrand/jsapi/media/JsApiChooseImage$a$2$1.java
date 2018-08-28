package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.2;
import java.util.ArrayList;

class JsApiChooseImage$a$2$1 implements Runnable {
    final /* synthetic */ ArrayList fUv;
    final /* synthetic */ 2 fUw;

    JsApiChooseImage$a$2$1(2 2, ArrayList arrayList) {
        this.fUw = 2;
        this.fUv = arrayList;
    }

    public final void run() {
        this.fUw.fUq.fUm.bjW = -1;
        this.fUw.fUq.fUm.fUk = this.fUv;
        a.b(this.fUw.fUq, this.fUw.fUq.fUm);
    }
}
