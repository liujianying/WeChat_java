package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.widget.input.u.d;
import com.tencent.mm.sdk.platformtools.bi;

class AppBrandInputInvokeHandler$2 implements d {
    final /* synthetic */ AppBrandInputInvokeHandler gGE;

    AppBrandInputInvokeHandler$2(AppBrandInputInvokeHandler appBrandInputInvokeHandler) {
        this.gGE = appBrandInputInvokeHandler;
    }

    public final boolean wi(String str) {
        if (AppBrandInputInvokeHandler.access$200(this.gGE) != null) {
            w access$200;
            if ("[DELETE_EMOTION]".equalsIgnoreCase(str)) {
                access$200 = AppBrandInputInvokeHandler.access$200(this.gGE);
                if (access$200.gHZ == null) {
                    access$200.dispatchKeyEvent(new KeyEvent(0, 67));
                    access$200.dispatchKeyEvent(new KeyEvent(1, 67));
                } else if (!bi.K(access$200.getEditableText())) {
                    access$200.gHZ.deleteSurroundingText(access$200.getEditableText().length(), access$200.getEditableText().length() - 1);
                }
            } else {
                access$200 = AppBrandInputInvokeHandler.access$200(this.gGE);
                if (access$200.getEditableText() == null) {
                    access$200.setText(str, BufferType.EDITABLE);
                } else {
                    access$200.getEditableText().append(str);
                }
                access$200.setSelection(access$200.getEditableText().length());
            }
        }
        return true;
    }
}
