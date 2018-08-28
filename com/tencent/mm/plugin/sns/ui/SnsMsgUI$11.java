package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.ui.base.h;

class SnsMsgUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$11(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.nYl.mController.tml, this.nYl.getString(i$j.sns_msg_clear_mgslist), "", new 1(this), null);
        return true;
    }
}
