package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class b$1 implements OnMenuItemClickListener {
    final /* synthetic */ b lYu;

    b$1(b bVar) {
        this.lYu = bVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lYu.lYs.onBackPressed();
        return true;
    }
}
