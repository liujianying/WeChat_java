package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AddMoreFriendsByOtherWayUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AddMoreFriendsByOtherWayUI otk;

    AddMoreFriendsByOtherWayUI$1(AddMoreFriendsByOtherWayUI addMoreFriendsByOtherWayUI) {
        this.otk = addMoreFriendsByOtherWayUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.otk.finish();
        return true;
    }
}
