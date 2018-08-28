package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public class r$a extends d implements b {
    public avx qWU = new avx();

    public final byte[] Ie() {
        this.qWU.shX = k.a(this);
        return this.qWU.toByteArray();
    }

    public final int If() {
        return 139;
    }

    public final int getCmdId() {
        return 27;
    }
}
