package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;

class RechargeUI$3 implements OnCancelListener {
    final /* synthetic */ l bFp;
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$3(RechargeUI rechargeUI, l lVar) {
        this.mqE = rechargeUI;
        this.bFp = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Ek();
        g.Eh().dpP.c(this.bFp);
    }
}
