package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class AppBrandInputInvokeHandler$5 implements OnKeyListener {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$5(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        AppBrandInputInvokeHandler.access$602(this.gGE, 67 == i);
        if (AppBrandInputInvokeHandler.access$600(this.gGE)) {
            AppBrandInputInvokeHandler.access$1300(this.gGE).removeCallbacks(AppBrandInputInvokeHandler.access$1200(this.gGE));
            AppBrandInputInvokeHandler.access$1300(this.gGE).postDelayed(AppBrandInputInvokeHandler.access$1200(this.gGE), 1000);
        } else {
            AppBrandInputInvokeHandler.access$1200(this.gGE).run();
        }
        return false;
    }
}
