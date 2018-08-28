package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i;
import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.t$a;
import com.tencent.tinker.c.a.c.a;
import com.tencent.tinker.c.a.c.b;
import com.tencent.tinker.c.a.c.c;

public final class g extends i<com.tencent.tinker.a.a.g> {
    private t$a vqK = null;
    private e vqL = null;

    protected final /* synthetic */ Comparable a(a aVar, Comparable comparable) {
        com.tencent.tinker.a.a.g.a[] aVarArr;
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        int Ig = aVar.Ig(gVar.voC);
        short[] sArr = gVar.voD;
        if (!(sArr == null || sArr.length == 0)) {
            sArr = new b(aVar).b(sArr);
        }
        com.tencent.tinker.a.a.g.a[] aVarArr2 = gVar.voF;
        if (aVarArr2 == null || aVarArr2.length == 0) {
            aVarArr = aVarArr2;
        } else {
            aVarArr = new com.tencent.tinker.a.a.g.a[aVarArr2.length];
            for (int i = 0; i < aVarArr2.length; i++) {
                com.tencent.tinker.a.a.g.a aVar2 = aVarArr2[i];
                int length = aVar2.voG.length;
                int[] iArr = new int[length];
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = aVar.HV(aVar2.voG[i2]);
                }
                aVarArr[i] = new com.tencent.tinker.a.a.g.a(iArr, aVar2.voH, aVar2.voI, aVar2.offset);
            }
        }
        return new com.tencent.tinker.a.a.g(gVar.off, gVar.voz, gVar.voA, gVar.voB, Ig, sArr, gVar.voE, aVarArr);
    }

    protected final /* synthetic */ int e(Comparable comparable) {
        com.tencent.tinker.a.a.g gVar = (com.tencent.tinker.a.a.g) comparable;
        t$a t_a = this.vqK;
        t_a.size++;
        return this.vqL.a(gVar);
    }

    public g(com.tencent.tinker.c.a.b.a aVar, i iVar, i iVar2, c cVar) {
        super(aVar, iVar, cVar);
        if (iVar2 != null) {
            this.vqK = iVar2.voQ.vpw;
            this.vqL = iVar2.a(this.vqK);
        }
    }

    protected final t$a c(i iVar) {
        return iVar.voQ.vpw;
    }

    protected final void a(c cVar, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            cVar.vrS.put(i2, i4);
        }
    }

    protected final void a(c cVar, int i, int i2) {
        if (i2 >= 0) {
            cVar.vsg.HR(i2);
        }
    }
}
