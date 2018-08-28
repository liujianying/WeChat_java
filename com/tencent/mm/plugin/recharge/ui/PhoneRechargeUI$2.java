package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class PhoneRechargeUI$2 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$2(PhoneRechargeUI phoneRechargeUI, l lVar) {
        this.mqa = phoneRechargeUI;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.bFp);
    }
}
