package com.tencent.mm.plugin.b;

import com.tencent.mm.model.c.c;
import com.tencent.mm.model.p;

public final class b extends p {
    private static b eEx;

    private b() {
        super(c.class);
    }

    public static synchronized b WC() {
        b bVar;
        synchronized (b.class) {
            if (eEx == null) {
                eEx = new b();
            }
            bVar = eEx;
        }
        return bVar;
    }

    public final void gj(String str) {
        super.gj(str);
    }
}
