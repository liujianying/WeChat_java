package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.1;

class RemittanceDetailUI$1$1 implements OnClickListener {
    final /* synthetic */ ne mCg;
    final /* synthetic */ 1 mCh;

    RemittanceDetailUI$1$1(1 1, ne neVar) {
        this.mCh = 1;
        this.mCg = neVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        l uVar = new u(this.mCg.bYf.bOe, this.mCg.bYf.bXz, this.mCg.bYf.bYg, "refuse", this.mCg.bYf.bYh, this.mCg.bYf.bYi);
        uVar.dox = "RemittanceProcess";
        this.mCh.mCf.a(uVar, true, true);
    }
}
