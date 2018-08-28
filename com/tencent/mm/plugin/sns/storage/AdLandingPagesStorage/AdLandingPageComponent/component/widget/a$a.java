package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import com.tencent.mm.g.a.rz;
import com.tencent.mm.sdk.b.c;
import java.lang.ref.WeakReference;

class a$a extends c<rz> {
    int iYO = 0;
    int ncV = 0;
    int ncW = 0;
    WeakReference<a> ncX;

    public a$a(a aVar) {
        super(0);
        this.ncX = new WeakReference(aVar);
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
        int D = a.D((a) this.ncX.get()) + this.ncV;
        if (D < this.ncW || D > this.iYO) {
            return false;
        }
        return true;
    }
}
