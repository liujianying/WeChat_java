package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.p;
import java.util.TimerTask;

class e$4 extends TimerTask {
    final /* synthetic */ p hlF;
    final /* synthetic */ ag hlG;

    e$4(p pVar, ag agVar) {
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
