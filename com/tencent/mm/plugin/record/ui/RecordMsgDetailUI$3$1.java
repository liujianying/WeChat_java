package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.record.ui.RecordMsgDetailUI.3;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class RecordMsgDetailUI$3$1 implements c {
    final /* synthetic */ 3 mtc;

    RecordMsgDetailUI$3$1(3 3) {
        this.mtc = 3;
    }

    public final void a(l lVar) {
        lVar.e(0, this.mtc.mtb.getString(R.l.favorite_share_with_friend));
        if (this.mtc.mtb.getIntent().getIntExtra("from_scene", 0) == 0) {
            lVar.e(2, this.mtc.mtb.getString(R.l.plugin_favorite_opt));
        }
    }
}
