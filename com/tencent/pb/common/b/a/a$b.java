package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$b extends e {
    public int aAk;
    public String vcI;

    public a$b() {
        this.vcI = "";
        this.aAk = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.vcI.equals("")) {
            bVar.g(1, this.vcI);
        }
        if (this.aAk != 0) {
            bVar.aE(2, this.aAk);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (!this.vcI.equals("")) {
            sl += b.h(1, this.vcI);
        }
        if (this.aAk != 0) {
            return sl + b.aG(2, this.aAk);
        }
        return sl;
    }
}
