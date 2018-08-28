package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkInfoViewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ujm;

    ContactRemarkInfoViewUI$2(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ujm = contactRemarkInfoViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClass(this.ujm.mController.tml, ContactRemarkInfoModUI.class);
        intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.c(this.ujm));
        intent.putExtra("Contact_User", ContactRemarkInfoViewUI.d(this.ujm).field_username);
        this.ujm.startActivity(intent);
        return false;
    }
}
