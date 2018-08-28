package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd.d;

public final class c$i extends c<mg> {
    final /* synthetic */ c mjy;

    c$i(c cVar) {
        this.mjy = cVar;
    }

    public final /* synthetic */ boolean a(b bVar) {
        mg mgVar = (mg) bVar;
        e.i(mgVar, "event");
        String str = mgVar.bWU.bWW;
        ab a = c.a(d.YY(str));
        c.a(this.mjy, a);
        c cVar = this.mjy;
        e.h(str, "msgContent");
        c.a(cVar, a, str);
        a l = g.l(i.class);
        e.h(l, "service(IMessengerStorage::class.java)");
        ay FR = ((i) l).FR();
        if (!FR.Yi(a.wR())) {
            FR.S(a);
        }
        c.b bVar2 = c.mju;
        x.d(c.access$getTAG$cp(), "receive verify mssage %s, encypt %s", a.getUsername(), a.wR());
        c.b(this.mjy, a);
        return false;
    }
}
