package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.aa;

class RemittanceOSUI$2 implements OnClickListener {
    final /* synthetic */ RemittanceOSUI mCX;
    final /* synthetic */ aa mCY;

    RemittanceOSUI$2(RemittanceOSUI remittanceOSUI, aa aaVar) {
        this.mCX = remittanceOSUI;
        this.mCY = aaVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.mCX.KB(this.mCY.mxv);
    }
}
