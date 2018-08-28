package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$5 implements OnClickListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$5(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletPayUI", "click cancel pay");
        if (!(this.pgT.mCn == null || this.pgT.mCZ == null || this.pgT.mCZ.ppf == null || this.pgT.mCZ.ppf.size() <= 0)) {
            if (this.pgT.mCn.bVY == 8) {
                h.mEJ.h(15368, new Object[]{Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) this.pgT.mCZ.ppf.get(0)).bOe});
            } else {
                h.mEJ.h(15368, new Object[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2), ((Commodity) this.pgT.mCZ.ppf.get(0)).bOe});
            }
        }
        this.pgT.finish();
    }
}
