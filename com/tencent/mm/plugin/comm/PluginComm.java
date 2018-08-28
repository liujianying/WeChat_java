package com.tencent.mm.plugin.comm;

import com.tencent.mm.ipcinvoker.wx_extension.e;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.b.b;
import com.tencent.mm.plugin.comm.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.zero.tasks.c;
import com.tencent.mm.r.h;

public class PluginComm extends f implements a {
    public void configure(g gVar) {
        if (gVar.ES()) {
            new c().after((o) com.tencent.mm.kernel.g.n(o.class)).before(this);
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            pin(com.tencent.mm.plugin.g.a.aqH());
            pin(com.tencent.mm.plugin.a.VO());
            pin(com.tencent.mm.plugin.k.a.aAf());
            pin(com.tencent.mm.plugin.m.a.aCO());
            pin(com.tencent.mm.plugin.b.a.WB());
            pin(b.WC());
            pin(com.tencent.mm.plugin.p.c.aWC());
            pin(com.tencent.mm.plugin.p.b.aWB());
            pin(h.Ce());
            pin(com.tencent.mm.plugin.ad.a.bmE());
            pin(com.tencent.mm.plugin.t.b.bcR());
            pin(com.tencent.mm.plugin.d.a.ZN());
            pin(com.tencent.mm.plugin.ac.a.bmb());
            pin(com.tencent.mm.plugin.ab.a.bjh());
            pin(com.tencent.mm.pluginsdk.g.a.c.o.qDq);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.t.a.a.class, new com.tencent.mm.plugin.t.a());
            ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(com.tencent.mm.plugin.k.a.aAf());
            com.tencent.mm.ui.e.a.a.a(new 1(this));
        }
        pin(e.a.CB());
    }
}
