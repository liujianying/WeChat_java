package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ae extends e {
    public int kpo;
    public long kpp;

    public a$ae() {
        this.kpo = 0;
        this.kpp = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.kpo != 0) {
            bVar.aE(1, this.kpo);
        }
        if (this.kpp != 0) {
            bVar.j(2, this.kpp);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.kpo != 0) {
            sl += b.aG(1, this.kpo);
        }
        return this.kpp != 0 ? sl + b.l(2, this.kpp) : sl;
    }
}
