package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.f;

class AppBrandInputInvokeHandler$11 extends f {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$11(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.gGE.mPageRef != null && this.gGE.mPageRef.get() != null && AppBrandInputInvokeHandler.access$200(this.gGE) != null) {
            AppBrandInputInvokeHandler.access$700(this.gGE);
            if (af.s(editable)) {
                x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", editable);
                return;
            }
            x.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", editable);
            AppBrandInputInvokeHandler.access$400(this.gGE).a(AppBrandInputInvokeHandler.access$200(this.gGE).getEditableText(), AppBrandInputInvokeHandler.access$600(this.gGE));
        }
    }
}
