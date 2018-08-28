package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelEditUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$7(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kAZ.onBackPressed();
        return true;
    }
}
