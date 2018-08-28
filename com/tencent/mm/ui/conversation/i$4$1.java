package com.tencent.mm.ui.conversation;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.i.4;

class i$4$1 implements Runnable {
    final /* synthetic */ 4 uqT;

    i$4$1(4 4) {
        this.uqT = 4;
    }

    public final void run() {
        if (this.uqT.uqR.uqF == null || !this.uqT.uqR.uqF.isShowing()) {
            h.mEJ.a(614, 60, 1, false);
            this.uqT.uqR.uqF = com.tencent.mm.ui.base.h.a(this.uqT.uqR.bOb, this.uqT.uqS.bIr, this.uqT.uqS.title, this.uqT.uqS.sqq, this.uqT.uqS.kcL, false, new 1(this), new 2(this));
            i.cck();
            return;
        }
        x.i("MicroMsg.InitHelper", "update dialog is showing.");
    }
}
