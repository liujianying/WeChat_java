package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.plugin.talkroom.model.b;

class TalkRoomUI$3 implements Runnable {
    final /* synthetic */ String kGJ;
    final /* synthetic */ TalkRoomUI oxW;

    TalkRoomUI$3(TalkRoomUI talkRoomUI, String str) {
        this.oxW = talkRoomUI;
        this.kGJ = str;
    }

    public final void run() {
        b.bGT().T(this.kGJ, 0);
    }
}
