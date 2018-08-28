package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;

class RemittanceBaseUI$13 implements OnClickListener {
    final /* synthetic */ String mzB;
    final /* synthetic */ v mzC;
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$13(RemittanceBaseUI remittanceBaseUI, String str, v vVar) {
        this.mzz = remittanceBaseUI;
        this.mzB = str;
        this.mzC = vVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mzz.a(this.mzB, this.mzz.cYO, this.mzz.mzk, this.mzC);
    }
}
