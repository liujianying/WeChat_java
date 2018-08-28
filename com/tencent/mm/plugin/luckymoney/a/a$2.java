package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.mm.g.a.tm;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g$a;

class a$2 extends c<tm> {
    final /* synthetic */ a kKK;

    a$2(a aVar) {
        this.kKK = aVar;
        this.sFo = tm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tm tmVar = (tm) bVar;
        if (!bi.oW(tmVar.ceZ.bWW)) {
            g$a gp = g$a.gp(tmVar.ceZ.bWW);
            if (!bi.oW(gp.dyc)) {
                x.i("MicroMsg.SubCoreLuckyMoney", "receive lucky money: %s", new Object[]{gp.dyc});
                y Pk = o.bOT().Pk(gp.dyc);
                if (Pk == null) {
                    Pk = new y();
                }
                if (bi.oW(Pk.field_mNativeUrl)) {
                    Pk.field_mNativeUrl = gp.dyc;
                    Pk.field_receiveStatus = 0;
                }
                o.bOT().a(Pk);
            }
        }
        return false;
    }
}
