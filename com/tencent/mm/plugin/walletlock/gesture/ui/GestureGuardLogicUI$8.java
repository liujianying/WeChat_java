package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class GestureGuardLogicUI$8 implements OnCancelListener {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$8(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GestureGuardLogicUI.l(this.pHr)[GestureGuardLogicUI.m(this.pHr)].pHz.bRV();
        if (GestureGuardLogicUI.p(this.pHr) != null && !GestureGuardLogicUI.p(this.pHr).aBS) {
            g.DF().c(GestureGuardLogicUI.p(this.pHr));
        }
    }
}
