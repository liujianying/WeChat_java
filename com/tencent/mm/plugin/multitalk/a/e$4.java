package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.g.a.jr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class e$4 extends c<jr> {
    final /* synthetic */ e ltL;

    e$4(e eVar) {
        this.ltL = eVar;
        this.sFo = jr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jr jrVar = (jr) bVar;
        if (jrVar instanceof jr) {
            jr.b bVar2;
            boolean bgl;
            switch (jrVar.bTt.action) {
                case 1:
                    bVar2 = jrVar.bTu;
                    bgl = this.ltL.bgl();
                    break;
                case 2:
                    bVar2 = jrVar.bTu;
                    e eVar = this.ltL;
                    if (eVar.ltC == null) {
                        bgl = false;
                        break;
                    }
                    bgl = eVar.ltC.bfL();
                    break;
            }
            bVar2.bTv = bgl;
        }
        return false;
    }
}
