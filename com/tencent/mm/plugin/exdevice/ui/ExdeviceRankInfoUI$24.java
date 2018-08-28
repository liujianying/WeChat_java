package com.tencent.mm.plugin.exdevice.ui;

import android.view.MotionEvent;
import com.tencent.mm.ui.base.MMPullDownView.a;

class ExdeviceRankInfoUI$24 implements a {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$24(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        ExdeviceRankInfoUI exdeviceRankInfoUI = this.iFG;
        if (ExdeviceRankInfoUI.a(this.iFG) == null || ExdeviceRankInfoUI.a(this.iFG).size() == 0) {
            z = false;
        } else {
            z = true;
        }
        ExdeviceRankInfoUI.b(exdeviceRankInfoUI, z);
        return false;
    }
}
