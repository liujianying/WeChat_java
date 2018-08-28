package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$g extends e {
    public int aAk;
    public String groupId;
    public int oLB;
    public long oLC;
    public String vcI;

    public a$g() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.aAk = 0;
        this.vcI = "";
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.oLB != 0) {
            bVar.aE(2, this.oLB);
        }
        if (this.oLC != 0) {
            bVar.j(3, this.oLC);
        }
        if (this.aAk != 0) {
            bVar.aE(4, this.aAk);
        }
        if (!this.vcI.equals("")) {
            bVar.g(5, this.vcI);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (!this.groupId.equals("")) {
            sl += b.h(1, this.groupId);
        }
        if (this.oLB != 0) {
            sl += b.aG(2, this.oLB);
        }
        if (this.oLC != 0) {
            sl += b.l(3, this.oLC);
        }
        if (this.aAk != 0) {
            sl += b.aG(4, this.aAk);
        }
        if (this.vcI.equals("")) {
            return sl;
        }
        return sl + b.h(5, this.vcI);
    }
}
