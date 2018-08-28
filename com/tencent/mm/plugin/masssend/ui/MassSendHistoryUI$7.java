package com.tencent.mm.plugin.masssend.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.d;

class MassSendHistoryUI$7 implements d {
    final /* synthetic */ MassSendHistoryUI lbg;

    MassSendHistoryUI$7(MassSendHistoryUI massSendHistoryUI) {
        this.lbg = massSendHistoryUI;
    }

    public final boolean aCh() {
        View childAt = MassSendHistoryUI.d(this.lbg).getChildAt(MassSendHistoryUI.d(this.lbg).getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            return false;
        }
        return true;
    }
}
