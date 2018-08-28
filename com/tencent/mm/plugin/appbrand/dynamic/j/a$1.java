package com.tencent.mm.plugin.appbrand.dynamic.j;

import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.b;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    public final void run() {
        for (String str : i.aeT().aeU()) {
            if (g.fF(str)) {
                f.a(str, null, b.class, null);
            } else {
                x.i("MicroMsg.DynamicPkgUpdater", "has not Connected RemoteService, abort clearCache");
                return;
            }
        }
    }
}
