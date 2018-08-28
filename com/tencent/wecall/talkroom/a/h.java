package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a$aj;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class h extends d {
    public String groupId;
    public int kpo;
    public long kpp;

    public h(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneRejectVoiceGroup"});
        k kVar = new k();
        try {
            kVar.groupId = str;
            kVar.oLB = i;
            kVar.oLC = j;
            kVar.kpU = i2;
            kVar.vcO = 2;
            kVar.netType = com.tencent.wecall.talkroom.model.k.ih(com.tencent.pb.common.c.d.oSX);
            this.jIm = 3;
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneRedirect constructor", e});
        }
        c(211, kVar);
    }

    public final int getType() {
        return 211;
    }

    protected final Object bI(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (a$aj) e.a(new a$aj(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
