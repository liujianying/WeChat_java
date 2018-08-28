package com.tencent.mm.plugin.collect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;

class CollectCreateQRCodeUI$5 implements OnClickListener {
    final /* synthetic */ CollectCreateQRCodeUI hXF;
    final /* synthetic */ m hXI;

    CollectCreateQRCodeUI$5(CollectCreateQRCodeUI collectCreateQRCodeUI, m mVar) {
        this.hXF = collectCreateQRCodeUI;
        this.hXI = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!bi.oW(this.hXI.hUt)) {
            x.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", new Object[]{this.hXI.hUt});
            e.l(this.hXF.mController.tml, this.hXI.hUt, true);
        }
    }
}
