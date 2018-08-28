package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;

class d$7 implements a {
    final /* synthetic */ d iam;

    d$7(d dVar) {
        this.iam = dVar;
    }

    public final void a(String str, l lVar) {
        if (str != null && str.length() > 0 && "event_updated".equals(str)) {
            d.aCI();
        }
    }
}
