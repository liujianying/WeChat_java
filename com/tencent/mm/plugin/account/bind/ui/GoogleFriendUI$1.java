package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class GoogleFriendUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ GoogleFriendUI eIi;

    GoogleFriendUI$1(GoogleFriendUI googleFriendUI) {
        this.eIi = googleFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eIi.finish();
        return true;
    }
}
