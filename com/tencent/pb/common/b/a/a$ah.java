package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.au;

public final class a$ah extends e {
    public au[] vex;

    public a$ah() {
        this.vex = au.cEz();
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.vex != null && this.vex.length > 0) {
            for (e eVar : this.vex) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vex != null && this.vex.length > 0) {
            for (e eVar : this.vex) {
                if (eVar != null) {
                    sl += b.b(1, eVar);
                }
            }
        }
        return sl;
    }
}
