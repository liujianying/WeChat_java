package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.a.e;

class f$9 implements Runnable {
    final /* synthetic */ f vyi;

    f$9(f fVar) {
        this.vyi = fVar;
    }

    public final void run() {
        d dVar = null;
        String str = "TalkRoomService";
        Object[] objArr = new Object[6];
        objArr[0] = "beginSenceCircle state: ";
        objArr[1] = Integer.valueOf(f.a(this.vyi));
        objArr[2] = " mCircleScene: ";
        objArr[3] = f.t(this.vyi) == null ? null : Integer.valueOf(f.t(this.vyi).getType());
        objArr[4] = " mIsAck: ";
        objArr[5] = Boolean.valueOf(f.u(this.vyi));
        c.d(str, objArr);
        if (f.t(this.vyi) == null) {
            f.w(this.vyi).removeCallbacks(f.v(this.vyi));
            c.x("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        } else if (this.vyi.bJP()) {
            if (f.t(this.vyi) != null && f.t(this.vyi).getType() == 202 && f.a(this.vyi) == 3) {
                e eVar = (e) f.t(this.vyi);
                if (f.a(this.vyi, eVar.jTX, eVar.kvL, eVar.vxz, f.Is(eVar.vzw))) {
                    dVar = new e(eVar);
                    c.x("TalkRoomService", new Object[]{"beginSenceCircle enter"});
                }
            }
            if (dVar != null) {
                com.tencent.pb.common.b.e.cEn().a(dVar);
                return;
            }
            f.w(this.vyi).removeCallbacks(f.v(this.vyi));
            c.x("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        } else {
            f.w(this.vyi).removeCallbacks(f.v(this.vyi));
            c.x("TalkRoomService", new Object[]{"beginSenceCircle removeCallbacks"});
        }
    }
}
