package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactMoreInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactMoreInfoUI lVo;

    ContactMoreInfoUI$1(ContactMoreInfoUI contactMoreInfoUI) {
        this.lVo = contactMoreInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lVo.finish();
        return true;
    }
}
