package com.tencent.mm.ui.conversation;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.m.4;

class m$4$1 implements Runnable {
    final /* synthetic */ 4 ury;

    m$4$1(4 4) {
        this.ury = 4;
    }

    public final void run() {
        x.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
        if (this.ury.urw.unL != null) {
            this.ury.urw.unL.notifyDataSetChanged();
        }
    }
}
