package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletIdCardCheckUI$3 implements OnClickListener {
    final /* synthetic */ WalletIdCardCheckUI phR;

    WalletIdCardCheckUI$3(WalletIdCardCheckUI walletIdCardCheckUI) {
        this.phR = walletIdCardCheckUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.phR.setResult(-1);
        this.phR.finish();
    }
}
