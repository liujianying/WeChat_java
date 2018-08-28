package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.wallet_core.c.p;
import com.tencent.mm.plugin.wallet_core.model.x;

class WalletSwitchWalletCurrencyUI$1 implements OnItemClickListener {
    final /* synthetic */ WalletSwitchWalletCurrencyUI pyD;

    WalletSwitchWalletCurrencyUI$1(WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI) {
        this.pyD = walletSwitchWalletCurrencyUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x zv = WalletSwitchWalletCurrencyUI.a(this.pyD).zv(i);
        WalletSwitchWalletCurrencyUI.a(this.pyD, WalletSwitchWalletCurrencyUI.a(this.pyD).pyE);
        if (zv == null) {
            return;
        }
        if (WalletSwitchWalletCurrencyUI.b(this.pyD) == null || !WalletSwitchWalletCurrencyUI.b(this.pyD).field_wallet_tpa_country.equals(zv.field_wallet_tpa_country)) {
            WalletSwitchWalletCurrencyUI.b(this.pyD, zv);
            WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = this.pyD;
            String str = zv.field_wallet_tpa_country;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = " + str);
            walletSwitchWalletCurrencyUI.a(new p(str), true, false);
        }
    }
}
