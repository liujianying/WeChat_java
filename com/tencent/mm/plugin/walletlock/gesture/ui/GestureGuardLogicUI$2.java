package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

class GestureGuardLogicUI$2 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;
    final /* synthetic */ PatternLockView pHs;

    GestureGuardLogicUI$2(GestureGuardLogicUI gestureGuardLogicUI, PatternLockView patternLockView) {
        this.pHr = gestureGuardLogicUI;
        this.pHs = patternLockView;
    }

    public final void onDone() {
        this.pHs.bRV();
        this.pHs.setEnableInput(true);
    }
}
