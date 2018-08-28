package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.walletlock.a.g;

class GestureGuardLogicUI$21 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;

    GestureGuardLogicUI$21(GestureGuardLogicUI gestureGuardLogicUI) {
        this.pHr = gestureGuardLogicUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i2 == 0) {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_toast_modified), 0).show();
            h.mEJ.h(11474, new Object[0]);
        } else {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_err_runtime), 0).show();
        }
        GestureGuardLogicUI.b(this.pHr);
        GestureGuardLogicUI.d(this.pHr);
        this.pHr.finish();
        return 0;
    }
}
