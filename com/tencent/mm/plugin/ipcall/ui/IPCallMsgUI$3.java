package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.ui.r.a;

class IPCallMsgUI$3 implements a {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$3(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final void Xa() {
    }

    public final void Xb() {
        if (IPCallMsgUI.b(this.kwA).getCount() == 0) {
            IPCallMsgUI.a(this.kwA).setVisibility(8);
            IPCallMsgUI.c(this.kwA).setVisibility(0);
            return;
        }
        IPCallMsgUI.a(this.kwA).setVisibility(0);
        IPCallMsgUI.c(this.kwA).setVisibility(8);
    }
}
