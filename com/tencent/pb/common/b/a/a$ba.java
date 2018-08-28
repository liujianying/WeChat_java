package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ba extends e {
    public int type;
    public a$al vfX;

    public a$ba() {
        this.type = 0;
        this.vfX = null;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.type != 0) {
            bVar.aE(1, this.type);
        }
        if (this.vfX != null) {
            bVar.a(2, this.vfX);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.type != 0) {
            sl += b.aG(1, this.type);
        }
        if (this.vfX != null) {
            return sl + b.b(2, this.vfX);
        }
        return sl;
    }
}
