package com.tencent.mm.plugin.record.ui;

class RecordMsgImageUI$2 implements Runnable {
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$2(RecordMsgImageUI recordMsgImageUI) {
        this.mtp = recordMsgImageUI;
    }

    public final void run() {
        RecordMsgImageUI.a(this.mtp).notifyDataSetChanged();
    }
}
