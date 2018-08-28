package com.tencent.mm.plugin.p;

import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.storage.bc;

public final class b extends p {
    private static b knx;

    private b() {
        super(o.class);
    }

    public static synchronized b aWB() {
        b bVar;
        synchronized (b.class) {
            if (knx == null) {
                knx = new b();
            }
            bVar = knx;
        }
        return bVar;
    }

    public static bc FY() {
        g.Eg().Ds();
        return ((a) g.l(a.class)).FY();
    }
}
