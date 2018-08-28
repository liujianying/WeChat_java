package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.4;

class WalletSuccPageAwardWidget$4$1 implements Runnable {
    final /* synthetic */ NinePatchDrawable pAN;
    final /* synthetic */ 4 pAO;

    WalletSuccPageAwardWidget$4$1(4 4, NinePatchDrawable ninePatchDrawable) {
        this.pAO = 4;
        this.pAN = ninePatchDrawable;
    }

    public final void run() {
        WalletSuccPageAwardWidget.h(this.pAO.pAM).setImageDrawable(this.pAN);
        WalletSuccPageAwardWidget.h(this.pAO.pAM).setVisibility(0);
        WalletSuccPageAwardWidget.h(this.pAO.pAM).post(new 1(this));
    }
}
