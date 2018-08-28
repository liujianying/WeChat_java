package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SayHiWithSnsPermissionUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ SayHiWithSnsPermissionUI lYi;

    SayHiWithSnsPermissionUI$7(SayHiWithSnsPermissionUI sayHiWithSnsPermissionUI) {
        this.lYi = sayHiWithSnsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (SayHiWithSnsPermissionUI.k(this.lYi)) {
            SayHiWithSnsPermissionUI.l(this.lYi)[1] = 1;
        }
        this.lYi.finish();
        return true;
    }
}
