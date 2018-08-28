package com.tencent.mm.plugin.appbrand.jsapi.contact;

import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c.a;
import com.tencent.mm.sdk.platformtools.x;

class JsApiChattingTask$1 implements a {
    final /* synthetic */ JsApiChattingTask fPj;

    JsApiChattingTask$1(JsApiChattingTask jsApiChattingTask) {
        this.fPj = jsApiChattingTask;
    }

    public final void b(WxaAttributes wxaAttributes) {
        if (wxaAttributes == null) {
            x.w("MicroMsg.JsApiChattingTask", "info is null, err");
        }
        JsApiChattingTask.a(this.fPj);
    }
}
