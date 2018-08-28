package com.tencent.mm.modelvoice;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements a {
    final /* synthetic */ f eoK;

    f$1(f fVar) {
        this.eoK = fVar;
    }

    public final boolean vD() {
        p ot = q.ot(this.eoK.fileName);
        if (ot == null || !ot.TM()) {
            x.e("MicroMsg.NetSceneUploadVoice", "Get info Failed file:" + this.eoK.fileName);
            this.eoK.retCode = g.getLine() + 10000;
            this.eoK.diJ.a(3, -1, "doScene failed", this.eoK);
            return false;
        }
        if (!(3 == ot.status || 8 == ot.status)) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis / 1000) - ot.enK > 30) {
                x.e("MicroMsg.NetSceneUploadVoice", "Error ModifyTime in Read file:" + this.eoK.fileName);
                this.eoK.retCode = g.getLine() + 10000;
                this.eoK.diJ.a(3, -1, "doScene failed", this.eoK);
                return false;
            } else if (currentTimeMillis - this.eoK.eoJ < 2000) {
                x.d("MicroMsg.NetSceneUploadVoice", "TimerExpired :" + this.eoK.fileName + " but last send time:" + (currentTimeMillis - this.eoK.eoJ));
                return true;
            } else {
                g br = q.ok(this.eoK.fileName).br(ot.emu, 6000);
                x.d("MicroMsg.NetSceneUploadVoice", "pusher doscene:" + this.eoK.fileName + " readByte:" + br.bEG + " stat:" + ot.status);
                if (br.bEG < 2000) {
                    return true;
                }
            }
        }
        if (this.eoK.a(this.eoK.dIX, this.eoK.diJ) != -1) {
            return false;
        }
        this.eoK.retCode = g.getLine() + 10000;
        this.eoK.diJ.a(3, -1, "doScene failed", this.eoK);
        return false;
    }
}
