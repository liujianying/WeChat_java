package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.4;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h$b;

class CollectCreateQRCodeUI$4$1 implements h$b {
    final /* synthetic */ 4 hXG;

    CollectCreateQRCodeUI$4$1(4 4) {
        this.hXG = 4;
    }

    public final boolean p(CharSequence charSequence) {
        if (bi.oW(charSequence.toString())) {
            CollectCreateQRCodeUI.a(this.hXG.hXF, "");
            CollectCreateQRCodeUI.c(this.hXG.hXF);
        } else {
            CollectCreateQRCodeUI.a(this.hXG.hXF, charSequence.toString());
            CollectCreateQRCodeUI.c(this.hXG.hXF);
        }
        return true;
    }
}
