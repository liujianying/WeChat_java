package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$8 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;
    final /* synthetic */ String val$url;

    PhoneRechargeUI$8(PhoneRechargeUI phoneRechargeUI, String str) {
        this.mqa = phoneRechargeUI;
        this.val$url = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.b(this.mqa, this.val$url)});
        PhoneRechargeUI.c(this.mqa, r0);
    }
}
