package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class GestureGuardLogicUI$4 implements OnCancelListener {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$4(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GestureGuardLogicUI.l(this.pHr)[GestureGuardLogicUI.m(this.pHr)].pHz.bRV();
        if (GestureGuardLogicUI.n(this.pHr) != null && !GestureGuardLogicUI.n(this.pHr).aBS) {
            g.DF().c(GestureGuardLogicUI.n(this.pHr));
        }
    }
}
