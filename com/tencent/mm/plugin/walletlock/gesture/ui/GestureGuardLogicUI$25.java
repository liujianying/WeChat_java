package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.plugin.walletlock.gesture.ui.GestureGuardLogicUI.a;

class GestureGuardLogicUI$25 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;
    final /* synthetic */ a pHv;

    GestureGuardLogicUI$25(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.pHr = gestureGuardLogicUI;
        this.pHv = aVar;
    }

    public final void onDone() {
        GestureGuardLogicUI.f(this.pHr).postDelayed(new Runnable() {
            public final void run() {
                GestureGuardLogicUI.f(GestureGuardLogicUI$25.this.pHr).removeCallbacks(this);
                GestureGuardLogicUI$25.this.pHv.pHz.bRV();
                GestureGuardLogicUI.a(GestureGuardLogicUI$25.this.pHr, 16);
                GestureGuardLogicUI.g(GestureGuardLogicUI$25.this.pHr);
                GestureGuardLogicUI.h(GestureGuardLogicUI$25.this.pHr);
            }
        }, 500);
    }
}
