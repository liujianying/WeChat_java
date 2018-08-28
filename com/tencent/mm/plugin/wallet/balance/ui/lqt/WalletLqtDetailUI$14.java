package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletLqtDetailUI$14 implements Runnable {
    final /* synthetic */ WalletLqtDetailUI pbs;

    WalletLqtDetailUI$14(WalletLqtDetailUI walletLqtDetailUI) {
        this.pbs = walletLqtDetailUI;
    }

    public final void run() {
        LayoutParams layoutParams = (LayoutParams) WalletLqtDetailUI.d(this.pbs).getLayoutParams();
        layoutParams.topMargin = Math.max(((this.pbs.findViewById(f.lqt_detail_root).getHeight() - this.pbs.findViewById(f.lqt_detail_inner_container).getBottom()) - a.fromDPToPix(this.pbs, 20)) - a.fromDPToPix(this.pbs, 20), a.fromDPToPix(this.pbs, 50));
        WalletLqtDetailUI.d(this.pbs).setLayoutParams(layoutParams);
        WalletLqtDetailUI.d(this.pbs).setVisibility(0);
    }
}
