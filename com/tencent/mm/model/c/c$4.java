package com.tencent.mm.model.c;

import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;

class c$4 implements a {
    final /* synthetic */ c dEF;

    c$4(c cVar) {
        this.dEF = cVar;
    }

    public final void a(f fVar, g gVar, boolean z) {
        if (z) {
            if (fVar != null && (fVar instanceof i.a) && fVar.qWw == 12) {
                b.Jr();
            }
        } else if (fVar != null && fVar.qWw == 16) {
            b.Jr();
        }
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
    }
}
