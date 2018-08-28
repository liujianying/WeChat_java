package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.sdk.platformtools.ah;

class WalletBalanceFetchUI$16 implements a {
    final /* synthetic */ WalletBalanceFetchUI pad;
    final /* synthetic */ ImageView paj;

    WalletBalanceFetchUI$16(WalletBalanceFetchUI walletBalanceFetchUI, ImageView imageView) {
        this.pad = walletBalanceFetchUI;
        this.paj = imageView;
    }

    public final void m(String str, Bitmap bitmap) {
        ah.A(new 1(this, bitmap));
    }
}
