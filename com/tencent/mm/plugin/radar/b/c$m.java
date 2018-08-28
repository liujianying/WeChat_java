package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;

public final class c$m implements d {
    final /* synthetic */ long mjF;
    final /* synthetic */ String mjN;
    final /* synthetic */ c mjy;

    public c$m(c cVar, String str, long j) {
        this.mjy = cVar;
        this.mjN = str;
        this.mjF = j;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        boolean z3;
        b bVar;
        if (z) {
            a l = g.l(i.class);
            e.h(l, "service(IMessengerStorage::class.java)");
            ab Yg = ((i) l).FR().Yg(str);
            if (Yg == null || Yg.BJ() == 0) {
                ab a = c.a(bd.d.YY(this.mjN));
                l = g.l(i.class);
                e.h(l, "service(IMessengerStorage::class.java)");
                if (!((i) l).FR().T(a)) {
                    bVar = c.mju;
                    x.e(c.access$getTAG$cp(), "canAddContact fail, insert fail");
                    z = false;
                }
                l = g.l(i.class);
                e.h(l, "service(IMessengerStorage::class.java)");
                Yg = ((i) l).FR().Yg(a.getUsername());
            }
            b bVar2 = c.mju;
            x.d(c.access$getTAG$cp(), "verifyContact return ok");
            s.p(Yg);
            c.bW(str, 1);
            z3 = z;
        } else {
            bVar = c.mju;
            x.d(c.access$getTAG$cp(), "verifyContact return not ok");
            z3 = z;
        }
        c.a(this.mjy, z3, str2, str, this.mjF);
    }
}
