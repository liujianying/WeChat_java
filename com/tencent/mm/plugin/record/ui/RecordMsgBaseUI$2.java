package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RecordMsgBaseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgBaseUI msV;

    RecordMsgBaseUI$2(RecordMsgBaseUI recordMsgBaseUI) {
        this.msV = recordMsgBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.msV.finish();
        return true;
    }
}
