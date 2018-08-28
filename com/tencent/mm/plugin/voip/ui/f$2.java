package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.TimerTask;

class f$2 extends TimerTask {
    final /* synthetic */ f oSK;

    f$2(f fVar) {
        this.oSK = fVar;
    }

    public final void run() {
        this.oSK.guJ.post(new Runnable() {
            public final void run() {
                f.g(f$2.this.oSK).setText(f.bx(bi.bG(f$2.this.oSK.oQe)));
            }
        });
    }
}
