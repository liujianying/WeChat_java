package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.bkg;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public class v$a extends d implements b {
    public bkg qXa = new bkg();

    public final byte[] Ie() {
        this.qXa.shX = k.a(this);
        return this.qXa.toByteArray();
    }

    public final int getCmdId() {
        return 42;
    }

    public final int If() {
        return 131;
    }
}
