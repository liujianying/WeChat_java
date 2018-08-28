package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.a.d.b;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.launching.f.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class f$1 implements a<Void, Void> {
    final /* synthetic */ f gfF;

    f$1(f fVar) {
        this.gfF = fVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = this.gfF;
        b bVar = (b) e.x(b.class);
        String str = fVar.gfD.field_username;
        Pair v = bVar.v(str, 1, fVar.fqE);
        if (((Boolean) v.first).booleanValue()) {
            x.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "sync blocked with username(%s) scene(%d)", new Object[]{str, Integer.valueOf(fVar.fqE)});
            int i = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) ((Integer) v.second).intValue(), 164);
        } else {
            x.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] start() username %s, scene %d", new Object[]{str, Integer.valueOf(fVar.fqE)});
            r.a(fVar.gfD.field_username, true, new 2(fVar, str));
        }
        return null;
    }
}
