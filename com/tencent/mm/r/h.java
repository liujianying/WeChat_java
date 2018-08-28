package com.tencent.mm.r;

import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.p;

public final class h extends p implements c {
    private static h diN;

    public static synchronized h Ce() {
        h hVar;
        synchronized (h.class) {
            if (diN == null) {
                diN = new h();
            }
            hVar = diN;
        }
        return hVar;
    }

    private h() {
        super(i.class);
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
    }
}
