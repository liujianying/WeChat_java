package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

class f$3 extends TimerTask {
    final /* synthetic */ p hlF;
    final /* synthetic */ ag hlG;

    f$3(p pVar, ag agVar) {
        this.hlF = pVar;
        this.hlG = agVar;
    }

    public final void run() {
        if (this.hlF != null) {
            this.hlF.dismiss();
            this.hlG.sendEmptyMessage(0);
        }
    }
}
