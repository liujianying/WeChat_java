package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$24 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;

    WalletOfflineCoinPurseUI$24(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.lMe = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        Object[] objArr = new Object[1];
        k.bkO();
        k.bkR();
        objArr[0] = Integer.valueOf(i.bkN());
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", objArr);
        k.bkO();
        k.bkR();
        if (i.bkN() <= 0) {
            this.lMe.a(new m(((int) (System.currentTimeMillis() / 1000)), 10), true, false);
            return;
        }
        WalletOfflineCoinPurseUI.I(this.lMe);
    }
}
