package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.tools.k;

class BindQQUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ BindQQUI eHn;

    BindQQUI$7(BindQQUI bindQQUI) {
        this.eHn = bindQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        k kVar = new k(this.eHn.mController.tml);
        kVar.ofp = new 1(this);
        kVar.ofq = new 2(this);
        kVar.bEo();
        return false;
    }
}
