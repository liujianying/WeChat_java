package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ay extends e {
    public int oLB;
    public long oLC;
    public int vfR;

    public a$ay() {
        this.oLB = 0;
        this.oLC = 0;
        this.vfR = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.oLB != 0) {
            bVar.aE(1, this.oLB);
        }
        if (this.oLC != 0) {
            bVar.j(2, this.oLC);
        }
        if (this.vfR != 0) {
            bVar.aF(3, this.vfR);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.oLB != 0) {
            sl += b.aG(1, this.oLB);
        }
        if (this.oLC != 0) {
            sl += b.l(2, this.oLC);
        }
        if (this.vfR != 0) {
            return sl + b.aH(3, this.vfR);
        }
        return sl;
    }
}
