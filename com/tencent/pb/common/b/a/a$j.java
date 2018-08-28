package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.pb.common.b.a.a.ba;
import java.util.Arrays;

public final class a$j extends e {
    public String groupId;
    public int oLB;
    public long oLC;
    public ba vcM;
    public int vcO;
    public byte[] vcY;

    public a$j() {
        this.groupId = "";
        this.oLB = 0;
        this.oLC = 0;
        this.vcM = null;
        this.vcO = 0;
        this.vcY = g.bfW;
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
        if (this.vcM != null) {
            bVar.a(4, this.vcM);
        }
        if (this.vcO != 0) {
            bVar.aF(5, this.vcO);
        }
        if (!Arrays.equals(this.vcY, g.bfW)) {
            bVar.b(200, this.vcY);
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
        if (this.vcM != null) {
            sl += b.b(4, this.vcM);
        }
        if (this.vcO != 0) {
            sl += b.aH(5, this.vcO);
        }
        if (Arrays.equals(this.vcY, g.bfW)) {
            return sl;
        }
        return sl + b.c(200, this.vcY);
    }
}
