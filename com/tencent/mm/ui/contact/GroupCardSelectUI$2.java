package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GroupCardSelectUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ GroupCardSelectUI ujL;

    GroupCardSelectUI$2(GroupCardSelectUI groupCardSelectUI) {
        this.ujL = groupCardSelectUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ujL.finish();
        return true;
    }
}
