package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelUI kBX;

    ContactLabelUI$1(ContactLabelUI contactLabelUI) {
        this.kBX = contactLabelUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kBX.onBackPressed();
        return false;
    }
}
