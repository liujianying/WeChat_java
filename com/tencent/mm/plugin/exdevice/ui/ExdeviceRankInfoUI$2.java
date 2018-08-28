package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMPullDownView.c;

class ExdeviceRankInfoUI$2 implements c {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$2(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final boolean aCi() {
        View childAt = ExdeviceRankInfoUI.q(this.iFG).getChildAt(ExdeviceRankInfoUI.q(this.iFG).getChildCount() - 1);
        int count = ExdeviceRankInfoUI.q(this.iFG).getCount();
        if (count <= 0 || childAt == null || childAt.getBottom() > ExdeviceRankInfoUI.q(this.iFG).getHeight() || ExdeviceRankInfoUI.q(this.iFG).getLastVisiblePosition() != count - 1) {
            return false;
        }
        return true;
    }
}
