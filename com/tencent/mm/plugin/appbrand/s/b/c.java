package com.tencent.mm.plugin.appbrand.s.b;

import com.tencent.mm.plugin.appbrand.s.e.a;
import com.tencent.mm.plugin.appbrand.s.e.b;

public class c extends b {
    public final int c(a aVar) {
        if (f(aVar) == 13) {
            return a$b.gDw;
        }
        return a$b.gDx;
    }

    public final b a(b bVar) {
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        return bVar;
    }

    public a aoI() {
        return new c();
    }
}
