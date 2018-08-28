package com.tencent.mm.plugin.account.friend.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class InviteFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ InviteFriendUI eMv;

    InviteFriendUI$3(InviteFriendUI inviteFriendUI) {
        this.eMv = inviteFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eMv.finish();
        return true;
    }
}
