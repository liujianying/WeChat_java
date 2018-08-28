package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;

class p$7 implements Runnable {
    final /* synthetic */ p tJl;

    p$7(p pVar) {
        this.tJl = pVar;
    }

    public final void run() {
        if (p.j(this.tJl) != null) {
            p.j(this.tJl).stopTone();
            x.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
        }
    }
}
