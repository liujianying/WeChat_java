package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BankRemitBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitBaseUI mvo;

    BankRemitBaseUI$1(BankRemitBaseUI bankRemitBaseUI) {
        this.mvo = bankRemitBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (BankRemitBaseUI.a(this.mvo)) {
            this.mvo.YC();
            this.mvo.showDialog(1000);
        } else {
            this.mvo.finish();
        }
        return true;
    }
}
