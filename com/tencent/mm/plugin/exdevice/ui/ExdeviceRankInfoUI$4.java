package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView$d;

class ExdeviceRankInfoUI$4 implements MMPullDownView$d {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$4(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final boolean aCh() {
        int firstVisiblePosition = ExdeviceRankInfoUI.q(this.iFG).getFirstVisiblePosition();
        if (firstVisiblePosition == 0) {
            View childAt = ExdeviceRankInfoUI.q(this.iFG).getChildAt(firstVisiblePosition);
            if (childAt != null && childAt.getTop() >= 0) {
                return true;
            }
        }
        return false;
    }
}
