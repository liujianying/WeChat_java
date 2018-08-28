package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.4.1;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletSuccPageAwardWidget$4$1$1 implements Runnable {
    final /* synthetic */ 1 pAP;

    WalletSuccPageAwardWidget$4$1$1(1 1) {
        this.pAP = 1;
    }

    public final void run() {
        LayoutParams layoutParams = WalletSuccPageAwardWidget.h(this.pAP.pAO.pAM).getLayoutParams();
        layoutParams.height = WalletSuccPageAwardWidget.b(this.pAP.pAO.pAM).getHeight();
        layoutParams.width = WalletSuccPageAwardWidget.b(this.pAP.pAO.pAM).getWidth();
        WalletSuccPageAwardWidget.h(this.pAP.pAO.pAM).setLayoutParams(layoutParams);
        this.pAP.pAO.pAM.findViewById(f.order_info_tinyapp_splitter_1).setVisibility(8);
        this.pAP.pAO.pAM.findViewById(f.order_info_tinyapp_splitter_2).setVisibility(8);
    }
}
