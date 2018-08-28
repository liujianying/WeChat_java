package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.c.c.a;
import java.util.List;

class c$2 implements a {
    final /* synthetic */ c bbu;

    c$2(c cVar) {
        this.bbu = cVar;
    }

    public final void v(List<c.a> list) {
        for (c.a aVar : list) {
            c.a(this.bbu, c.k(aVar.aXv, aVar.bbv));
        }
        c.a(this.bbu).countDown();
    }
}
