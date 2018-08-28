package com.tencent.mm.plugin.card.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public final class n extends c<hz> implements e {
    private long bIZ;

    public n() {
        this.bIZ = 0;
        this.sFo = hz.class.getName().hashCode();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof af) {
            String str2 = ((af) lVar).cad;
            bd dW = ((i) g.l(i.class)).bcY().dW(this.bIZ);
            if (i == 0 && i2 == 0) {
                dW.setStatus(2);
            } else {
                dW.setStatus(5);
            }
            a gp = a.gp(dW.field_content);
            d xQ = com.tencent.mm.plugin.card.d.g.xQ(dW.field_content);
            xQ.cad = str2;
            gp.dxE = com.tencent.mm.plugin.card.d.g.a(xQ);
            gp.bRw = a.a(gp, null, null);
            dW.setContent(a.a(gp, null, null));
            ((i) g.l(i.class)).bcY().a(this.bIZ, dW);
            g.Eh().dpP.b(652, this);
        }
    }

    private boolean a(hz hzVar) {
        if (!(hzVar instanceof hz)) {
            return false;
        }
        d xQ;
        String str = hzVar.bRv.bRw;
        this.bIZ = hzVar.bRv.bIZ;
        String str2 = hzVar.bRv.bRx;
        d xQ2 = com.tencent.mm.plugin.card.d.g.xQ(str);
        bd dW = ((i) g.l(i.class)).bcY().dW(this.bIZ);
        dW.setStatus(1);
        ((i) g.l(i.class)).bcY().a(this.bIZ, dW);
        if (xQ2 == null) {
            xQ = com.tencent.mm.plugin.card.d.g.xQ(dW.field_content);
        } else {
            xQ = xQ2;
        }
        if (xQ != null) {
            g.Eh().dpP.a(652, this);
            g.Eh().dpP.a(new af(xQ.cac, str2, 17), 0);
        }
        return true;
    }
}
