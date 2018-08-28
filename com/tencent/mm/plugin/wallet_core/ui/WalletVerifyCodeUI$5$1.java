package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI.5;

class WalletVerifyCodeUI$5$1 implements OnClickListener {
    final /* synthetic */ int pyU;
    final /* synthetic */ 5 pyV;

    WalletVerifyCodeUI$5$1(5 5, int i) {
        this.pyV = 5;
        this.pyU = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pyV.pyT.bQE();
        h.mEJ.h(15443, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(this.pyU)});
    }
}
