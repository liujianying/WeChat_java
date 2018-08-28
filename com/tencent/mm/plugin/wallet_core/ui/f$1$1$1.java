package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.wallet_core.ui.f.1.1;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class f$1$1$1 implements Runnable {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ String lMy;
    final /* synthetic */ 1 vLT;

    f$1$1$1(1 1, String str, Bitmap bitmap) {
        this.vLT = 1;
        this.lMy = str;
        this.abc = bitmap;
    }

    public final void run() {
        x.i("MicroMsg.WalletBankcardBottomSheetHelper", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", new Object[]{this.lMy, this.vLT.vLS});
        if (this.vLT.psP.vLQ.containsKey(this.lMy)) {
            int intValue = ((Integer) this.vLT.psP.vLQ.get(this.lMy)).intValue();
            if (this.vLT.lMw.getItem(intValue) != null) {
                this.vLT.lMw.getItem(intValue).setIcon(new BitmapDrawable(c.a(this.abc, ad.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), ad.getResources().getDimensionPixelOffset(d.wallet_offline_bank_logo_width), true, false)));
                this.vLT.psP.vLR.cAK();
            }
        }
    }
}
