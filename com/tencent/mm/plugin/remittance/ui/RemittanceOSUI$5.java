package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.aa;

class RemittanceOSUI$5 implements OnClickListener {
    final /* synthetic */ RemittanceOSUI mCX;
    final /* synthetic */ aa mCY;

    RemittanceOSUI$5(RemittanceOSUI remittanceOSUI, aa aaVar) {
        this.mCX = remittanceOSUI;
        this.mCY = aaVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mCX.KC(this.mCY.myC);
    }
}
