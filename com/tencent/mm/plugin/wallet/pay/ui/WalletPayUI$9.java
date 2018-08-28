package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WalletPayUI$9 implements OnCancelListener {
    final /* synthetic */ WalletPayUI pgT;

    WalletPayUI$9(WalletPayUI walletPayUI) {
        this.pgT = walletPayUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletPayUI", "WalletPwdDialog event2 %s", bi.cjd().toString());
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.pgT.eWo = null;
        this.pgT.oZD = null;
        if (this.pgT.bbR()) {
            this.pgT.finish();
        }
        this.pgT.pfB = null;
    }
}
