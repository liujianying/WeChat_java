package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayCardManagerUI$15 implements a {
    final /* synthetic */ HoneyPayCardManagerUI kkT;

    HoneyPayCardManagerUI$15(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        this.kkT = honeyPayCardManagerUI;
    }

    public final void g(int i, int i2, String str, l lVar) {
        HoneyPayCardManagerUI.a(this.kkT, HoneyPayCardManagerUI.b(this.kkT));
        if (HoneyPayCardManagerUI.c(this.kkT) != null) {
            HoneyPayCardManagerUI.a(this.kkT, HoneyPayCardManagerUI.adX(HoneyPayCardManagerUI.c(this.kkT).scY));
        }
        HoneyPayCardManagerUI.d(this.kkT);
    }
}
