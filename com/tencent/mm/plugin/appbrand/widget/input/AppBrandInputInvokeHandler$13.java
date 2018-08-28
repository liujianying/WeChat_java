package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.z.b;

class AppBrandInputInvokeHandler$13 implements b {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$13(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final boolean lV(int i) {
        if (i != 67) {
            return false;
        }
        this.gGE.onBackspaceWhenValueEmpty();
        return true;
    }
}
