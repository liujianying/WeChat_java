package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.o;
import com.tencent.mm.ui.chatting.b.c.9;

class c$9$1 implements Runnable {
    final /* synthetic */ 9 tOo;

    c$9$1(9 9) {
        this.tOo = 9;
    }

    public final void run() {
        if (!(this.tOo.tOm.tOg == null || this.tOo.tOm.tOg.getVisibility() == 8)) {
            this.tOo.tOm.tOg.setVisibility(8);
        }
        if (this.tOo.tOm.bAG == null) {
            x.e("MicroMsg.ChattingUI.BizComponent", "[onProcecssClick] mChattingContext is null!");
            return;
        }
        ((o) this.tOo.tOm.bAG.O(o.class)).cvn();
        this.tOo.tOm.bAG.avj();
    }
}
