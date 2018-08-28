package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AllRemindMsgUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ AllRemindMsgUI tgf;

    AllRemindMsgUI$2(AllRemindMsgUI allRemindMsgUI) {
        this.tgf = allRemindMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tgf.onBackPressed();
        return true;
    }
}
