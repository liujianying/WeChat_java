package com.tencent.mm.plugin.wallet_core.ui.view;

import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.bp.a;

class WalletSuccPageAwardWidget$2 implements Runnable {
    final /* synthetic */ WalletSuccPageAwardWidget pAM;

    WalletSuccPageAwardWidget$2(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.pAM = walletSuccPageAwardWidget;
    }

    public final void run() {
        if (WalletSuccPageAwardWidget.d(this.pAM).getHeight() != this.pAM.getHeight()) {
            LayoutParams layoutParams = (LayoutParams) WalletSuccPageAwardWidget.d(this.pAM).getLayoutParams();
            layoutParams.width = WalletSuccPageAwardWidget.b(this.pAM).getWidth();
            layoutParams.height = WalletSuccPageAwardWidget.b(this.pAM).getHeight() - a.fromDPToPix(this.pAM.getContext(), 2);
            layoutParams.topMargin = a.fromDPToPix(this.pAM.getContext(), 1);
            layoutParams.bottomMargin = a.fromDPToPix(this.pAM.getContext(), 1);
            WalletSuccPageAwardWidget.d(this.pAM).setLayoutParams(layoutParams);
        }
    }
}
