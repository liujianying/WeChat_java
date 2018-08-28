package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.ui.j;

class AppBrandInputInvokeHandler$1 implements OnFocusChangeListener {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$1(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final void onFocusChange(View view, boolean z) {
        AppBrandInputInvokeHandler.access$000(this.gGE, z);
        Object obj = (!z || (AppBrandInputInvokeHandler.access$100(this.gGE).gLx && !j.bM(AppBrandInputInvokeHandler.access$200(this.gGE)))) ? null : 1;
        if (obj != null && AppBrandInputInvokeHandler.access$200(this.gGE) != null && AppBrandInputInvokeHandler.access$300(this.gGE) != null) {
            AppBrandInputInvokeHandler.access$200(this.gGE).requestFocus();
            AppBrandInputInvokeHandler.access$300(this.gGE).show();
        }
    }
}
