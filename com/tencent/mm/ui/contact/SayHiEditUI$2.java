package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SayHiEditUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiEditUI ulq;

    SayHiEditUI$2(SayHiEditUI sayHiEditUI) {
        this.ulq = sayHiEditUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulq.finish();
        return true;
    }
}
