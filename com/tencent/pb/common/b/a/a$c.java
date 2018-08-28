package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.w;

public final class a$c extends e {
    public w[] vcJ;

    public a$c() {
        this.vcJ = w.cEv();
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.vcJ != null && this.vcJ.length > 0) {
            for (e eVar : this.vcJ) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vcJ != null && this.vcJ.length > 0) {
            for (e eVar : this.vcJ) {
                if (eVar != null) {
                    sl += b.b(1, eVar);
                }
            }
        }
        return sl;
    }
}
