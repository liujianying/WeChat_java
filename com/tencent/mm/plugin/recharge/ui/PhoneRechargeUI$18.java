package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$18 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$18(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (PhoneRechargeUI.f(this.mqa) != null) {
            PhoneRechargeUI.g(this.mqa);
        } else {
            x.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
        PhoneRechargeUI.h(this.mqa).setVisibility(8);
    }
}
