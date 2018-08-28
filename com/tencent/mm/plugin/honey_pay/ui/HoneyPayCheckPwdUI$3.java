package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.honey_pay.a.d;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.wallet_core.c.h.a;

class HoneyPayCheckPwdUI$3 implements a {
    final /* synthetic */ HoneyPayCheckPwdUI kld;
    final /* synthetic */ d kle;

    HoneyPayCheckPwdUI$3(HoneyPayCheckPwdUI honeyPayCheckPwdUI, d dVar) {
        this.kld = honeyPayCheckPwdUI;
        this.kle = dVar;
    }

    public final void g(int i, int i2, String str, l lVar) {
        HoneyPayCheckPwdUI.a(this.kld, this.kle.kjD.rHg);
        if (this.kle.kjD.rHh != null) {
            c.a(this.kld, this.kle.kjD.rHh, new 1(this));
            this.kld.bfe();
            return;
        }
        HoneyPayCheckPwdUI.d(this.kld);
    }
}
