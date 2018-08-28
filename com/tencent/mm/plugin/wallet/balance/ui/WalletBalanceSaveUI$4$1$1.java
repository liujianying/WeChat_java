package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4.1;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBalanceSaveUI$4$1$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String lMy;
    final /* synthetic */ 1 paN;

    WalletBalanceSaveUI$4$1$1(1 1, String str, Bitmap bitmap) {
        this.paN = 1;
        this.lMy = str;
        this.abc = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{this.lMy, this.paN.lMv});
        if (WalletBalanceSaveUI.d(this.paN.paM.paK).containsKey(this.lMy)) {
            int intValue = ((Integer) WalletBalanceSaveUI.d(this.paN.paM.paK).get(this.lMy)).intValue();
            if (this.paN.lMw.getItem(intValue) != null) {
                this.paN.lMw.getItem(intValue).setIcon(new BitmapDrawable(c.a(this.abc, this.paN.paM.paK.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), this.paN.paM.paK.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false)));
                this.paN.paM.paL.cAK();
            }
        }
    }
}
