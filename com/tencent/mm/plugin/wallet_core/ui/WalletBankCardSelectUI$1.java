package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.ui.base.sortview.d;

class WalletBankCardSelectUI$1 implements OnItemClickListener {
    final /* synthetic */ WalletBankCardSelectUI psM;

    WalletBankCardSelectUI$1(WalletBankCardSelectUI walletBankCardSelectUI) {
        this.psM = walletBankCardSelectUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        d dVar = (d) adapterView.getAdapter().getItem(i);
        WalletBankCardSelectUI walletBankCardSelectUI = this.psM;
        a aVar = (a) dVar.data;
        if (aVar != null) {
            walletBankCardSelectUI.YC();
            Intent intent = new Intent();
            intent.putExtra("bank_name", aVar.lNT);
            walletBankCardSelectUI.setResult(-1, intent);
            walletBankCardSelectUI.finish();
        }
    }
}
