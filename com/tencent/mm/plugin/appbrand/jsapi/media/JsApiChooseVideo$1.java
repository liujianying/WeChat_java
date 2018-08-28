package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.l;

class JsApiChooseVideo$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiChooseVideo fUP;

    JsApiChooseVideo$1(JsApiChooseVideo jsApiChooseVideo, l lVar) {
        this.fUP = jsApiChooseVideo;
        this.fCl = lVar;
    }

    public final void onResume() {
        JsApiChooseVideo.Ju();
        e.b(this.fCl.mAppId, this);
    }
}
