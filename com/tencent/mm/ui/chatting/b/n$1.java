package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.b.b.m;

class n$1 implements Runnable {
    final /* synthetic */ n tPA;

    n$1(n nVar) {
        this.tPA = nVar;
    }

    public final void run() {
        1 1 = new 1(this);
        if (this.tPA.bAG.getListView() != null) {
            this.tPA.bAG.getListView().setOnDragListener(1);
        }
        ChatFooter cvb = ((m) this.tPA.bAG.O(m.class)).cvb();
        if (cvb != null) {
            cvb.setOnDragListener(1);
            cvb.setEditTextOnDragListener(1);
        }
    }
}
