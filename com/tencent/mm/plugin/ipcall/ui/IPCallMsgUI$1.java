package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class IPCallMsgUI$1 implements c {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$1(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final int cl(View view) {
        return IPCallMsgUI.a(this.kwA).getPositionForView(view);
    }
}
