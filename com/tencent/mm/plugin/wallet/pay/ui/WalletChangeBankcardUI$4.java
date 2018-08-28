package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class WalletChangeBankcardUI$4 implements OnItemClickListener {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$4(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.pfC.zg(i);
    }
}
