package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.dynamic.b.e;
import com.tencent.mm.plugin.appbrand.dynamic.i.b;
import com.tencent.mm.sdk.platformtools.x;

class a$b implements a<Bundle, Bundle> {
    private a$b() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        e.removeAll();
        x.v("MicroMsg.DynamicPkgUpdater", "clearCache");
        b.afy();
    }
}
