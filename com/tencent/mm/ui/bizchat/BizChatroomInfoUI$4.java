package com.tencent.mm.ui.bizchat;

import android.view.View;
import com.tencent.mm.ui.base.preference.a;

class BizChatroomInfoUI$4 implements Runnable {
    final /* synthetic */ int hMp;
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$4(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        this.tFD = bizChatroomInfoUI;
        this.hMp = i;
    }

    public final void run() {
        View a = ((a) BizChatroomInfoUI.a(this.tFD)).a(this.hMp, this.tFD.kww);
        if (a != null) {
            com.tencent.mm.ui.g.a.b(this.tFD.mController.tml, a);
        }
    }
}
