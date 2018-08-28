package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchUI oty;

    ContactSearchUI$3(ContactSearchUI contactSearchUI) {
        this.oty = contactSearchUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactSearchUI.b(this.oty);
        return false;
    }
}
