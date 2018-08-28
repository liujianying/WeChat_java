package com.tencent.mm.plugin.appbrand.appcache.a;

import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class a$2 implements a<Void, Boolean> {
    final /* synthetic */ Runnable fiA;

    public a$2(Runnable runnable) {
        this.fiA = runnable;
    }

    public final /* synthetic */ Object call(Object obj) {
        this.fiA.run();
        g.cBF().ct(Boolean.valueOf(true));
        return uQG;
    }
}
