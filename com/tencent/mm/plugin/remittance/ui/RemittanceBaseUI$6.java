package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;

class RemittanceBaseUI$6 implements OnClickListener {
    final /* synthetic */ v mzA;
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$6(RemittanceBaseUI remittanceBaseUI, v vVar) {
        this.mzz = remittanceBaseUI;
        this.mzA = vVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!RemittanceBaseUI.a(this.mzz, this.mzA)) {
            this.mzz.a(this.mzA.bQa, this.mzz.cYO, this.mzz.mzk, this.mzA);
        }
    }
}
