package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InviteFacebookFriendsUI$8 implements OnMenuItemClickListener {
    final /* synthetic */ InviteFacebookFriendsUI eQB;

    InviteFacebookFriendsUI$8(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        this.eQB = inviteFacebookFriendsUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eQB.YC();
        this.eQB.finish();
        return true;
    }
}
