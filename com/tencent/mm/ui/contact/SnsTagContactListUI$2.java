package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTagContactListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagContactListUI umh;

    SnsTagContactListUI$2(SnsTagContactListUI snsTagContactListUI) {
        this.umh = snsTagContactListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.umh.finish();
        return true;
    }
}
