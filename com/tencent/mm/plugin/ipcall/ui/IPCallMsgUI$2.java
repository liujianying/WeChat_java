package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.g;

class IPCallMsgUI$2 implements g {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$2(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final void t(View view, int i) {
        IPCallMsgUI.a(this.kwA).performItemClick(view, i, 0);
    }
}
