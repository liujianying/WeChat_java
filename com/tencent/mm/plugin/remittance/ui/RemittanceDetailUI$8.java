package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceDetailUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceDetailUI mCf;

    RemittanceDetailUI$8(RemittanceDetailUI remittanceDetailUI) {
        this.mCf = remittanceDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.mCf.mController.tml, RemittanceDetailUI.d(this.mCf), false);
        return false;
    }
}
