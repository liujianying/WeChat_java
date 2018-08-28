package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgFileUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$1(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mtg.finish();
        return true;
    }
}
