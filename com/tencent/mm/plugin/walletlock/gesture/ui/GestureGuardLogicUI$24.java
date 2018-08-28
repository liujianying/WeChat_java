package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;

class GestureGuardLogicUI$24 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$24(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i2 == 0) {
            d.fy(SystemClock.elapsedRealtime());
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_toast_modified), 0).show();
            GestureGuardLogicUI.e(this.pHr);
        } else {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_err_runtime), 0).show();
        }
        GestureGuardLogicUI.b(this.pHr);
        GestureGuardLogicUI.d(this.pHr);
        return 0;
    }
}
