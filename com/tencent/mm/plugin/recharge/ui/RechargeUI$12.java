package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$12 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$12(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        if (RechargeUI.b(this.mqE) && RechargeUI.c(this.mqE)) {
            RechargeUI.d(this.mqE);
        }
    }
}
