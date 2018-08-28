package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.record.b.h;

class RecordMsgFileUI$7 implements OnClickListener {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$7(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final void onClick(View view) {
        String c = h.c(RecordMsgFileUI.a(this.mtg), RecordMsgFileUI.b(this.mtg));
        new Intent().setAction("android.intent.action.VIEW");
        if (4 == RecordMsgFileUI.c(this.mtg)) {
            RecordMsgFileUI.d(this.mtg);
            RecordMsgFileUI.e(this.mtg);
            return;
        }
        RecordMsgFileUI.a(this.mtg, c);
    }
}
