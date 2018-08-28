package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.wallet_core.ui.e;

class RemittanceBaseUI$17 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$17(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        e.l(this.mzz.mController.tml, this.mzz.mzm, false);
        return false;
    }
}
