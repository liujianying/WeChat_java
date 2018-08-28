package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ai extends e {
    public int ret;

    public a$ai() {
        this.ret = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.ret != 0) {
            bVar.aE(1, this.ret);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.ret != 0) {
            return sl + b.aG(1, this.ret);
        }
        return sl;
    }
}
