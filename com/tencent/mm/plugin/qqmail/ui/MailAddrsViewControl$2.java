package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Button;

class MailAddrsViewControl$2 implements Runnable {
    final /* synthetic */ MailAddrsViewControl mhb;
    final /* synthetic */ Button mhc;

    MailAddrsViewControl$2(MailAddrsViewControl mailAddrsViewControl, Button button) {
        this.mhb = mailAddrsViewControl;
        this.mhc = button;
    }

    public final void run() {
        this.mhc.invalidate();
        this.mhc.setOnTouchListener(new 1(this));
        this.mhb.bpb();
        this.mhb.invalidate();
    }
}
