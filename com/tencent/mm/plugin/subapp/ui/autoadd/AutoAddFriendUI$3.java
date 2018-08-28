package com.tencent.mm.plugin.subapp.ui.autoadd;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AutoAddFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AutoAddFriendUI orK;

    AutoAddFriendUI$3(AutoAddFriendUI autoAddFriendUI) {
        this.orK = autoAddFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.orK.finish();
        return true;
    }
}
