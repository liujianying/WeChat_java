package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo.a;
import java.io.File;

class JsApiChooseVideo$a$2 implements Runnable {
    final /* synthetic */ a fUU;

    JsApiChooseVideo$a$2(a aVar) {
        this.fUU = aVar;
    }

    public final void run() {
        if (new File(a.b(this.fUU)).exists()) {
            a.a(this.fUU).bjW = -1;
            a.a(this.fUU).fUR = a.a(this.fUU, a.b(this.fUU), a.c(this.fUU).fUQ);
            a.b(this.fUU, a.a(this.fUU));
            return;
        }
        a.a(this.fUU).bjW = -2;
        a.c(this.fUU, a.a(this.fUU));
    }
}
