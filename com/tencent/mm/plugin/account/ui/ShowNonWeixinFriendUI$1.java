package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShowNonWeixinFriendUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShowNonWeixinFriendUI eXk;

    ShowNonWeixinFriendUI$1(ShowNonWeixinFriendUI showNonWeixinFriendUI) {
        this.eXk = showNonWeixinFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eXk.YC();
        this.eXk.finish();
        return true;
    }
}
