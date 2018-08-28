package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.28.1;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$28$1$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String lMy;
    final /* synthetic */ 1 lMz;

    WalletOfflineCoinPurseUI$28$1$1(1 1, String str, Bitmap bitmap) {
        this.lMz = 1;
        this.lMy = str;
        this.abc = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{this.lMy, this.lMz.lMv});
        if (WalletOfflineCoinPurseUI.J(this.lMz.lMx.lMe).containsKey(this.lMy)) {
            int intValue = ((Integer) WalletOfflineCoinPurseUI.J(this.lMz.lMx.lMe).get(this.lMy)).intValue();
            if (this.lMz.lMw.getItem(intValue) != null) {
                this.lMz.lMw.getItem(intValue).setIcon(new BitmapDrawable(c.a(this.abc, this.lMz.lMx.lMe.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), this.lMz.lMx.lMe.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false)));
                this.lMz.lMx.eRB.cAK();
            }
        }
    }
}
