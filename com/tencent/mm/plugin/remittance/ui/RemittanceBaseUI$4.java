package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBaseUI$4 implements OnClickListener {
    final /* synthetic */ v mzA;
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$4(RemittanceBaseUI remittanceBaseUI, v vVar) {
        this.mzz = remittanceBaseUI;
        this.mzA = vVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RemittanceBaseUI", "goto h5: %s", new Object[]{this.mzA.cao.hUt});
        e.l(this.mzz.mController.tml, this.mzA.cao.hUt, false);
    }
}
