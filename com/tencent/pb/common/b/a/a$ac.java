package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.at;

public final class a$ac extends e {
    public String groupId;
    public at vcK;
    public int ven;

    public a$ac() {
        this.groupId = "";
        this.vcK = null;
        this.ven = 0;
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (!this.groupId.equals("")) {
            bVar.g(1, this.groupId);
        }
        if (this.vcK != null) {
            bVar.a(2, this.vcK);
        }
        if (this.ven != 0) {
            bVar.aE(3, this.ven);
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (!this.groupId.equals("")) {
            sl += b.h(1, this.groupId);
        }
        if (this.vcK != null) {
            sl += b.b(2, this.vcK);
        }
        if (this.ven != 0) {
            return sl + b.aG(3, this.ven);
        }
        return sl;
    }
}
