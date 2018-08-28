package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkInfoViewUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ujm;

    ContactRemarkInfoViewUI$3(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ujm = contactRemarkInfoViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ujm.finish();
        return true;
    }
}
