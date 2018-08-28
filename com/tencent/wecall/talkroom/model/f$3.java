package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.m;
import java.util.TimerTask;

class f$3 extends TimerTask {
    final /* synthetic */ f vyi;
    final /* synthetic */ m vyk;

    f$3(f fVar, m mVar) {
        this.vyi = fVar;
        this.vyk = mVar;
    }

    public final void run() {
        if (this.vyk == null) {
            c.x("TalkRoomService", new Object[]{"doHelloTimeOutTask scene is null"});
        } else if (f.a(this.vyi, this.vyk.jTX, this.vyk.kvL, this.vyk.vxz, false)) {
            c.x("TalkRoomService", new Object[]{"doHelloTimeOutTask mGroupId: ", f.b(this.vyi), " mRoomId: ", Integer.valueOf(f.g(this.vyi)), " mRoomKey: ", Long.valueOf(f.h(this.vyi))});
            this.vyi.vxH.Ix(330);
            h.It(-1606);
            this.vyi.a(this.vyk.jTX, this.vyk.kvL, this.vyk.vxz, 117, true);
            f.f(this.vyi).h(-600, null);
        } else {
            c.x("TalkRoomService", new Object[]{"doHelloTimeOutTask isCurrentRoom is false scene.mGroupId: ", this.vyk.jTX, " scene.mRoomId: ", Integer.valueOf(this.vyk.kvL), " scene.mRoomKey: ", Long.valueOf(this.vyk.vxz)});
        }
    }
}
