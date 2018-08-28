package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ae;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class k extends d {
    public String jTX;
    public int kvL;
    public long vxz;

    public k(String str, int i, long j, String str2) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "NetSceneSubscribeLargeVideo"});
        h hVar = new h();
        try {
            hVar.groupId = str;
            this.jTX = str;
            hVar.kpo = i;
            this.kvL = i;
            hVar.kpp = j;
            this.vxz = j;
            hVar.hOQ = str2;
            hVar.timestamp = System.currentTimeMillis();
            c.w("MicroMsg.Voip", new Object[]{"roomId: %d, roomKey: %d, groupId: %s, ownerUserName: %s, timestamp: %d", Integer.valueOf(hVar.kpo), Long.valueOf(hVar.kpp), hVar.groupId, hVar.hOQ, Long.valueOf(hVar.timestamp)});
            this.jIm = 3;
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneSwitchVideoGroup constructor", e});
        }
        c(245, hVar);
    }

    public final int getType() {
        return 800;
    }

    protected final Object bI(byte[] bArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "data2Resp"});
        if (bArr == null) {
            return null;
        }
        try {
            return (ae) e.a(new ae(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSSubscribeLargeVideoReq";
    }
}
