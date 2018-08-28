package com.tencent.mm.plugin.freewifi.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.freewifi.d.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.bi;

class a$1 implements e {
    final /* synthetic */ a jjB;

    a$1(a aVar) {
        this.jjB = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = ((b) lVar).mac;
        if (!m.isEmpty(str2)) {
            if (i2 == -30011) {
                this.jjB.jjz.put(str2.hashCode(), Long.valueOf(bi.VF()));
            } else {
                this.jjB.jjz.remove(str2.hashCode());
            }
        }
    }
}
