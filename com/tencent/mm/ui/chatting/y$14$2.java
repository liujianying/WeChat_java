package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.s;
import com.tencent.mm.ui.chatting.y.14;

class y$14$2 implements Runnable {
    final /* synthetic */ 14 tMo;
    s tMp = ((s) this.tMo.tMm.bAG.O(s.class));
    String username = this.tMo.tMm.bAG.getTalkerUserName();

    y$14$2(14 14) {
        this.tMo = 14;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.tMp == null) {
            x.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
            return;
        }
        this.tMp.aap(this.username);
        x.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
