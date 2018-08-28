package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.16;

class WalletBalanceFetchUI$16$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 16 pak;

    WalletBalanceFetchUI$16$1(16 16, Bitmap bitmap) {
        this.pak = 16;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.pak.pad.oZH != null && this.pak.paj != null && this.pak.paj.getTag() != null && this.pak.paj.getTag().equals(this.pak.pad.oZH.field_bindSerial)) {
            this.pak.paj.setImageBitmap(this.abc);
        }
    }
}
