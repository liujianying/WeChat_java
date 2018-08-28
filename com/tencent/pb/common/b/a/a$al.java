package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$al extends e {
    public byte[] buffer;
    public int siI;

    public a$al() {
        this.siI = 0;
        this.buffer = g.bfW;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        bVar.aF(1, this.siI);
        if (!Arrays.equals(this.buffer, g.bfW)) {
            bVar.b(2, this.buffer);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl() + b.aH(1, this.siI);
        if (Arrays.equals(this.buffer, g.bfW)) {
            return sl;
        }
        return sl + b.c(2, this.buffer);
    }
}
