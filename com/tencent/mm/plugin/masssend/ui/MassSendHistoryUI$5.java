package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView$g;

class MassSendHistoryUI$5 implements MMPullDownView$g {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$5(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final boolean aCj() {
        int i = 0;
        if (MassSendHistoryUI.b(this.lbg).ayQ()) {
            MassSendHistoryUI.d(this.lbg).setSelectionFromTop(0, MassSendHistoryUI.c(this.lbg).getTopHeight());
        } else {
            c b = MassSendHistoryUI.b(this.lbg);
            if (!b.ayQ()) {
                b.hFO += 10;
                if (b.hFO <= b.edl) {
                    i = 10;
                } else {
                    b.hFO = b.edl;
                    i = b.edl % 10;
                }
            }
            x.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
            MassSendHistoryUI.b(this.lbg).a(null, null);
            MassSendHistoryUI.d(this.lbg).setSelectionFromTop(i, MassSendHistoryUI.c(this.lbg).getTopHeight());
        }
        return true;
    }
}
