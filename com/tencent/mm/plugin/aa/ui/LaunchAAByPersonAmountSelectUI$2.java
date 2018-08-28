package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class LaunchAAByPersonAmountSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;

    LaunchAAByPersonAmountSelectUI$2(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.eDf = launchAAByPersonAmountSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (LaunchAAByPersonAmountSelectUI.c(this.eDf) == null || LaunchAAByPersonAmountSelectUI.c(this.eDf).size() <= 0) {
            this.eDf.finish();
        } else {
            h.a(this.eDf, this.eDf.getString(i.aa_select_contact_back_confirm), null, this.eDf.getString(i.aa_select_contact_save), this.eDf.getString(i.aa_select_contact_not_save), false, new 1(this), new 2(this));
        }
        return true;
    }
}
