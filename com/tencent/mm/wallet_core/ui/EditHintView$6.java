package com.tencent.mm.wallet_core.ui;

import android.text.method.NumberKeyListener;

class EditHintView$6 extends NumberKeyListener {
    final /* synthetic */ EditHintView uYF;

    EditHintView$6(EditHintView editHintView) {
        this.uYF = editHintView;
    }

    public final int getInputType() {
        return 1;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
    }
}
