package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i$e;
import com.tencent.tinker.a.a.t.a;
import com.tencent.tinker.c.a.c.c;
import java.lang.reflect.Array;

public final class d extends i<com.tencent.tinker.a.a.d> {
    private a vqE = null;
    private i$e vqF = null;

    protected final /* synthetic */ Comparable a(com.tencent.tinker.a.a.a.a aVar) {
        return aVar.cGA();
    }

    protected final /* synthetic */ Comparable a(com.tencent.tinker.c.a.c.a aVar, Comparable comparable) {
        int i;
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        int Ib = aVar.Ib(dVar.vog);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.voh.length, 2});
        for (i = 0; i < iArr.length; i++) {
            iArr[i][0] = aVar.HX(dVar.voh[i][0]);
            iArr[i][1] = aVar.Ib(dVar.voh[i][1]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.voi.length, 2});
        for (i = 0; i < iArr2.length; i++) {
            iArr2[i][0] = aVar.HY(dVar.voi[i][0]);
            iArr2[i][1] = aVar.Ib(dVar.voi[i][1]);
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, new int[]{dVar.voj.length, 2});
        for (i = 0; i < iArr3.length; i++) {
            iArr3[i][0] = aVar.HY(dVar.voj[i][0]);
            iArr3[i][1] = aVar.Ic(dVar.voj[i][1]);
        }
        return new com.tencent.tinker.a.a.d(dVar.off, Ib, iArr, iArr2, iArr3);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.d dVar = (com.tencent.tinker.a.a.d) comparable;
        a aVar = this.vqE;
        aVar.size++;
        return this.vqF.a(dVar);
    }

    public d(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqE = iVar2.voQ.vpB;
            this.vqF = iVar2.a(this.vqE);
        }
    }

    protected final a c(i iVar) {
        return iVar.voQ.vpB;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrO.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vsc.HR(i2);
        }
    }
}
