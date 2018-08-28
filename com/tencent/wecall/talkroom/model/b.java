package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk vwZ = new talk();

    public b() {
        c.d("simon:TalkRoomContext", new Object[]{"construct"});
    }

    public final int uninitLive() {
        if (!a.vbD) {
            return 0;
        }
        int uninit;
        try {
            uninit = this.vwZ.uninit();
        } catch (Throwable th) {
            c.x("simon:TalkRoomContext", new Object[]{"uninitLive ", th});
            uninit = 0;
        }
        c.d("simon:TalkRoomContext", new Object[]{"uninitLive ret: ", Integer.valueOf(uninit)});
        return uninit;
    }

    public final int Close() {
        if (!a.vbD) {
            return 0;
        }
        int close;
        try {
            close = this.vwZ.close();
        } catch (Throwable th) {
            c.x("simon:TalkRoomContext", new Object[]{"Close ", th});
            close = 0;
        }
        c.d("simon:TalkRoomContext", new Object[]{"Close ret: ", Integer.valueOf(close)});
        return close;
    }

    public final void OnMembersChanged(int[] iArr) {
        if (a.vbD) {
            this.vwZ.OnMembersChanged(iArr);
        }
    }

    public final byte[] cHE() {
        if (a.vbD) {
            return this.vwZ.field_capInfo;
        }
        return new byte[0];
    }

    public final int cHF() {
        try {
            if (!a.vbD) {
                return 0;
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.vwZ.getChannelBytes(atomicInteger, atomicInteger2);
            return atomicInteger2.get();
        } catch (Throwable th) {
            c.x("simon:TalkRoomContext", new Object[]{"getTotalWWANBytes: ", th});
            return 0;
        }
    }
}
