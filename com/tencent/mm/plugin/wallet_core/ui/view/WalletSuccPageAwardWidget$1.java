package com.tencent.mm.plugin.wallet_core.ui.view;

import android.widget.FrameLayout.LayoutParams;

class WalletSuccPageAwardWidget$1 implements Runnable {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$1(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void run() {
        if (WalletSuccPageAwardWidget.a(this.pAM).getHeight() != this.pAM.getHeight()) {
            LayoutParams layoutParams = (LayoutParams) WalletSuccPageAwardWidget.a(this.pAM).getLayoutParams();
            layoutParams.width = WalletSuccPageAwardWidget.b(this.pAM).getWidth();
            layoutParams.height = WalletSuccPageAwardWidget.b(this.pAM).getHeight();
            WalletSuccPageAwardWidget.a(this.pAM).setLayoutParams(layoutParams);
        }
        WalletSuccPageAwardWidget.c(this.pAM);
    }
}
