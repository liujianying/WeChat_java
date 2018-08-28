package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgImageUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$6(RecordMsgImageUI recordMsgImageUI) {
        this.mtp = recordMsgImageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mtp.finish();
        return true;
    }
}
