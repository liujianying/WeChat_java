package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.plugin.fts.b.a.u;
import com.tencent.mm.plugin.fts.b.a.v;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bi;

class a$4 implements a {
    final /* synthetic */ a jtJ;

    a$4(a aVar) {
        this.jtJ = aVar;
    }

    public final void a(String str, l lVar) {
        String[] split = str.split(" ");
        if (split != null && split.length != 0 && split[0].equals("update")) {
            for (int i = 1; i < split.length; i++) {
                a.e(this.jtJ).a(65554, new v(this.jtJ, bi.getLong(split[i], 0)));
            }
            a.e(this.jtJ).a(65556, new u(this.jtJ, (byte) 0));
        }
    }
}
