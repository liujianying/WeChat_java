package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.12;

class WalletLqtSaveFetchUI$12$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ 12 pck;

    WalletLqtSaveFetchUI$12$1(12 12, Bitmap bitmap) {
        this.pck = 12;
        this.abc = bitmap;
    }

    public final void run() {
        if (WalletLqtSaveFetchUI.d(this.pck.pcc) != null && WalletLqtSaveFetchUI.e(this.pck.pcc) != null && WalletLqtSaveFetchUI.e(this.pck.pcc).getTag() != null && WalletLqtSaveFetchUI.e(this.pck.pcc).getTag().equals(WalletLqtSaveFetchUI.d(this.pck.pcc).field_bindSerial)) {
            WalletLqtSaveFetchUI.e(this.pck.pcc).setImageBitmap(this.abc);
        }
    }
}
