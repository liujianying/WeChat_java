package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomUI$1 implements a {
    final /* synthetic */ TalkRoomUI oxW;

    TalkRoomUI$1(TalkRoomUI talkRoomUI) {
        this.oxW = talkRoomUI;
    }

    public final boolean vD() {
        x.i("MicroMsg.TalkRoomUI", "seizeMicTimer reach");
        TalkRoomUI.a(this.oxW);
        return false;
    }
}
