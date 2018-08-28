package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.a.a;
import com.tencent.pb.talkroom.sdk.c;

class f$5 implements c {
    final /* synthetic */ f vyi;

    f$5(f fVar) {
        this.vyi = fVar;
    }

    public final void V(byte[] bArr, int i) {
        try {
            if (f.l(this.vyi)) {
                if (f.m(this.vyi)) {
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr[i2] = (byte) 0;
                    }
                }
                if (f.l(this.vyi)) {
                    b c = f.c(this.vyi);
                    short s = (short) i;
                    if (a.vbD) {
                        c.vwZ.SendAudio(bArr, s, 0);
                    }
                    if (this.vyi.vxW) {
                        this.vyi.vxW = false;
                        com.tencent.pb.common.c.c.x("TalkRoomService", new Object[]{"onRecPcmDataCallBack len: ", Integer.valueOf(i)});
                    }
                }
            }
        } catch (Exception e) {
            com.tencent.pb.common.c.c.x("TalkRoomService", new Object[]{"initMediaComponent record", e});
        }
    }
}
