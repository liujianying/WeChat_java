package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.al;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.ay;
import com.tencent.pb.common.b.a.a.ba;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.c.c;
import com.tencent.wecall.talkroom.model.k;

public final class d extends com.tencent.pb.common.b.d {
    public int mType;
    public String vxy;
    public boolean vzv = true;

    public d(String str, String[] strArr, byte[] bArr, String str2, ay ayVar, int i, int i2, long j, String str3, boolean z, String str4) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "create"});
        com.tencent.pb.common.b.a.a.d dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.vcI = str;
            this.vxy = str;
            dVar.vcN = i;
            this.vcc = i;
            if (ayVar != null) {
                dVar.vcP = ayVar;
            }
            at atVar = new at();
            atVar.name = str2;
            atVar.vfd = str4;
            atVar.vfc = a.cEG();
            atVar.bOS = i2;
            this.mType = i2;
            this.vzv = z;
            atVar.veV = j;
            dVar.vcK = atVar;
            dVar.vcR = strArr;
            if (str3 == null) {
                str3 = "";
            }
            dVar.vcQ = str3;
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
            dVar.vcM = baVar;
            this.jIm = 3;
            dVar.vcO = 2;
            dVar.netType = k.ih(com.tencent.pb.common.c.d.oSX);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneCreateVoiceGroup constructor", e});
        }
        c(139, dVar);
    }

    public final int getType() {
        return 201;
    }

    protected final Object bI(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (z) e.a(new z(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
