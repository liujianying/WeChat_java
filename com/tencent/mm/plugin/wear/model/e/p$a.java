package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.f.c;
import com.tencent.mm.protocal.c.cff;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

class p$a extends c {
    public int mFO;
    public int pJs = 2;
    public int pJt;
    final /* synthetic */ p pKd;
    public cff pKe;

    public p$a(p pVar, int i, cff cff) {
        this.pKd = pVar;
        this.mFO = i;
        this.pJt = 30001;
        this.pKe = cff;
    }

    protected final void send() {
        try {
            byte[] bc = a.bSl().pIM.bc(this.pKe.toByteArray());
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(this.pJs);
                dataOutputStream.writeInt(this.mFO);
                dataOutputStream.writeInt(this.pJt);
                if (bc == null || bc.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(bc.length);
                    dataOutputStream.write(bc);
                }
                bc = byteArrayOutputStream.toByteArray();
                x.i("MicroMsg.Wear.VoiceToTextServer", "send data funId=%d length=%d", Integer.valueOf(this.pJt), Integer.valueOf(bc.length));
                a.bSl().pIM.ba(byteArrayOutputStream.toByteArray());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(this.pJs), Integer.valueOf(this.mFO), Integer.valueOf(this.pJt));
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Wear.VoiceToTextServer", e2, "", new Object[0]);
        }
    }

    public final String getName() {
        return "WearVoiceToTextTask";
    }
}
