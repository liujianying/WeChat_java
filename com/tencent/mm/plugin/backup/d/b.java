package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.protocal.c.ev;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends l implements k {
    public com.tencent.mm.ab.b diG;
    protected e diJ;

    public b(LinkedList<pw> linkedList, String str) {
        a aVar = new a();
        aVar.dIG = new ev();
        aVar.dIH = new ex();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatcreateqrcode";
        aVar.dIF = 704;
        this.diG = aVar.KT();
        ev evVar = (ev) this.diG.dID.dIL;
        evVar.rfh = linkedList.size();
        evVar.rfi = linkedList;
        evVar.rfk = q.GF();
        evVar.rfj = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
        evVar.rfl = str;
        evVar.hbZ = 0;
        evVar.otY = 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.BackupCreateQRCodeScene", "err: %d, %d, %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.BackupCreateQRCodeScene", "onGYNetEnd QRCodeUrl:%s", new Object[]{((ex) this.diG.dIE.dIL).rfp});
            d.X(r0.reV.siK.lR);
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 704;
    }
}
