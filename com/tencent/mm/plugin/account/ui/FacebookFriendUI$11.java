package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class FacebookFriendUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ FacebookFriendUI eQm;

    FacebookFriendUI$11(FacebookFriendUI facebookFriendUI) {
        this.eQm = facebookFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eQm.startActivity(new Intent(this.eQm, InviteFacebookFriendsUI.class));
        return true;
    }
}
