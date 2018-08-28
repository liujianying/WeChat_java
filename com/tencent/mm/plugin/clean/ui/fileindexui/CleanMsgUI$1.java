package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CleanMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CleanMsgUI hSL;

    CleanMsgUI$1(CleanMsgUI cleanMsgUI) {
        this.hSL = cleanMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hSL.finish();
        return false;
    }
}
