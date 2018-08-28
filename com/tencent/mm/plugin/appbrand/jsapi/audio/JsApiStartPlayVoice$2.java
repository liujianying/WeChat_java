package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.e;

class JsApiStartPlayVoice$2 implements e {
    final /* synthetic */ p fIY;
    final /* synthetic */ JsApiStartPlayVoice fIZ;

    JsApiStartPlayVoice$2(JsApiStartPlayVoice jsApiStartPlayVoice, p pVar) {
        this.fIZ = jsApiStartPlayVoice;
        this.fIY = pVar;
    }

    public final void onDestroy() {
        JsApiStopPlayVoice.ahZ();
        this.fIY.b(this);
        b ib = u.Hx().ib("JsApi@" + this.fIY.hashCode());
        if (ib != null) {
            ib.recycle();
        }
    }
}
