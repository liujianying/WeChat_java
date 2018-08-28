package com.tencent.d.b.f;

import com.tencent.d.b.a.e;

class d$1 implements Runnable {
    final /* synthetic */ e vmn;
    final /* synthetic */ d vmo;

    d$1(d dVar, e eVar) {
        this.vmo = dVar;
        this.vmn = eVar;
    }

    public final void run() {
        d dVar = this.vmo;
        e eVar = this.vmn;
        if (dVar.vmm != null && !dVar.vlZ) {
            dVar.vmm.a(eVar);
            dVar.vlZ = true;
        }
    }
}
