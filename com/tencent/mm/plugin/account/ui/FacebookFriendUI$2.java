package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacebookFriendUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$2(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eQm.YC();
        this.eQm.finish();
        return true;
    }
}
