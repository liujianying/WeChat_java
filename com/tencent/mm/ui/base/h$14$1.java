package com.tencent.mm.ui.base;

import android.app.Dialog;
import com.tencent.mm.ui.base.h.14;

class h$14$1 implements Runnable {
    final /* synthetic */ int ttA;
    final /* synthetic */ 14 ttB;

    h$14$1(14 14, int i) {
        this.ttB = 14;
        this.ttA = i;
    }

    public final void run() {
        ((Dialog) this.ttB.mRl.getTag()).dismiss();
        if (this.ttB.ttz != null) {
            this.ttB.ttz.vh(this.ttA);
        }
    }
}
