package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$k extends e {
    public String groupId;
    public int kpU;
    public int netType;
    public int oLB;
    public long oLC;
    public int vcO;

    public a$k() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.kpU = -1;
        this.vcO = 0;
        this.netType = 0;
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
        if (this.kpU != -1) {
            bVar.aE(4, this.kpU);
        }
        if (this.vcO != 0) {
            bVar.aF(5, this.vcO);
        }
        if (this.netType != 0) {
            bVar.aF(6, this.netType);
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
        if (this.kpU != -1) {
            sl += b.aG(4, this.kpU);
        }
        if (this.vcO != 0) {
            sl += b.aH(5, this.vcO);
        }
        if (this.netType != 0) {
            return sl + b.aH(6, this.netType);
        }
        return sl;
    }
}
