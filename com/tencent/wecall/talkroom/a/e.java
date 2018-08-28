package com.tencent.wecall.talkroom.a;

import com.tencent.mm.plugin.appbrand.jsapi.f.j;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class e extends d {
    public String jTX = null;
    public int kvL = 0;
    public String vxx = null;
    public long vxz = 0;
    public int vzw = 0;

    public e(e eVar) {
        this.jTX = eVar.jTX;
        this.kvL = eVar.kvL;
        this.vxz = eVar.vxz;
        this.vzw = eVar.vzw;
        this.vxx = eVar.vxx;
        this.vbZ = eVar.vbZ;
        this.vcb = eVar.vcb;
        this.vcc = eVar.vcc;
        this.jIm = 1;
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3, String str2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "enter2", str, Integer.valueOf(i), Long.valueOf(j), str2});
        com.tencent.pb.common.b.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.groupId = str;
            this.jTX = str;
            eVar.oLB = i;
            this.kvL = i;
            eVar.oLC = j;
            this.vxz = j;
            eVar.vcU = i3;
            this.vzw = i3;
            at atVar = new at();
            atVar.vfd = str2;
            eVar.vcK = atVar;
            this.vxx = str2;
            c.d("MicroMsg.Voip", new Object[]{this.TAG2, "wXgroupId", eVar.vcK.vfd});
            al alVar = new al();
            if (bArr != null) {
                alVar.buffer = bArr;
                alVar.siI = bArr.length;
            } else {
                alVar.siI = 0;
            }
            ba baVar = new ba();
            baVar.type = 3;
            baVar.vfX = alVar;
            eVar.vcM = baVar;
            this.jIm = 2;
            this.vcc = i2;
            eVar.vcO = 2;
            eVar.netType = k.ih(com.tencent.pb.common.c.d.oSX);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneEnterVoiceRoom constructor", e});
        }
        c(j.CTRL_INDEX, eVar);
    }

    public final int getType() {
        return 202;
    }

    protected final Object bI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (aa) com.google.a.a.e.a(new aa(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
