package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$1 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$1(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        ax a = SnsTimeLineUI.a(this.odw);
        if (a != null) {
            a.oeg.bDI();
            a.oeg.notifyVendingDataChange();
        }
    }
}
