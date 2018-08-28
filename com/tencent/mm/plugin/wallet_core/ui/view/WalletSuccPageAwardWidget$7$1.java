package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.7;

class WalletSuccPageAwardWidget$7$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 7 pAQ;

    WalletSuccPageAwardWidget$7$1(7 7, Bitmap bitmap) {
        this.pAQ = 7;
        this.abc = bitmap;
    }

    public final void run() {
        WalletSuccPageAwardWidget.r(this.pAQ.pAM).setScaleType(ScaleType.CENTER_CROP);
        WalletSuccPageAwardWidget.r(this.pAQ.pAM).setImageBitmap(this.abc);
    }
}
