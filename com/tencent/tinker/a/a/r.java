package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int vph;
    public int vpi;
    public int vpj;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int fI = c.fI(this.vph, rVar.vph);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.vpi, rVar.vpi);
        return fI == 0 ? c.fJ(this.vpj, rVar.vpj) : fI;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.vph = i2;
        this.vpi = i3;
        this.vpj = i4;
    }
}
