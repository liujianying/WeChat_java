package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class b extends d {
    public String jTX;
    public int kvL;
    public long vxz;

    public b(String str, int i, long j, String[] strArr) {
        c.d("MicroMsg.Voip", new Object[]{this.TAG2, "addmember", str});
        a aVar = new a();
        try {
            aVar.groupId = str;
            this.jTX = str;
            aVar.oLB = i;
            this.kvL = i;
            aVar.oLC = j;
            this.vxz = j;
            aVar.vcH = strArr;
            aVar.oLB = i;
            this.jIm = 3;
            this.vcc = com.tencent.wecall.talkroom.model.c.cHG().adi(str);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"NetSceneAddVoiceGroupMember constructor", e});
        }
        c(145, aVar);
    }

    public final int getType() {
        return TbsListener$ErrorCode.APK_INVALID;
    }

    protected final Object bI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (x) e.a(new x(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e.getMessage()});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
