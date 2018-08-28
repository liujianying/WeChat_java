package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.az.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private final q dJM = new b();
    private int dJp = 2;
    com.tencent.mm.ab.e diJ;
    String eHp = "";

    public e(String str) {
        a aVar = (a) this.dJM.KV();
        aVar.dBU.hbL = str;
        aVar.dBU.rMs = 1;
        x.i("MicroMsg.NetSceneGetVoiceprintTicketRsa", "sceneType %d %s", new Object[]{Integer.valueOf(1), str});
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    protected final void a(l.a aVar) {
    }

    public final int getType() {
        return 618;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        az.b bVar = (az.b) qVar.Id();
        this.eHp = bVar.dBV.rMt;
        x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " mTicket: " + this.eHp);
        if (i2 == 4 && i3 == -301) {
            av.a(true, bVar.dBV.rhK, bVar.dBV.rhL, bVar.dBV.rhJ);
            this.dJp--;
            if (this.dJp <= 0) {
                x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "reach redirect limit, invoke callback");
                this.diJ.a(3, -1, "", this);
                return;
            }
            x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "redirect IDC");
            a(this.dIX, this.diJ);
        } else if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.KV().qWA.ver)});
            au.Em().H(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
