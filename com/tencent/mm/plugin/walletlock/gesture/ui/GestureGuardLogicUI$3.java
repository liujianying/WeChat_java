package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.walletlock.a.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import java.util.List;

class GestureGuardLogicUI$3 implements a {
    final /* synthetic */ GestureGuardLogicUI pHr;
    final /* synthetic */ List pHt;

    GestureGuardLogicUI$3(GestureGuardLogicUI gestureGuardLogicUI, List list) {
        this.pHr = gestureGuardLogicUI;
        this.pHt = list;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (i2 == 0) {
            GestureGuardLogicUI.i(this.pHr);
            GestureGuardLogicUI.j(this.pHr);
            d.bRN();
            d.bRH();
            d.bRJ();
            GestureGuardLogicUI.a(this.pHr, this.pHt);
            GestureGuardLogicUI.a(this.pHr, 1);
            GestureGuardLogicUI.h(this.pHr);
        } else if (i2 == -3) {
            GestureGuardLogicUI.k(this.pHr);
            GestureGuardLogicUI.a(this.pHr, 2);
            GestureGuardLogicUI.h(this.pHr);
        } else {
            Toast.makeText(this.pHr, this.pHr.getString(g.gesture_pwd_err_srv_comm_failed), 0).show();
        }
        return 0;
    }
}
