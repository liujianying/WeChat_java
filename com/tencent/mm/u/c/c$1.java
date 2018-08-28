package com.tencent.mm.u.c;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.u.b.b.a;

class c$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ c doQ;

    c$1(c cVar, int i) {
        this.doQ = cVar;
        this.doP = i;
    }

    public final void aA(Object obj) {
        e eVar = this.doQ.doL.doR;
        int i = this.doP;
        String obj2 = obj == null ? "" : obj.toString();
        if (bi.oW(obj2)) {
            obj2 = "{}";
        }
        eVar.doX.evaluateJavascript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", new Object[]{Integer.valueOf(i), obj2}), null);
    }
}
