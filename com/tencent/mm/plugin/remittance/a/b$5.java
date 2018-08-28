package com.tencent.mm.plugin.remittance.a;

import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.remittance.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$5 extends c<mp> {
    final /* synthetic */ b mtR;

    b$5(b bVar) {
        this.mtR = bVar;
        this.sFo = mp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mp mpVar = (mp) bVar;
        x.i("MicroMsg.SubCoreRemittance", "do insert delay transfer record: %s, %s", new Object[]{Long.valueOf(mpVar.bXy.bJC), mpVar.bXy.bXz});
        if (mpVar.bXy.bXA != null) {
            if (mpVar.bXy.bXA.dxy == 5) {
                a aVar = new a();
                aVar.field_msgId = mpVar.bXy.bJC;
                aVar.field_transferId = mpVar.bXy.bXz;
                b.bqQ();
                b.bqR().b(aVar);
            }
            com.tencent.mm.plugin.remittance.b.c Kx = b.bqS().Kx(mpVar.bXy.bXz);
            if (Kx != null) {
                Kx.field_receiveStatus = mpVar.bXy.bXA.dxy;
                b.bqS().a(Kx);
            } else if (!((i) g.l(i.class)).bcY().dW(mpVar.bXy.bJC).field_talker.equals(q.GF())) {
                Kx = new com.tencent.mm.plugin.remittance.b.c();
                Kx.field_locaMsgId = mpVar.bXy.bJC;
                Kx.field_transferId = mpVar.bXy.bXA.dxB;
                Kx.field_receiveStatus = mpVar.bXy.bXA.dxy;
                Kx.field_isSend = false;
                b.bqS().a(Kx);
            }
        }
        return false;
    }
}
