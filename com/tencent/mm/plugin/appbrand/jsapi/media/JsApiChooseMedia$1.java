package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class JsApiChooseMedia$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiChooseMedia fUy;

    JsApiChooseMedia$1(JsApiChooseMedia jsApiChooseMedia, l lVar) {
        this.fUy = jsApiChooseMedia;
        this.fCl = lVar;
    }

    public final void onResume() {
        x.i("MicroMsg.JsApiChooseMedia", "chooseMedia, onResume, remove listener");
        JsApiChooseMedia.Ju();
        e.b(this.fCl.mAppId, this);
    }
}
