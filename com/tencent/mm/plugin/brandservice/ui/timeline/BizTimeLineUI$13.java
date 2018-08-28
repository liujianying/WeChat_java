package com.tencent.mm.plugin.brandservice.ui.timeline;

class BizTimeLineUI$13 implements Runnable {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$13(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final void run() {
        if (!this.hst.tlP && !this.hst.isFinishing()) {
            BizTimeLineUI.e(this.hst);
        }
    }
}
