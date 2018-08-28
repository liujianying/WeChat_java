package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.5;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$5$1 implements Runnable {
    final /* synthetic */ ArrayList fUJ;
    final /* synthetic */ ArrayList fUK;
    final /* synthetic */ 5 fUL;

    JsApiChooseMedia$a$5$1(5 5, ArrayList arrayList, ArrayList arrayList2) {
        this.fUL = 5;
        this.fUJ = arrayList;
        this.fUK = arrayList2;
    }

    public final void run() {
        x.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
        a.e(this.fUL.fUI).bjW = -1;
        a.e(this.fUL.fUI).type = "image";
        a.e(this.fUL.fUI).fUD = a.d(this.fUJ, this.fUK);
        a.f(this.fUL.fUI, a.e(this.fUL.fUI));
    }
}
