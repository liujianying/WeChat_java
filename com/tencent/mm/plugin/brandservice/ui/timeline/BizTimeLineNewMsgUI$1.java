package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class BizTimeLineNewMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ BizTimeLineNewMsgUI hrY;

    BizTimeLineNewMsgUI$1(BizTimeLineNewMsgUI bizTimeLineNewMsgUI) {
        this.hrY = bizTimeLineNewMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hrY.finish();
        return true;
    }
}
