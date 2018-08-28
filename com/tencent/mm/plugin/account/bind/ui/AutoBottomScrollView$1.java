package com.tencent.mm.plugin.account.bind.ui;

class AutoBottomScrollView$1 implements Runnable {
    final /* synthetic */ AutoBottomScrollView eEP;

    AutoBottomScrollView$1(AutoBottomScrollView autoBottomScrollView) {
        this.eEP = autoBottomScrollView;
    }

    public final void run() {
        this.eEP.smoothScrollTo(0, this.eEP.getBottom());
    }
}
