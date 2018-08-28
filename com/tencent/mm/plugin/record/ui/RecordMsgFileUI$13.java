package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;

class RecordMsgFileUI$13 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$13(RecordMsgFileUI recordMsgFileUI, Dialog dialog) {
        this.mtg = recordMsgFileUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
    }
}
