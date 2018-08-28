package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ b ore;

    b$1(b bVar) {
        this.ore = bVar;
    }

    public final boolean vD() {
        g Ok = h.Ok(this.ore.fileName);
        if (Ok == null || !Ok.TM()) {
            x.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.ore.fileName);
            this.ore.retCode = g.getLine() + 10000;
            this.ore.diJ.a(3, -1, "doScene failed", this.ore);
            return false;
        }
        if (!(3 == Ok.field_status || 8 == Ok.field_status)) {
            long currentTimeMillis = System.currentTimeMillis();
            if ((currentTimeMillis / 1000) - Ok.field_lastmodifytime > 30) {
                x.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + this.ore.fileName);
                this.ore.retCode = g.getLine() + 10000;
                this.ore.diJ.a(3, -1, "doScene failed", this.ore);
                return false;
            } else if (currentTimeMillis - this.ore.eoJ < 2000) {
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + this.ore.fileName + " but last send time:" + (currentTimeMillis - this.ore.eoJ));
                return true;
            } else {
                c$a xU = h.Ol(this.ore.fileName).xU(Ok.field_offset);
                x.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + this.ore.fileName + " readByte:" + xU.bEG + " stat:" + Ok.field_status);
                if (xU.bEG < 2000) {
                    return true;
                }
            }
        }
        if (this.ore.a(this.ore.dIX, this.ore.diJ) != -1) {
            return false;
        }
        this.ore.retCode = g.getLine() + 10000;
        this.ore.diJ.a(3, -1, "doScene failed", this.ore);
        return false;
    }
}
