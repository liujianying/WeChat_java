package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.protocal.c.bno;
import java.util.Iterator;

class w$2 implements Iterator<Object[]> {
    final Object[] fmG = new Object[3];
    final /* synthetic */ w fmI;
    final Iterator<bno> fmJ = this.fmK.rKL.iterator();
    final /* synthetic */ ahn fmK;

    w$2(w wVar, ahn ahn) {
        this.fmI = wVar;
        this.fmK = ahn;
    }

    public final /* synthetic */ Object next() {
        bno bno = (bno) this.fmJ.next();
        this.fmG[0] = bno.username;
        this.fmG[1] = Integer.valueOf(bno.rRb);
        this.fmG[2] = Integer.valueOf(bno.riv);
        return this.fmG;
    }

    public final boolean hasNext() {
        return this.fmJ.hasNext();
    }

    public final void remove() {
    }
}
