package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class j extends d {
    public String jTX;

    public final int getType() {
        return 213;
    }

    protected final Object bI(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ai) e.a(new ai(), bArr, bArr.length);
        } catch (Exception e) {
            c.x(this.TAG2, new Object[]{"data2Resp", e});
            return null;
        }
    }

    protected final String cEm() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
