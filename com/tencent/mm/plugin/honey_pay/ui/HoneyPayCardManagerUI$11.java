package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayCardManagerUI$11 implements a {
    final /* synthetic */ HoneyPayCardManagerUI kkT;
    final /* synthetic */ i kkW;

    HoneyPayCardManagerUI$11(HoneyPayCardManagerUI honeyPayCardManagerUI, i iVar) {
        this.kkT = honeyPayCardManagerUI;
        this.kkW = iVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        boolean z = true;
        MMSwitchBtn a = HoneyPayCardManagerUI.a(this.kkT);
        if (this.kkW.bWA == 1) {
            z = false;
        }
        a.setCheck(z);
    }
}
