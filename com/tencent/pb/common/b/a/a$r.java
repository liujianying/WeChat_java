package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.am;

public final class a$r extends e {
    public am[] vdv;

    public a$r() {
        this.vdv = am.cEw();
        this.bfP = -1;
    }

    public final void a(b bVar) {
        if (this.vdv != null && this.vdv.length > 0) {
            for (e eVar : this.vdv) {
                if (eVar != null) {
                    bVar.a(1, eVar);
                }
            }
        }
        super.a(bVar);
    }

    protected final int sl() {
        int sl = super.sl();
        if (this.vdv != null && this.vdv.length > 0) {
            for (e eVar : this.vdv) {
                if (eVar != null) {
                    sl += b.b(1, eVar);
                }
            }
        }
        return sl;
    }
}
