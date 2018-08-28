package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$14 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$14(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        if ((RechargeUI.f(this.mqE) != null && RechargeUI.f(this.mqE).getCount() > 0) || (RechargeUI.g(this.mqE) != null && RechargeUI.g(this.mqE).getCount() > 0)) {
            this.mqE.showDialog(1);
        }
    }
}
