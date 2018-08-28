package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.4;

class UnfamiliarContactDetailUI$4$1 implements Runnable {
    final /* synthetic */ 4 mUV;

    UnfamiliarContactDetailUI$4$1(4 4) {
        this.mUV = 4;
    }

    public final void run() {
        UnfamiliarContactDetailUI.e(this.mUV.mUT).RR.notifyChanged();
        UnfamiliarContactDetailUI.c(this.mUV.mUT, false);
    }
}
