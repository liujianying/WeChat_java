package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class k$3 implements OnCancelListener {
    final /* synthetic */ Dialog nmd;

    k$3(Dialog dialog) {
        this.nmd = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletIdCardTip", "SnsLuckyMoneyNewYearTipsUI onCancel");
        if (this.nmd != null && this.nmd.isShowing()) {
            this.nmd.dismiss();
        }
    }
}
