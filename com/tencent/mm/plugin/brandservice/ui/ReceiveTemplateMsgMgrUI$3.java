package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.l;

class ReceiveTemplateMsgMgrUI$3 implements Runnable {
    final /* synthetic */ ReceiveTemplateMsgMgrUI hpP;

    ReceiveTemplateMsgMgrUI$3(ReceiveTemplateMsgMgrUI receiveTemplateMsgMgrUI) {
        this.hpP = receiveTemplateMsgMgrUI;
    }

    public final void run() {
        if (ReceiveTemplateMsgMgrUI.a(this.hpP)) {
            ReceiveTemplateMsgMgrUI.b(this.hpP);
            g.DF().a(new l(ReceiveTemplateMsgMgrUI.c(this.hpP), ReceiveTemplateMsgMgrUI.auZ()), 0);
        }
    }
}
