package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MobileFriendUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$3(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eIS.YC();
        this.eIS.finish();
        return true;
    }
}
