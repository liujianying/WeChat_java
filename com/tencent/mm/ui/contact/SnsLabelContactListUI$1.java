package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsLabelContactListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsLabelContactListUI ulZ;

    SnsLabelContactListUI$1(SnsLabelContactListUI snsLabelContactListUI) {
        this.ulZ = snsLabelContactListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulZ.finish();
        return true;
    }
}
