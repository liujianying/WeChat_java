package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.c;

class AppBrandInputInvokeHandler$6 implements OnEditorActionListener {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;
    final /* synthetic */ int gGF;

    AppBrandInputInvokeHandler$6(AppBrandInputInvokeHandler appBrandInputInvokeHandler, int i) {
        this.gGE = appBrandInputInvokeHandler;
        this.gGF = i;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != this.gGF) {
            return false;
        }
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.gGE, c.gGH);
        AppBrandInputInvokeHandler.access$1000(this.gGE);
        AppBrandInputInvokeHandler.access$902$2c1acb32(this.gGE, 0);
        return true;
    }
}
