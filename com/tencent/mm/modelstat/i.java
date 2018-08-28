package com.tencent.mm.modelstat;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bd;
import com.tencent.mm.protocal.c.be;
import com.tencent.mm.protocal.c.bj;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private final b diG;
    private e doG;

    public i(int i, String str, int i2) {
        a aVar = new a();
        aVar.dIG = new bd();
        aVar.dIH = new be();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.dIF = 1295;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bd bdVar = (bd) this.diG.dID.dIL;
        bj bjVar = new bj();
        bjVar.rbJ = i;
        bjVar.rbK = new com.tencent.mm.bk.b(str.getBytes());
        bjVar.rbL = (long) i2;
        bdVar.rbu.add(bjVar);
        x.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[]{Integer.valueOf(i), str});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        be beVar = (be) this.diG.dIE.dIL;
        x.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(beVar.ret), beVar.bIr});
        this.doG.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.doG = eVar2;
        return a(eVar, this.diG, this);
    }
}
