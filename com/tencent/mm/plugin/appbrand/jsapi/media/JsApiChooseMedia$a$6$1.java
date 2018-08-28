package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.6;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class JsApiChooseMedia$a$6$1 implements Runnable {
    final /* synthetic */ ArrayList fUJ;
    final /* synthetic */ ArrayList fUM;
    final /* synthetic */ 6 fUN;

    JsApiChooseMedia$a$6$1(6 6, ArrayList arrayList, ArrayList arrayList2) {
        this.fUN = 6;
        this.fUJ = arrayList;
        this.fUM = arrayList2;
    }

    public final void run() {
        x.i("MicroMsg.JsApiChooseMedia", "handle image from album is ok");
        this.fUN.fUI.fUE.bjW = -1;
        this.fUN.fUI.fUE.type = "image";
        this.fUN.fUI.fUE.fUD = JsApiChooseMedia$a.c(this.fUJ, this.fUM);
        this.fUN.fUI.l((ProcessResult) this.fUN.fUI.fUE);
    }
}
