package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.tools.k;

class BindMContactIntroUI$23 implements OnMenuItemClickListener {
    final /* synthetic */ BindMContactIntroUI eGe;
    final /* synthetic */ int eGh;

    BindMContactIntroUI$23(BindMContactIntroUI bindMContactIntroUI, int i) {
        this.eGe = bindMContactIntroUI;
        this.eGh = i;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        k kVar = new k(this.eGe.mController.tml);
        kVar.ofp = new 1(this);
        kVar.ofq = new 2(this);
        kVar.bEo();
        return false;
    }
}
