package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.sdk.platformtools.ab.b;
import com.tencent.mm.sdk.platformtools.ad;

class TalkRoomReceiver$1 implements b {
    TalkRoomReceiver$1() {
    }

    public final void prepare() {
        TalkRoomReceiver.bk(ad.getContext());
    }

    public final void cancel() {
        TalkRoomReceiver.bl(ad.getContext());
    }
}
