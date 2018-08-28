package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.protocal.c.fu;
import com.tencent.mm.protocal.c.fv;
import com.tencent.mm.protocal.c.lg;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.LinkedList;

public final class t extends l implements k {
    private final b diG;
    private e diJ;
    public LinkedList<CardInfo> hxb = new LinkedList();

    public t(LinkedList<lg> linkedList, bqs bqs, int i) {
        a aVar = new a();
        aVar.dIG = new fu();
        aVar.dIH = new fv();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.dIF = 699;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        fu fuVar = (fu) this.diG.dID.dIL;
        fuVar.dzs = linkedList;
        fuVar.qZR = bqs;
        fuVar.cae = i;
    }

    public final int getType() {
        return 699;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((fv) this.diG.dIE.dIL).hwU;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.diJ.a(4, -1, null, this);
                return;
            }
            Collection xO = f.xO(obj);
            if (xO != null) {
                com.tencent.mm.plugin.card.d.l.azQ();
                this.hxb.addAll(xO);
            }
            this.diJ.a(0, 0, str, this);
            return;
        }
        x.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }
}
