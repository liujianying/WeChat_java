package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandInputInvokeHandler$12 implements b {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$12(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final void agA() {
        if (AppBrandInputInvokeHandler.access$200(this.gGE) != null) {
            x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", AppBrandInputInvokeHandler.access$200(this.gGE).getEditableText());
            AppBrandInputInvokeHandler.access$400(this.gGE).a(AppBrandInputInvokeHandler.access$200(this.gGE).getEditableText(), false);
        }
    }
}
