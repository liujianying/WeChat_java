package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.b.a.d;
import com.tencent.mm.plugin.fts.b.a.e;
import com.tencent.mm.plugin.fts.b.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class a$2 implements b {
    final /* synthetic */ a jtJ;

    a$2(a aVar) {
        this.jtJ = aVar;
    }

    public final void a(int i, m mVar, Object obj) {
        String str = (String) obj;
        if (a.CE(str)) {
            ab Yb = ((i) g.l(i.class)).FR().Yb(str);
            if (Yb == null || a.D(Yb)) {
                switch (i) {
                    case 2:
                        a.e(this.jtJ).a(65556, new e(this.jtJ, str));
                        return;
                    case 3:
                    case 4:
                        if (!a.b(this.jtJ).containsKey(str)) {
                            a.e(this.jtJ).a(65556, new h(this.jtJ, str));
                            return;
                        }
                        return;
                    case 5:
                        a.e(this.jtJ).a(65556, new d(this.jtJ, str));
                        return;
                    default:
                        return;
                }
            }
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener hit cache and filter contact %s", new Object[]{str});
            return;
        }
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "onContactChangedListener filterByUsername %s", new Object[]{str});
    }
}
