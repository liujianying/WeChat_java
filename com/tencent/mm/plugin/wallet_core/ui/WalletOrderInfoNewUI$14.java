package com.tencent.mm.plugin.wallet_core.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletOrderInfoNewUI$14 implements Runnable {
    final /* synthetic */ ImageView mAs;
    final /* synthetic */ WalletOrderInfoNewUI pwh;

    WalletOrderInfoNewUI$14(WalletOrderInfoNewUI walletOrderInfoNewUI, ImageView imageView) {
        this.pwh = walletOrderInfoNewUI;
        this.mAs = imageView;
    }

    public final void run() {
        ViewGroup viewGroup = (ViewGroup) this.pwh.findViewById(f.root_layout);
        LayoutParams layoutParams = this.mAs.getLayoutParams();
        layoutParams.width = viewGroup.getWidth();
        layoutParams.height = viewGroup.getHeight();
        this.mAs.setLayoutParams(layoutParams);
    }
}
