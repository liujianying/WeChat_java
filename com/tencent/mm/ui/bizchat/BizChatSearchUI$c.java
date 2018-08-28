package com.tencent.mm.ui.bizchat;

import android.view.View;

class BizChatSearchUI$c {
    View hoT;
    View hoU;
    View hoV;

    private BizChatSearchUI$c() {
    }

    /* synthetic */ BizChatSearchUI$c(byte b) {
        this();
    }

    final void u(boolean z, boolean z2) {
        int i;
        int i2 = 0;
        View view = this.hoT;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        view.setVisibility(i);
        this.hoU.setVisibility(8);
        View view2 = this.hoV;
        if (!z2) {
            i2 = 8;
        }
        view2.setVisibility(i2);
    }
}
