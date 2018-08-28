package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.ui.base.n.d;
import java.util.List;

class WalletLqtSaveFetchUI$14 implements d {
    final /* synthetic */ com.tencent.mm.ui.widget.a.d eRB;
    final /* synthetic */ List kkU;
    final /* synthetic */ WalletLqtSaveFetchUI pcc;

    WalletLqtSaveFetchUI$14(WalletLqtSaveFetchUI walletLqtSaveFetchUI, com.tencent.mm.ui.widget.a.d dVar, List list) {
        this.pcc = walletLqtSaveFetchUI;
        this.eRB = dVar;
        this.kkU = list;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.eRB != null) {
            this.eRB.bzW();
            if (i < this.kkU.size()) {
                WalletLqtSaveFetchUI.a(this.pcc, ((Bankcard) this.kkU.get(i)).field_bindSerial);
                WalletLqtSaveFetchUI.h(this.pcc);
            } else if (WalletLqtSaveFetchUI.g(this.pcc) == 1) {
                WalletLqtSaveFetchUI.i(this.pcc);
            } else if (WalletLqtSaveFetchUI.g(this.pcc) == 2) {
                WalletLqtSaveFetchUI.i(this.pcc);
            }
        }
    }
}
