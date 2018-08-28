package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$y extends e {
    public String vcI;

    public a$y() {
        this.vcI = "";
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.vcI.equals("")) {
            bVar.g(1, this.vcI);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vcI.equals("")) {
            return sl;
        }
        return sl + b.h(1, this.vcI);
    }
}
