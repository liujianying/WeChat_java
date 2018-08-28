package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactLabelMemberListUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ ContactLabelMemberListUI kBC;

    ContactLabelMemberListUI$4(ContactLabelMemberListUI contactLabelMemberListUI) {
        this.kBC = contactLabelMemberListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.kBC, ContactLabelEditUI.class);
        intent.putExtra("label_id", ContactLabelMemberListUI.c(this.kBC));
        intent.putExtra("label_name", ContactLabelMemberListUI.d(this.kBC));
        this.kBC.startActivityForResult(intent, 10001);
        return false;
    }
}
