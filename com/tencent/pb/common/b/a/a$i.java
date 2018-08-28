package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$i extends e {
    public int action;
    public String groupId;
    public int kpo;
    public long kpp;
    public long timestamp;

    public a$i() {
        this.action = 0;
        this.kpo = 0;
        this.kpp = 0;
        this.groupId = "";
        this.timestamp = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        bVar.aF(1, this.action);
        bVar.aE(2, this.kpo);
        bVar.j(3, this.kpp);
        if (!this.groupId.equals("")) {
            bVar.g(4, this.groupId);
        }
        if (this.timestamp != 0) {
            bVar.i(5, this.timestamp);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = ((super.sl() + b.aH(1, this.action)) + b.aG(2, this.kpo)) + b.l(3, this.kpp);
        if (!this.groupId.equals("")) {
            sl += b.h(4, this.groupId);
        }
        return this.timestamp != 0 ? sl + b.k(5, this.timestamp) : sl;
    }
}
