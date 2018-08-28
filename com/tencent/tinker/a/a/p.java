package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int vpe;
    public int vpf;
    public int vpg;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.vpe != pVar.vpe) {
            return c.fI(this.vpe, pVar.vpe);
        }
        return this.vpf != pVar.vpf ? c.fI(this.vpf, pVar.vpf) : c.fI(this.vpg, pVar.vpg);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.vpe = i2;
        this.vpg = i3;
        this.vpf = i4;
    }
}
