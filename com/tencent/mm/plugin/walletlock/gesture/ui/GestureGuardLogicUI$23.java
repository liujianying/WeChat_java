package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.walletlock.a$g;

class GestureGuardLogicUI$23 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$23(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        GestureGuardLogicUI.b(this.pHr);
        GestureGuardLogicUI.d(this.pHr);
        if (i2 == 0) {
            Toast.makeText(this.pHr, this.pHr.getString(a$g.gesture_pwd_toast_enabled), 0).show();
            GestureGuardLogicUI.a(this.pHr, -1, 0, "open gesture ok");
        } else {
            Toast.makeText(this.pHr, this.pHr.getString(a$g.gesture_pwd_err_runtime), 0).show();
            GestureGuardLogicUI.a(this.pHr, -1, -1, "open gesture failed");
        }
        return 0;
    }
}
