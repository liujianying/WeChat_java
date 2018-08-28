package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.walletlock.a.g;

class GestureGuardLogicUI$26 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$26(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i2 == 0) {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_toast_disabled), 0).show();
        } else {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_err_runtime), 0).show();
        }
        GestureGuardLogicUI.a(this.pHr, null);
        this.pHr.finish();
        return 0;
    }
}
