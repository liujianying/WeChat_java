package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelManagerUI$9 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelManagerUI kBk;

    ContactLabelManagerUI$9(ContactLabelManagerUI contactLabelManagerUI) {
        this.kBk = contactLabelManagerUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactLabelManagerUI.b(this.kBk);
        return false;
    }
}
