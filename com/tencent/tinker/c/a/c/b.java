package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.c;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;

public final class b {
    final a vrD;

    public b(a aVar) {
        this.vrD = aVar;
    }

    public final short[] b(short[] sArr) {
        h hVar = new h(sArr.length);
        c cVar = new c();
        f fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(this, cVar));
            dVar.a(new a(this, fVar));
            int i = hVar.vpT;
            if (i == hVar.vqb.length) {
                return hVar.vqb;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.vqb, 0, sArr2, 0, i);
            return sArr2;
        } catch (Throwable e) {
            throw new j(e);
        }
    }
}
