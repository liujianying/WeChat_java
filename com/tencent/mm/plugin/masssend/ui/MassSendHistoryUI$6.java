package com.tencent.mm.plugin.masssend.ui;

import com.tencent.mm.ui.base.MMPullDownView.c;

class MassSendHistoryUI$6 implements c {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$6(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final boolean aCi() {
        if (MassSendHistoryUI.d(this.lbg).getChildAt(MassSendHistoryUI.d(this.lbg).getChildCount() - 1).getBottom() > MassSendHistoryUI.d(this.lbg).getHeight() || MassSendHistoryUI.d(this.lbg).getLastVisiblePosition() != MassSendHistoryUI.d(this.lbg).getAdapter().getCount() - 1) {
            return false;
        }
        return true;
    }
}
