package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.c.a.c.a.4;
import com.tencent.tinker.c.a.c.c;
import java.io.ByteArrayOutputStream;

public final class a extends i<com.tencent.tinker.a.a.a> {
    private com.tencent.tinker.a.a.t.a vqy = null;
    private i$e vqz = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGx();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.a aVar2 = (com.tencent.tinker.a.a.a) comparable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(aVar2.vod.data.length);
        new com.tencent.tinker.c.a.c.a.a(aVar, new 4(aVar, byteArrayOutputStream)).b(new m(aVar2.vod, 29));
        return new com.tencent.tinker.a.a.a(aVar2.off, aVar2.voc, new k(aVar2.vod.off, byteArrayOutputStream.toByteArray()));
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.a aVar = (com.tencent.tinker.a.a.a) comparable;
        com.tencent.tinker.a.a.t.a aVar2 = this.vqy;
        aVar2.size++;
        return this.vqz.a(aVar);
    }

    public a(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqy = iVar2.voQ.vpz;
            this.vqz = iVar2.a(this.vqy);
        }
    }

    protected final com.tencent.tinker.a.a.t.a c(i iVar) {
        return iVar.voQ.vpz;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrL.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vrZ.HR(i2);
        }
    }
}
