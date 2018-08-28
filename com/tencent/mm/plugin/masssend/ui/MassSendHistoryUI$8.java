package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.ui.r.a;

class MassSendHistoryUI$8 implements a {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$8(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final void Xb() {
        MassSendHistoryUI.c(this.lbg).setIsTopShowAll(MassSendHistoryUI.b(this.lbg).ayQ());
        if (MassSendHistoryUI.b(this.lbg).getCount() == 0) {
            MassSendHistoryUI.c(this.lbg).setVisibility(8);
            MassSendHistoryUI.e(this.lbg).setVisibility(0);
            MassSendHistoryUI.f(this.lbg).setVisibility(8);
            return;
        }
        MassSendHistoryUI.c(this.lbg).setVisibility(0);
        MassSendHistoryUI.e(this.lbg).setVisibility(8);
        MassSendHistoryUI.f(this.lbg).setVisibility(0);
    }

    public final void Xa() {
    }
}
