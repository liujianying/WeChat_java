package com.tencent.wecall.talkroom.model;

import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import com.tencent.pb.talkroom.sdk.b;
import java.util.concurrent.atomic.AtomicInteger;

class f$6 implements b {
    final /* synthetic */ f vyi;
    final /* synthetic */ AtomicInteger vyt;
    final /* synthetic */ AtomicInteger vyu;

    f$6(f fVar, AtomicInteger atomicInteger, AtomicInteger atomicInteger2) {
        this.vyi = fVar;
        this.vyt = atomicInteger;
        this.vyu = atomicInteger2;
    }

    public final int U(byte[] bArr, int i) {
        if (!f.l(this.vyi)) {
            return 0;
        }
        try {
            int GetAudioData = !a.vbD ? 1 : f.c(this.vyi).vwZ.GetAudioData(bArr, (short) i, this.vyt, this.vyu);
            if (this.vyi.vxX && GetAudioData >= 0) {
                this.vyi.vxX = false;
                c.x("TalkRoomService", new Object[]{"onPlayPcmDataCallBack len: ", Integer.valueOf(i), " ret: ", Integer.valueOf(GetAudioData)});
            }
            return GetAudioData;
        } catch (Exception e) {
            c.x("TalkRoomService", new Object[]{"initMediaComponent play", e});
            return -1;
        }
    }
}
