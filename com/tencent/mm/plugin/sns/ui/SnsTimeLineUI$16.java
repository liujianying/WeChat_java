package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;

class SnsTimeLineUI$16 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$16(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.odw) != null && SnsTimeLineUI.n(this.odw)) {
            af.byl().pause();
        }
    }
}
