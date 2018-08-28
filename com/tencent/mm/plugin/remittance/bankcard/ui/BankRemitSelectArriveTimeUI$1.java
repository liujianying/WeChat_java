package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BankRemitSelectArriveTimeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitSelectArriveTimeUI mws;

    BankRemitSelectArriveTimeUI$1(BankRemitSelectArriveTimeUI bankRemitSelectArriveTimeUI) {
        this.mws = bankRemitSelectArriveTimeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mws.finish();
        return false;
    }
}
