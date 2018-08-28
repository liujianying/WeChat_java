package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizBindWxaInfoUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BizBindWxaInfoUI lUn;

    BizBindWxaInfoUI$1(BizBindWxaInfoUI bizBindWxaInfoUI) {
        this.lUn = bizBindWxaInfoUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.lUn.finish();
        return false;
    }
}
