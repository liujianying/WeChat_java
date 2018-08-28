package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.d;

class BankRemitBankcardInputUI$12 implements OnMenuItemClickListener {
    final /* synthetic */ BankRemitBankcardInputUI mve;

    BankRemitBankcardInputUI$12(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.mve = bankRemitBankcardInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "help click");
        BankRemitBankcardInputUI.a(this.mve, new d(this.mve.mController.tml, 1, false));
        BankRemitBankcardInputUI.a(this.mve).ofp = new 1(this);
        BankRemitBankcardInputUI.a(this.mve).ofq = new 2(this);
        this.mve.Wq();
        BankRemitBankcardInputUI.a(this.mve).bXO();
        h.mEJ.h(14673, new Object[]{Integer.valueOf(2)});
        return false;
    }
}
