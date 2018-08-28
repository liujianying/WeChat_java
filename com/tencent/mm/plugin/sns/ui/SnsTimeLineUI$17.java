package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.x;

class SnsTimeLineUI$17 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$17(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        if (SnsTimeLineUI.a(this.odw) != null && !SnsTimeLineUI.n(this.odw)) {
            x.v("MicroMsg.SnsTimeLineUI", "zeustest update onFling notify resume %s", new Object[]{Integer.valueOf(SnsTimeLineUI.h(this.odw).kww.getFirstVisiblePosition() - SnsTimeLineUI.h(this.odw).kww.getHeaderViewsCount())});
            af.byl().start();
            SnsTimeLineUI.a(this.odw).oef.bDT();
        }
    }
}
