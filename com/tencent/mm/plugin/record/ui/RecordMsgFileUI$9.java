package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.h;

class RecordMsgFileUI$9 implements OnClickListener {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$9(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final void onClick(View view) {
        if (f.zZ()) {
            h.b(RecordMsgFileUI.a(this.mtg), RecordMsgFileUI.b(this.mtg), true);
            RecordMsgFileUI.f(this.mtg);
            return;
        }
        com.tencent.mm.ui.base.h.i(this.mtg.mController.tml, R.l.favorite_no_sdcard, R.l.app_tip);
    }
}
