package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class RechargeUI$17 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$17(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        RechargeUI.e(this.mqE).getFocus();
        if (RechargeUI.e(this.mqE).getInputRecord().bJt == 2) {
            RechargeUI.e(this.mqE).setInput(null);
        }
        if (bi.oW(RechargeUI.e(this.mqE).getText().toString())) {
            RechargeUI.e(this.mqE).mpd.showDropDown();
        }
        this.mqE.showVKB();
    }
}
