package com.tencent.mm.plugin.label.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelMemberListUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelMemberListUI kBC;

    ContactLabelMemberListUI$3(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.kBC = contactLabelMemberListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.kBC.finish();
        return false;
    }
}
