package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.c;

class WalletOfflineCoinPurseUI$17 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ ImageView hIK;
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ Integer lMt;

    WalletOfflineCoinPurseUI$17(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, Integer num, Bitmap bitmap, ImageView imageView) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMt = num;
        this.abc = bitmap;
        this.hIK = imageView;
    }

    public final void run() {
        int intValue = this.lMt.intValue();
        this.hIK.setImageBitmap(c.a(this.abc, intValue, intValue, true, false));
    }
}
