package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends c<mi> implements e {
    private mi eXK;
    private d eXL;

    public k() {
        this.sFo = mi.class.getName().hashCode();
    }

    private boolean a(mi miVar) {
        if (miVar instanceof mi) {
            this.eXK = miVar;
            au.DF().a(417, this);
            au.DF().a(new e(this.eXK.bXa.url, this.eXK.bXa.appId, 1), 0);
        }
        return true;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.RcptGetAddrEventListener", "onSceneEnd errType[%s], errCode[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (!(lVar instanceof e)) {
            return;
        }
        if (i2 == 0) {
            A(i2, true);
        } else {
            A(i2, false);
        }
    }

    private void A(int i, boolean z) {
        x.d("MicroMsg.RcptGetAddrEventListener", "setResult errCode[%s], isAccept[%s]", new Object[]{Integer.valueOf(i), Boolean.valueOf(z)});
        this.eXK.bXb.errCode = i;
        d dVar;
        if (i != 0) {
            this.eXK.bXb.bXc = false;
        } else if (z) {
            dVar = this.eXL;
            if (dVar != null) {
                dVar.field_brandFlag |= 8;
                f.g(dVar);
            }
            this.eXK.bXb.bXc = true;
            a.Zv();
            com.tencent.mm.plugin.address.d.a aVar = a.Zx().eXO;
            if (aVar.eXW.size() > 0) {
                b bVar = (b) aVar.eXW.getFirst();
                this.eXK.bXb.bXd = bVar.eYf;
                this.eXK.bXb.userName = bVar.eYd;
                this.eXK.bXb.bXe = bVar.eYe;
                this.eXK.bXb.bXf = bVar.eYb;
                this.eXK.bXb.bXg = bVar.eXY;
                this.eXK.bXb.bXh = bVar.eXZ;
                this.eXK.bXb.bXi = bVar.eYa;
                this.eXK.bXb.bXj = bVar.eYc;
            }
        } else {
            dVar = this.eXL;
            if (dVar != null) {
                dVar.field_brandFlag &= -9;
                f.g(dVar);
            }
            this.eXK.bXb.bXc = false;
        }
        if (this.eXK.bJX != null) {
            this.eXK.bJX.run();
        }
        au.DF().b(417, this);
    }
}
