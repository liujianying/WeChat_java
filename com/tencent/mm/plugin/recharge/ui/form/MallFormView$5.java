package com.tencent.mm.plugin.recharge.ui.form;

import android.text.method.NumberKeyListener;

class MallFormView$5 extends NumberKeyListener {
    final /* synthetic */ MallFormView mrB;

    MallFormView$5(MallFormView mallFormView) {
        this.mrB = mallFormView;
    }

    public final int getInputType() {
        return 18;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }
}
