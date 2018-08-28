package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$4 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$4(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (!PhoneRechargeUI.a(this.mqa, PhoneRechargeUI.j(this.mqa).pdR, PhoneRechargeUI.j(this.mqa).dzE)) {
            x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.b(this.mqa, PhoneRechargeUI.j(this.mqa).url)});
            PhoneRechargeUI.c(this.mqa, r0);
        }
    }
}
