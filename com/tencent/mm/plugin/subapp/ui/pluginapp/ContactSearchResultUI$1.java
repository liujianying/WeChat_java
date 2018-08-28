package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchResultUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchResultUI ots;

    ContactSearchResultUI$1(ContactSearchResultUI contactSearchResultUI) {
        this.ots = contactSearchResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ots.finish();
        return true;
    }
}
