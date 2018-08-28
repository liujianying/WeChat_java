package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10;
import com.tencent.mm.sdk.platformtools.x;

class ReadMailUI$10$2 implements Runnable {
    final /* synthetic */ 10 miI;

    ReadMailUI$10$2(10 10) {
        this.miI = 10;
    }

    public final void run() {
        int contentHeight = (int) (((float) ReadMailUI.g(this.miI.miD).getContentHeight()) * ReadMailUI.g(this.miI.miD).getScale());
        x.d("MicroMsg.ReadMailUI", ReadMailUI.g(this.miI.miD).getContentHeight() + "," + ReadMailUI.g(this.miI.miD).getHeight() + "," + ReadMailUI.g(this.miI.miD).getScale());
        if (Math.abs(contentHeight - ReadMailUI.g(this.miI.miD).getHeight()) < 10) {
            ReadMailUI.g(this.miI.miD).hj(true);
        }
    }
}
