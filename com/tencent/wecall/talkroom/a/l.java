package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class l extends d {
    public String jTX;
    public int kvL;
    public long vxz;

    public l(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneSwitchVideoGroup"});
        i iVar = new i();
        try {
            iVar.groupId = str;
            this.jTX = str;
            iVar.kpo = i;
            this.kvL = i;
            iVar.kpp = j;
            this.vxz = j;
            iVar.action = i2;
            iVar.timestamp = System.currentTimeMillis();
            this.jIm = 3;
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneSwitchVideoGroup constructor", e});
        }
        c(243, iVar);
    }

    public final int getType() {
        return 214;
    }

    protected final Object bI(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (af) e.a(new af(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
