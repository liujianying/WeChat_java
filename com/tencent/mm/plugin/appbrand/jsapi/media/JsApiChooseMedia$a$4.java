package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class JsApiChooseMedia$a$4 implements Runnable {
    final /* synthetic */ a fUI;

    JsApiChooseMedia$a$4(a aVar) {
        this.fUI = aVar;
    }

    public final void run() {
        if (new File(a.f(this.fUI)).exists()) {
            x.i("MicroMsg.JsApiChooseMedia", "take media local, the mVideoFilePath file exist, success");
            a.e(this.fUI).bjW = -1;
            a.e(this.fUI).type = "video";
            AppBrandLocalVideoObject a = a.a(this.fUI, a.f(this.fUI));
            if (a == null) {
                x.e("MicroMsg.JsApiChooseMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[]{a.f(this.fUI)});
                a.e(this.fUI).bjW = -2;
                a.b(this.fUI, a.e(this.fUI));
                return;
            }
            a.b(this.fUI, a.f(this.fUI));
            String g = a.g(this.fUI);
            a.e(this.fUI).fUD = a.d(a.bNH, g, a.duration, a.height, a.width, a.size);
            a.c(this.fUI, a.e(this.fUI));
            return;
        }
        x.e("MicroMsg.JsApiChooseMedia", "take media local, mVideoFilePath is %s, the file not exist, fail", new Object[]{a.f(this.fUI)});
        a.e(this.fUI).bjW = -2;
        a.d(this.fUI, a.e(this.fUI));
    }
}
