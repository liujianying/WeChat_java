package com.tencent.mm.plugin.k;

import com.tencent.mm.model.p;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.platformtools.ah;

public final class a extends p implements com.tencent.mm.plugin.auth.a.a {
    private static a hJQ;

    private a() {
        super(g.class);
    }

    public static synchronized a aAf() {
        a aVar;
        synchronized (a.class) {
            if (hJQ == null) {
                hJQ = new a();
            }
            aVar = hJQ;
        }
        return aVar;
    }

    public final void a(f fVar, i.g gVar, boolean z) {
    }

    public final void a(b bVar, String str, int i, String str2, String str3, int i2) {
        if (bVar.qWZ.iwE != 0) {
            ah.A(new 1(bVar.qWZ.roC, bVar.qWZ.roD, bVar.qWZ.roE));
        }
    }
}
