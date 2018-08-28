package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsAddressUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsAddressUI ulS;

    SnsAddressUI$2(SnsAddressUI snsAddressUI) {
        this.ulS = snsAddressUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulS.finish();
        if (!this.ulS.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            this.ulS.moveTaskToBack(true);
        }
        return true;
    }
}
