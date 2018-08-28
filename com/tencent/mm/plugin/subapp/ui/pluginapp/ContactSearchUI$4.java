package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactSearchUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ContactSearchUI oty;

    ContactSearchUI$4(ContactSearchUI contactSearchUI) {
        this.oty = contactSearchUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.oty.YC();
        this.oty.finish();
        return true;
    }
}
