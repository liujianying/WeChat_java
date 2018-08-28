package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$26 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$26(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        x.i("MicroMsg.SnsTimeLineUI", "onResume go to playAnim " + SnsTimeLineUI.B(this.odw));
        if (SnsTimeLineUI.B(this.odw)) {
            SnsTimeLineUI.C(this.odw);
            SnsTimeLineUI.D(this.odw).bEj();
        }
    }
}
