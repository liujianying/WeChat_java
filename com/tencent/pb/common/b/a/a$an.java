package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$an extends e {
    public long edJ;
    public int egS;
    public int veB;

    public a$an() {
        this.edJ = 0;
        this.egS = 0;
        this.veB = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.edJ != 0) {
            bVar.i(1, this.edJ);
        }
        if (this.egS != 0) {
            bVar.aF(2, this.egS);
        }
        if (this.veB != 0) {
            bVar.aF(3, this.veB);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.edJ != 0) {
            sl += b.k(1, this.edJ);
        }
        if (this.egS != 0) {
            sl += b.aH(2, this.egS);
        }
        if (this.veB != 0) {
            return sl + b.aH(3, this.veB);
        }
        return sl;
    }
}
