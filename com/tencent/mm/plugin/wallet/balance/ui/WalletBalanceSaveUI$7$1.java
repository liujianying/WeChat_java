package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.7;

class WalletBalanceSaveUI$7$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 7 paO;

    WalletBalanceSaveUI$7$1(7 7, Bitmap bitmap) {
        this.paO = 7;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.paO.paK.oZH != null && this.paO.paj != null && this.paO.paj.getTag() != null && this.paO.paj.getTag().equals(this.paO.paK.oZH.field_bindSerial)) {
            this.paO.paj.setImageBitmap(this.abc);
        }
    }
}
