package com.tencent.mm.plugin.radar.b;

import b.c.b.e;
import b.c.b.m;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.Collection;
import java.util.List;

public final class c$f implements d {
    final /* synthetic */ String mjE;
    final /* synthetic */ long mjF;
    final /* synthetic */ c mjy;

    c$f(c cVar, String str, long j) {
        this.mjy = cVar;
        this.mjE = str;
        this.mjF = j;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        b bVar;
        if (z) {
            boolean contains;
            a l = g.l(i.class);
            e.h(l, "service(IMessengerStorage::class.java)");
            ab Yg = ((i) l).FR().Yg(str);
            e.h(Yg, "contact");
            if (Yg.BJ() > 0) {
                s.p(Yg);
            }
            c.bW(str, 1);
            Iterable<Object> a = c.a(this.mjy);
            e.i(a, "$receiver");
            if (a instanceof Collection) {
                contains = ((Collection) a).contains(str);
            } else {
                int indexOf;
                e.i(a, "$receiver");
                if (a instanceof List) {
                    indexOf = ((List) a).indexOf(str);
                } else {
                    indexOf = 0;
                    for (Object i : a) {
                        if (e.i(str, i)) {
                            break;
                        }
                        indexOf++;
                    }
                    indexOf = -1;
                }
                contains = indexOf >= 0;
            }
            if (contains) {
                Collection a2 = c.a(this.mjy);
                if (a2 == null) {
                    throw new b.i("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                }
                m.cK(a2).remove(str);
            }
            bVar = c.mju;
            x.d(c.access$getTAG$cp(), "addContact %s return ok", new Object[]{this.mjE});
        } else if (z2) {
            if (!(str == null || c.a(this.mjy).contains(str))) {
                c.a(this.mjy).add(str);
            }
            c.bW(str, 2);
            bVar = c.mju;
            x.d(c.access$getTAG$cp(), "addContact has sent verify to %s", new Object[]{this.mjE});
        } else {
            bVar = c.mju;
            x.d(c.access$getTAG$cp(), "addContact return not ok, user canceled or error");
        }
        c.a(this.mjy, z, z2, str2, str, this.mjF);
    }
}
