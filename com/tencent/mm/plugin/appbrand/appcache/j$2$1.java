package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.aq.a;
import com.tencent.mm.plugin.appbrand.appcache.base.b$a$a;
import com.tencent.mm.plugin.appbrand.appcache.j.2;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class j$2$1 implements a {
    final /* synthetic */ 2 ffF;

    j$2$1(2 2) {
        this.ffF = 2;
    }

    public final /* bridge */ /* synthetic */ void a(k kVar) {
    }

    public final /* synthetic */ void a(String str, b$a$a b_a_a, Object obj) {
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "MockLibInfo Download Result %s", new Object[]{b_a_a});
        if (b_a_a != b$a$a.OK) {
            j.a(this.ffF.ffE, "Download MockLibInfo Error: " + b_a_a.name());
        } else {
            ah.A(new 1(this));
        }
    }
}
