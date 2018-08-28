package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;
import org.json.JSONObject;

class WalletBalanceManagerUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ List jLK;
    final /* synthetic */ WalletBalanceManagerUI pax;
    final /* synthetic */ JSONObject paz;

    WalletBalanceManagerUI$3(WalletBalanceManagerUI walletBalanceManagerUI, JSONObject jSONObject, List list) {
        this.pax = walletBalanceManagerUI;
        this.paz = jSONObject;
        this.jLK = list;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.pax.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return false;
    }
}
