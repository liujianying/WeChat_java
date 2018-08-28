package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ContactRemarkImagePreviewUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ContactRemarkImagePreviewUI uiD;

    ContactRemarkImagePreviewUI$2(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        this.uiD = contactRemarkImagePreviewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ContactRemarkImagePreviewUI.a(this.uiD, false);
        return false;
    }
}
