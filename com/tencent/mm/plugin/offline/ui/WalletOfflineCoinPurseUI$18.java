package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;

class WalletOfflineCoinPurseUI$18 implements OnItemClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI lMe;
    final /* synthetic */ int lMu;

    WalletOfflineCoinPurseUI$18(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, int i) {
        this.lMe = walletOfflineCoinPurseUI;
        this.lMu = i;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.lMe.dismissDialog(this.lMu);
        WalletOfflineCoinPurseUI.un(i);
        if (this.lMu == 1) {
            String str = (String) WalletOfflineCoinPurseUI.C(this.lMe).get(i);
            if (!TextUtils.isEmpty(str) && !str.equals(WalletOfflineCoinPurseUI.D(this.lMe))) {
                WalletOfflineCoinPurseUI.a(this.lMe, str);
                a.Ja(WalletOfflineCoinPurseUI.D(this.lMe));
                k.bkO();
                k.bkQ().lIF = WalletOfflineCoinPurseUI.D(this.lMe);
                this.lMe.blo();
                WalletOfflineCoinPurseUI.E(this.lMe);
                WalletOfflineCoinPurseUI.F(this.lMe);
            }
        }
    }
}
