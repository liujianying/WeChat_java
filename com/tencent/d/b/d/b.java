package com.tencent.d.b.d;

import com.tencent.d.a.c.e;
import com.tencent.d.b.f.g;

public final class b {
    int vlU;
    String vlV;
    boolean vlW;
    boolean vlX;
    private a vlY;
    private boolean vlZ;

    /* synthetic */ b(int i, String str, boolean z, boolean z2, a aVar, byte b) {
        this(i, str, z, z2, aVar);
    }

    static /* synthetic */ void a(b bVar, e eVar) {
        if (!(bVar.vlY == null || bVar.vlZ)) {
            if (eVar == null) {
                bVar.vlY.onError(-1, "unknown");
            } else if (eVar.isSuccess()) {
                bVar.vlY.onSuccess();
            } else {
                bVar.vlY.onError(eVar.errCode, eVar.Yy);
            }
        }
        bVar.vlZ = true;
    }

    private b(int i, String str, boolean z, boolean z2, a aVar) {
        this.vlU = 0;
        this.vlV = "";
        this.vlW = false;
        this.vlX = false;
        this.vlY = null;
        this.vlZ = false;
        this.vlU = i;
        this.vlV = str;
        this.vlW = z;
        this.vlX = z2;
        this.vlY = aVar;
    }

    public final void cFU() {
        g.cGb().C(new 1(this));
    }
}
