package com.tencent.c.a;

import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.d;
import com.tencent.c.e.a.c;

class d$1 implements c {
    final /* synthetic */ b vhQ;
    final /* synthetic */ com.tencent.c.b.c vhR;

    public d$1(b bVar, com.tencent.c.b.c cVar) {
        this.vhQ = bVar;
        this.vhR = cVar;
    }

    public final void ZZ() {
        this.vhQ.o(-10, new byte[0]);
    }

    public final d a(String str, String str2, a aVar) {
        boolean a = d.a(this.vhR, this.vhQ, str, str2, aVar);
        d dVar = new d();
        if (!a) {
            dVar.errorCode = -1;
        }
        return dVar;
    }

    public final com.tencent.c.e.a.b.c b(String str, String str2, a aVar) {
        boolean a = d.a(this.vhR, this.vhQ, str, str2, aVar);
        com.tencent.c.e.a.b.c cVar = new com.tencent.c.e.a.b.c();
        if (!a) {
            cVar.errCode = -1;
        }
        return cVar;
    }
}
