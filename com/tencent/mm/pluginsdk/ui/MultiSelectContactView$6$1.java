package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.pluginsdk.ui.MultiSelectContactView.6;

class MultiSelectContactView$6$1 implements Runnable {
    final /* synthetic */ 6 qGf;

    MultiSelectContactView$6$1(6 6) {
        this.qGf = 6;
    }

    public final void run() {
        MultiSelectContactView.h(this.qGf.qGe).removeView(this.qGf.val$view);
        MultiSelectContactView.i(this.qGf.qGe);
        MultiSelectContactView.a(this.qGf.qGe, MultiSelectContactView.h(this.qGf.qGe).getChildCount());
    }
}
