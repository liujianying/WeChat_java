package com.tencent.mm.plugin.sns.ui;

class SnsTimeLineUI$48 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$48(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.odw) != null) {
            SnsTimeLineUI.a(this.odw).oeg.notifyVendingDataChange();
        }
        SnsTimeLineUI.M(this.odw);
    }
}
