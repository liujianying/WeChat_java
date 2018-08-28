package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ap extends e {
    public int veE;
    public int veF;

    public a$ap() {
        this.veE = 0;
        this.veF = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.veE != 0) {
            bVar.aE(1, this.veE);
        }
        if (this.veF != 0) {
            bVar.aE(2, this.veF);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.veE != 0) {
            sl += b.aG(1, this.veE);
        }
        if (this.veF != 0) {
            return sl + b.aG(2, this.veF);
        }
        return sl;
    }
}
