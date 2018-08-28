package com.tencent.mm.plugin.record.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.a.d;

class RecordMsgDetailUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ RecordMsgDetailUI mtb;

    RecordMsgDetailUI$3(RecordMsgDetailUI recordMsgDetailUI) {
        this.mtb = recordMsgDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(this.mtb.mController.tml, 1, false);
        dVar.ofp = new 1(this);
        dVar.ofq = new 2(this);
        dVar.bXO();
        return true;
    }
}
