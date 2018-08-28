package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NewBizInfoMoreInofUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ NewBizInfoMoreInofUI lYT;

    NewBizInfoMoreInofUI$1(NewBizInfoMoreInofUI newBizInfoMoreInofUI) {
        this.lYT = newBizInfoMoreInofUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lYT.finish();
        return true;
    }
}
