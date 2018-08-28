package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2)});
        com.tencent.pb.common.b.a.a.f fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.groupId = str;
            fVar.oLB = i;
            fVar.oLC = j;
            fVar.aAk = i2;
            this.jIm = 2;
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneExitVoiceRoom constructor", e});
        }
        c(143, fVar);
    }

    public final int getType() {
        return 203;
    }

    protected final Object bI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ab) e.a(new ab(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
