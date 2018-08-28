package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abn;
import com.tencent.mm.protocal.c.abo;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class ac extends l implements k {
    private final b diG;
    private e diJ;
    public LinkedList<String> htD;
    public int htF;
    public int htG;
    public int htH;

    public ac(String str) {
        a aVar = new a();
        aVar.dIG = new abn();
        aVar.dIH = new abo();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.dIF = 577;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((abn) this.diG.dID.dIL).cac = str;
    }

    public final int getType() {
        return 577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abo abo = (abo) this.diG.dIE.dIL;
            this.htD = abo.htD;
            this.htF = abo.htF;
            this.htG = abo.htG;
            this.htH = abo.htH;
        }
        x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[]{Integer.valueOf(this.htF), Integer.valueOf(this.htG), Integer.valueOf(this.htH)});
        if (this.htD != null) {
            x.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.htD.size());
        }
        this.diJ.a(i2, i3, str, this);
    }
}
