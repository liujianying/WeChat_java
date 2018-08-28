package com.tencent.mm.plugin.record.ui;

class RecordMsgFileUI$4 implements Runnable {
    final /* synthetic */ RecordMsgFileUI mtg;

    RecordMsgFileUI$4(RecordMsgFileUI recordMsgFileUI) {
        this.mtg = recordMsgFileUI;
    }

    public final void run() {
        this.mtg.enableOptionMenu(true);
        RecordMsgFileUI.p(this.mtg);
    }
}
