package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] vok;
    public a[] vol;
    public b[] vom;
    public b[] von;

    public static class a implements Comparable<a> {
        public int voo;
        public int vop;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int fI = c.fI(this.voo, aVar.voo);
            return fI != 0 ? fI : c.fJ(this.vop, aVar.vop);
        }

        public a(int i, int i2) {
            this.voo = i;
            this.vop = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int vop;
        public int voq;
        public int vor;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int fI = c.fI(this.voq, bVar.voq);
            if (fI != 0) {
                return fI;
            }
            fI = c.fJ(this.vop, bVar.vop);
            return fI == 0 ? c.fJ(this.vor, bVar.vor) : fI;
        }

        public b(int i, int i2, int i3) {
            this.voq = i;
            this.vop = i2;
            this.vor = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.vok, eVar.vok);
        if (a != 0) {
            return a;
        }
        a = c.a(this.vol, eVar.vol);
        if (a != 0) {
            return a;
        }
        a = c.a(this.vom, eVar.vom);
        return a == 0 ? c.a(this.von, eVar.von) : a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.vok = aVarArr;
        this.vol = aVarArr2;
        this.vom = bVarArr;
        this.von = bVarArr2;
    }
}
