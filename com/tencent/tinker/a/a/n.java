package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int vos;
    public int vpe;
    public int vpf;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.vpe != nVar.vpe) {
            return c.fI(this.vpe, nVar.vpe);
        }
        return this.vpf != nVar.vpf ? c.fI(this.vpf, nVar.vpf) : c.fI(this.vos, nVar.vos);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.vpe = i2;
        this.vos = i3;
        this.vpf = i4;
    }
}
