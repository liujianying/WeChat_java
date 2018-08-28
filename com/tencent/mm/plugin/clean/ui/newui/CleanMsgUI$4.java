package com.tencent.mm.plugin.clean.ui.newui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanMsgUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ CleanMsgUI hTx;

    CleanMsgUI$4(CleanMsgUI cleanMsgUI) {
        this.hTx = cleanMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        CleanMsgUI.a(this.hTx);
        return false;
    }
}
