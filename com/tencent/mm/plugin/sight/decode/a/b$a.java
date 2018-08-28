package com.tencent.mm.plugin.sight.decode.a;

import com.tencent.mm.g.a.rz;
import com.tencent.mm.sdk.b.c;
import java.lang.ref.WeakReference;

class b$a extends c<rz> {
    int iYO = 0;
    int ncV = 0;
    int ncW = 0;
    WeakReference<b> ncX;

    public b$a(b bVar) {
        super(0);
        this.ncX = new WeakReference(bVar);
        this.sFo = rz.class.getName().hashCode();
    }

    private void a(rz rzVar) {
        this.ncV = rzVar.ccO.ccR;
        this.ncW = rzVar.ccO.ccP;
        this.iYO = rzVar.ccO.ccQ;
    }

    private boolean bvN() {
        if (this.ncX.get() == null) {
            return false;
        }
        int D = b.D((b) this.ncX.get()) + this.ncV;
        if (D < this.ncW || D > this.iYO) {
            return false;
        }
        return true;
    }
}
