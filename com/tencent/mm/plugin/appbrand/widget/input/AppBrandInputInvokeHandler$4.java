package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.c;
import com.tencent.mm.plugin.appbrand.widget.input.u.e;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandInputInvokeHandler$4 implements e {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$4(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final void kn(int i) {
        x.d("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[]{Integer.valueOf(i)});
        if (i != 2) {
            if (i == 0 && AppBrandInputInvokeHandler.access$200(this.gGE) != null) {
                AppBrandInputInvokeHandler.access$200(this.gGE).requestFocus();
            }
            AppBrandInputInvokeHandler.access$1100(this.gGE);
            if (this.gGE.mPageRef != null && this.gGE.mPageRef.get() != null) {
                m.a((p) this.gGE.mPageRef.get(), AppBrandInputInvokeHandler.access$200(this.gGE));
                return;
            }
            return;
        }
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.gGE, c.gGG);
        AppBrandInputInvokeHandler.access$1000(this.gGE);
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.gGE, 0);
    }
}
