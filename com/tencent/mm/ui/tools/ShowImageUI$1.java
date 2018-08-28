package com.tencent.mm.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShowImageUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShowImageUI uCd;

    ShowImageUI$1(ShowImageUI showImageUI) {
        this.uCd = showImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uCd.finish();
        return true;
    }
}
