package com.tencent.mm.plugin.talkroom.ui;

import com.tencent.mm.ui.base.MMHorList.a;

class TalkRoomAvatarsFrame$1 implements a {
    final /* synthetic */ TalkRoomAvatarsFrame oxD;

    TalkRoomAvatarsFrame$1(TalkRoomAvatarsFrame talkRoomAvatarsFrame) {
        this.oxD = talkRoomAvatarsFrame;
    }

    public final void bHl() {
        TalkRoomAvatarsFrame.a(this.oxD).SO();
    }

    public final void bHm() {
        TalkRoomAvatarsFrame.a(this.oxD).J(2000, 2000);
    }

    public final void bbm() {
        TalkRoomAvatarsFrame.c(this.oxD).post(new Runnable() {
            public final void run() {
                TalkRoomAvatarsFrame.b(TalkRoomAvatarsFrame$1.this.oxD).notifyDataSetChanged();
            }
        });
    }
}
