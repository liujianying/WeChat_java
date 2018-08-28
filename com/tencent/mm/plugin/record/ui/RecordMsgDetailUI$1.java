package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgDetailUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgDetailUI mtb;

    RecordMsgDetailUI$1(RecordMsgDetailUI recordMsgDetailUI) {
        this.mtb = recordMsgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mtb.finish();
        return true;
    }
}
