package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ax extends e {
    public int vfQ;

    public a$ax() {
        this.vfQ = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.vfQ != 0) {
            bVar.aF(1, this.vfQ);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vfQ != 0) {
            return sl + b.aH(1, this.vfQ);
        }
        return sl;
    }
}
