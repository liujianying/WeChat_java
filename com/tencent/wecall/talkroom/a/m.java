package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ak;
import com.tencent.pb.common.b.a.a.l;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class m extends d {
    public String jTX;
    public int kvL;
    public long vxz;

    public m(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", this.TAG2, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        l lVar = new l();
        lVar.vcZ = i3;
        lVar.oLB = i;
        this.kvL = i;
        lVar.oLC = j;
        this.vxz = j;
        lVar.groupId = str;
        this.jTX = str;
        lVar.kpU = i2;
        try {
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, "NetSceneVoiceRoomHello constructor", e);
        }
        c(147, lVar);
    }

    public final int getType() {
        return 205;
    }

    protected final Object bI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ak) e.a(new ak(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
