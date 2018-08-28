package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.ai.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$10 implements a {
    final /* synthetic */ c fKg;

    c$10(c cVar) {
        this.fKg = cVar;
    }

    public final void to(String str) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "smsListener onchange");
        x.d("MicroMsg.JsApiGetPhoneNumber", "smsVerifyCode:%s", new Object[]{str});
        this.fKg.fJX.setText(str);
    }
}
