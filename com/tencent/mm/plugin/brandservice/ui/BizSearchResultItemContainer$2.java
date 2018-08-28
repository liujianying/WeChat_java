package com.tencent.mm.plugin.brandservice.ui;

class BizSearchResultItemContainer$2 implements Runnable {
    final /* synthetic */ BizSearchResultItemContainer hoS;

    BizSearchResultItemContainer$2(BizSearchResultItemContainer bizSearchResultItemContainer) {
        this.hoS = bizSearchResultItemContainer;
    }

    public final void run() {
        BizSearchResultItemContainer.e(this.hoS).setVisibility(BizSearchResultItemContainer.d(this.hoS).isEmpty() ? 0 : 8);
    }
}
