package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.l;

class JsApiChooseImage$1 extends e$b {
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiChooseImage fUf;

    JsApiChooseImage$1(JsApiChooseImage jsApiChooseImage, l lVar) {
        this.fUf = jsApiChooseImage;
        this.fCl = lVar;
    }

    public final void onResume() {
        k.qv(this.fCl.mAppId).fdN = false;
        e.b(this.fCl.mAppId, this);
    }
}
