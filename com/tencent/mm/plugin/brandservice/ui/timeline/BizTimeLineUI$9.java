package com.tencent.mm.plugin.brandservice.ui.timeline;

class BizTimeLineUI$9 implements Runnable {
    final /* synthetic */ BizTimeLineUI hst;
    final /* synthetic */ boolean hsw;

    BizTimeLineUI$9(BizTimeLineUI bizTimeLineUI, boolean z) {
        this.hst = bizTimeLineUI;
        this.hsw = z;
    }

    public final void run() {
        if (this.hsw) {
            BizTimeLineUI.b(this.hst);
        }
        this.hst.avn();
    }
}
