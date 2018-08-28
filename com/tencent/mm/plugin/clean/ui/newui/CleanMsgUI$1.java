package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanMsgUI hTx;

    CleanMsgUI$1(CleanMsgUI cleanMsgUI) {
        this.hTx = cleanMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hTx.finish();
        return false;
    }
}
