package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$h extends e {
    public String groupId;
    public String hOQ;
    public int kpo;
    public long kpp;
    public long timestamp;

    public a$h() {
        this.kpo = 0;
        this.kpp = 0;
        this.hOQ = "";
        this.groupId = "";
        this.timestamp = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        bVar.aE(1, this.kpo);
        bVar.j(2, this.kpp);
        bVar.g(3, this.hOQ);
        if (!this.groupId.equals("")) {
            bVar.g(4, this.groupId);
        }
        if (this.timestamp != 0) {
            bVar.i(5, this.timestamp);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = ((super.sl() + b.aG(1, this.kpo)) + b.l(2, this.kpp)) + b.h(3, this.hOQ);
        if (!this.groupId.equals("")) {
            sl += b.h(4, this.groupId);
        }
        return this.timestamp != 0 ? sl + b.k(5, this.timestamp) : sl;
    }
}
