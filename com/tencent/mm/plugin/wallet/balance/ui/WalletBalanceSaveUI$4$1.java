package com.tencent.mm.plugin.wallet.balance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.4;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.l;

class WalletBalanceSaveUI$4$1 implements a {
    final /* synthetic */ String lMv;
    final /* synthetic */ l lMw;
    final /* synthetic */ 4 paM;

    WalletBalanceSaveUI$4$1(4 4, String str, l lVar) {
        this.paM = 4;
        this.lMv = str;
        this.lMw = lVar;
    }

    public final void m(String str, Bitmap bitmap) {
        ah.A(new 1(this, str, bitmap));
    }
}
