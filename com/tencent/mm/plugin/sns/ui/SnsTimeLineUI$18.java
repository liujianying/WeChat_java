package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.s;

class SnsTimeLineUI$18 implements Runnable {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$18(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void run() {
        s sVar = this.odw.mController;
        if (sVar.mContext != null) {
            sVar.U(sVar.tml);
        }
        SnsTimeLineUI.o(this.odw);
        this.odw.setMMTitle(this.odw.getString(j.sns_timeline_ui_title));
        SnsTimeLineUI.p(this.odw);
        SnsTimeLineUI.b(this.odw, SnsTimeLineUI.h(this.odw).kww.getFirstVisiblePosition());
    }
}
