package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.AddContactResult;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact.a;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.sdk.platformtools.x;

class JsApiPrivateAddContact$a$1 implements n {
    final /* synthetic */ AddContactResult fGE;
    final /* synthetic */ a fGF;

    JsApiPrivateAddContact$a$1(a aVar, AddContactResult addContactResult) {
        this.fGF = aVar;
        this.fGE = addContactResult;
    }

    public final void ky(int i) {
        x.i("MicroMsg.JsApiPrivateAddContact", "onAddContact resultCode:%d", new Object[]{Integer.valueOf(i)});
        AddContactResult.a(this.fGE, i);
        a.a(this.fGF, this.fGE);
    }
}
