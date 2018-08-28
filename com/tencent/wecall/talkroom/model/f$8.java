package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;

class f$8 implements Runnable {
    final /* synthetic */ f vyi;

    f$8(f fVar) {
        this.vyi = fVar;
    }

    public final void run() {
        if (this.vyi.bJP() && f.s(this.vyi)) {
            c.d("TalkRoomService", new Object[]{"syscall", "finishtalk becos holdtimeout"});
            h.Iu(-2003);
            this.vyi.vxH.Ix(401);
            this.vyi.ar(f.b(this.vyi), 3, 108);
        }
    }
}
