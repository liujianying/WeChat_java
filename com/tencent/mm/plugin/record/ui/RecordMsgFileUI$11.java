package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class RecordMsgFileUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$11(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.mtg.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
