package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a$ag;
import com.tencent.pb.common.b.a.a$al;
import com.tencent.pb.common.b.a.a$ba;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a extends d {
    public String jTX = null;
    public int kvL = 0;
    public int vcc;
    public long vxz = 0;
    public int vzu;

    public a(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneAckVoiceGroup"});
        j jVar = new j();
        try {
            jVar.groupId = str;
            this.jTX = str;
            jVar.oLB = i;
            this.kvL = i;
            jVar.oLC = j;
            this.vxz = j;
            this.vzu = i3;
            this.vcc = i2;
            a$al a_al = new a$al();
            a_al.siI = 0;
            a$ba a_ba = new a$ba();
            a_ba.type = 3;
            a_ba.vfX = a_al;
            jVar.vcM = a_ba;
            this.jIm = 3;
            this.vcc = i2;
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneAckVoiceGroup constructor", e});
        }
        c(189, jVar);
    }

    public final int getType() {
        return 206;
    }

    protected final Object bI(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (a$ag) e.a(new a$ag(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
