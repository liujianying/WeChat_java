package com.tencent.mm.plugin.collect.ui;

import com.tencent.mm.plugin.wallet_core.ui.m.a;

class CollectMainUI$17 implements a {
    final /* synthetic */ CollectMainUI hYN;

    CollectMainUI$17(CollectMainUI collectMainUI) {
        this.hYN = collectMainUI;
    }

    public final void aCb() {
        this.hYN.hYo = false;
        this.hYN.aCo();
        CollectMainUI.g(this.hYN).setText(CollectMainUI.f(this.hYN));
        CollectMainUI.h(this.hYN);
    }
}
