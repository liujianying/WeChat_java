package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsTagPartlyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagPartlyUI obN;

    SnsTagPartlyUI$1(SnsTagPartlyUI snsTagPartlyUI) {
        this.obN = snsTagPartlyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.obN.finish();
        return true;
    }
}
