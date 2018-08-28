package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.a;

class ReadMailUI$a$5 implements Runnable {
    final /* synthetic */ a miN;

    ReadMailUI$a$5(a aVar) {
        this.miN = aVar;
    }

    public final void run() {
        ReadMailUI.m(this.miN.miD).setVisibility(8);
        ReadMailUI.n(this.miN.miD);
    }
}
