package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RemittanceBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RemittanceBaseUI mzz;

    RemittanceBaseUI$1(RemittanceBaseUI remittanceBaseUI) {
        this.mzz = remittanceBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (this.mzz.fdx == 1 || this.mzz.fdx == 6) {
            this.mzz.brn();
            this.mzz.finish();
        } else if (this.mzz.fdx == 2 || this.mzz.fdx == 5) {
            this.mzz.finish();
        } else {
            this.mzz.brw();
        }
        this.mzz.bro();
        return true;
    }
}
