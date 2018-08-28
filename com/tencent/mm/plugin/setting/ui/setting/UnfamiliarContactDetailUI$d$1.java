package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d;

class UnfamiliarContactDetailUI$d$1 implements Runnable {
    final /* synthetic */ d mVn;

    UnfamiliarContactDetailUI$d$1(d dVar) {
        this.mVn = dVar;
    }

    public final void run() {
        if (this.mVn.mVi != null) {
            this.mVn.mVi.ds(this.mVn.mUT.mUN.size(), this.mVn.mVk);
            this.mVn.mUT.mUN.clear();
        }
    }
}
