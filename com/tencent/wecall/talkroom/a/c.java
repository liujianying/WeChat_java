package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;

public final class c extends d {
    public c(String str, int i, int i2) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneCancelCreateVoiceGroup"});
        b bVar = new b();
        try {
            bVar.vcI = str;
            bVar.aAk = i;
            this.jIm = 3;
            this.vcc = i2;
        } catch (Exception e) {
            com.tencent.pb.common.c.c.x(this.TAG2, new Object[]{"NetSceneCancelCreateVoiceGroup constructor", e});
        }
        c(183, bVar);
    }

    public final int getType() {
        return 208;
    }

    protected final Object bI(byte[] bArr) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (y) e.a(new y(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
