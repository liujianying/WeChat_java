package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c {
    public long hjj = -1;
    public short isC = (short) -1;
    public e isD = null;
    protected a isE = null;

    public abstract short aGA();

    public abstract short aGB();

    public abstract byte[] aGC();

    protected final e X(int i, String str) {
        this.isD = new e();
        this.isD.iwS = i;
        this.isD.iwT = str;
        return this.isD;
    }
}
