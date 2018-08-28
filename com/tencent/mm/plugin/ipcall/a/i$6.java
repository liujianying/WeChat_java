package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.g.a.ih;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class i$6 extends c<ih> {
    final /* synthetic */ i kpj;

    i$6(i iVar) {
        this.kpj = iVar;
        this.sFo = ih.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ih ihVar = (ih) bVar;
        if (ihVar instanceof ih) {
            if (ihVar.bRN.bRQ && i.a(this.kpj) == ihVar.bRN.bRP && i.b(this.kpj) != null) {
                i.a(this.kpj, null);
                i.a(this.kpj, 0);
            }
            if (!ihVar.bRN.bRQ) {
                if (ihVar.bRN.bRP == 0) {
                    i.a(this.kpj, null);
                    i.a(this.kpj, 0);
                } else {
                    i.a(this.kpj, ihVar.bRN.bRO);
                    i.a(this.kpj, ihVar.bRN.bRP);
                }
            }
        }
        return false;
    }
}
