package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.10;

class ReadMailUI$10$1 implements Runnable {
    final /* synthetic */ 10 miI;

    ReadMailUI$10$1(10 10) {
        this.miI = 10;
    }

    public final void run() {
        ReadMailUI.g(this.miI.miD).getSettings().setLoadsImagesAutomatically(true);
        ReadMailUI.g(this.miI.miD).getSettings().setSupportZoom(true);
        ReadMailUI.g(this.miI.miD).getSettings().setBuiltInZoomControls(true);
        ReadMailUI.g(this.miI.miD).bpd();
        ReadMailUI.g(this.miI.miD).bpe();
    }
}
