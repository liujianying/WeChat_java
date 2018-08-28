package com.tencent.mm.plugin.biz;

import com.tencent.mm.ac.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.h;
import com.tencent.mm.model.j;
import com.tencent.mm.plugin.biz.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.ui.applet.d;
import com.tencent.mm.pluginsdk.ui.applet.p;
import java.util.HashMap;

public class PluginBiz extends f implements a, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(o.class);
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.a(com.tencent.mm.ac.o.class, new e(new l()));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.biz.a.a.class, new a());
        }
        p.a.qJH = new d();
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            pin(new com.tencent.mm.model.p(z.class));
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.f.class, new com.tencent.mm.model.g());
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.g.class, new h());
            com.tencent.mm.kernel.g.a(com.tencent.mm.api.h.class, new j());
        }
    }

    public HashMap<Integer, com.tencent.mm.bt.h.d> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.bt.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("BIZ_MESSAGE_TABLE".hashCode()), new 1(this));
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_TABLE".hashCode()), new 2(this));
        hashMap.put(Integer.valueOf("BIZ_TIME_LINE_SINGLE_MSG_TABLE".hashCode()), new 3(this));
        return hashMap;
    }
}
