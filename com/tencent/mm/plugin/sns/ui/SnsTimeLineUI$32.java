package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$32 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$32(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.g(this.odw) != null) {
            SnsTimeLineUI.g(this.odw).nLO.nUa = SnsTimeLineUI.h(this.odw).kww.getBottom();
            SnsTimeLineUI.g(this.odw).nLO.ohR = SnsTimeLineUI.h(this.odw).lbd.getTop();
            SnsTimeLineUI.D(this.odw).odQ = SnsTimeLineUI.h(this.odw).nvg.getTop();
        }
    }
}
