package com.tencent.mm.plugin.aa;

import com.tencent.mm.g.a.th;
import com.tencent.mm.plugin.aa.a.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$6 extends c<th> {
    final /* synthetic */ b ezx;

    b$6(b bVar) {
        this.ezx = bVar;
        this.sFo = th.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i;
        th thVar = (th) bVar;
        String str = thVar.ceM.ceO;
        th.b bVar2 = thVar.ceN;
        d VQ = b.VQ();
        if (d.eBb.containsKey(str)) {
            i = ((com.tencent.mm.plugin.aa.a.b.c) d.eBb.get(str)).field_status;
        } else {
            com.tencent.mm.plugin.aa.a.b.c pe = VQ.pe(str);
            if (pe != null) {
                d.eBb.put(str, pe);
                i = pe.field_status;
            } else {
                i = -1;
            }
        }
        bVar2.status = i;
        return false;
    }
}
