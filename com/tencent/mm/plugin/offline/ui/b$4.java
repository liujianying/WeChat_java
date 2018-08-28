package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class b$4 implements OnClickListener {
    final /* synthetic */ Activity mr;

    b$4(Activity activity) {
        this.mr = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.mr instanceof WalletOfflineCoinPurseUI) {
            ((WalletOfflineCoinPurseUI) this.mr).lMa = false;
        }
        dialogInterface.dismiss();
    }
}
