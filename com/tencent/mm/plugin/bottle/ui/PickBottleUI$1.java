package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.plugin.bottle.a.h.b;

class PickBottleUI$1 implements Runnable {
    final /* synthetic */ PickBottleUI hmp;

    PickBottleUI$1(PickBottleUI pickBottleUI) {
        this.hmp = pickBottleUI;
    }

    public final void run() {
        PickBottleUI.a(this.hmp, new b());
        PickBottleUI.d(this.hmp).a(new 1(this));
    }
}
