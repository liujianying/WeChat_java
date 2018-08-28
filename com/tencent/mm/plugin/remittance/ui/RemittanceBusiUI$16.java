package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBusiUI$16 implements OnClickListener {
    final /* synthetic */ RemittanceBusiUI mBt;
    final /* synthetic */ i mBx;

    RemittanceBusiUI$16(RemittanceBusiUI remittanceBusiUI, i iVar) {
        this.mBt = remittanceBusiUI;
        this.mBx = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.RemittanceBusiUI", "goto h5: %s", new Object[]{this.mBx.mxj.rkL.hUt});
        e.l(this.mBt.mController.tml, this.mBx.mxj.rkL.hUt, false);
    }
}
