package com.tencent.mm.plugin.wallet.balance.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aa.a;

class WalletBalanceManagerUI$11 implements OnClickListener {
    final /* synthetic */ WalletBalanceManagerUI pax;

    WalletBalanceManagerUI$11(WalletBalanceManagerUI walletBalanceManagerUI) {
        this.pax = walletBalanceManagerUI;
    }

    public final void onClick(View view) {
        g.Ek();
        g.Ei().DT().a(a.sXO, Integer.valueOf(-1));
        Bundle bundle = new Bundle();
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putString("realname_verify_process_jump_plugin", "wallet");
        bundle.putString("realname_verify_process_jump_activity", "com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI");
        bundle.putInt("entry_scene", 1009);
        com.tencent.mm.wallet_core.a.a(this.pax, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
    }
}
