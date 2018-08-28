package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class RecordMsgFileUI$6 implements Runnable {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$6(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final void run() {
        RecordMsgFileUI.g(this.mtg);
        h.bA(this.mtg.mController.tml, this.mtg.getString(R.l.download_fail));
    }
}
