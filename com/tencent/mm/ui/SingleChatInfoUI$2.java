package com.tencent.mm.ui;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class SingleChatInfoUI$2 implements Runnable {
    final /* synthetic */ int hMp;
    final /* synthetic */ SingleChatInfoUI tqo;

    SingleChatInfoUI$2(SingleChatInfoUI singleChatInfoUI, int i) {
        this.tqo = singleChatInfoUI;
        this.hMp = i;
    }

    public final void run() {
        View a = ((a) SingleChatInfoUI.a(this.tqo)).a(this.hMp, this.tqo.kww);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.tqo.mController.tml, a);
        }
    }
}
