package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;

class SnsMsgUI$5 implements n$d {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$5(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                SnsMsgUI.a(this.nYl, this.nYl.nJg);
                return;
            case 1:
                SnsMsgUI.n(this.nYl);
                return;
            case 2:
                SnsMsgUI.a(this.nYl, false);
                return;
            default:
                return;
        }
    }
}
