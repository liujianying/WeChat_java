package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizTimeLineUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$2(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hst.finish();
        return true;
    }
}
