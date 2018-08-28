package com.tencent.mm.plugin.sns;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.sns.a.a;
import com.tencent.mm.plugin.sns.a.a.d;
import com.tencent.mm.plugin.sns.a.a.e;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.x;

public class PluginSns extends f implements b {
    l nhh = new l();
    a nhi = new a();
    o nhj = new o();
    a nhk = new a();

    public void dependency() {
        dependsOn(c.class);
        dependsOn(com.tencent.mm.plugin.normsg.a.class);
    }

    public void configure(g gVar) {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.a(i.class, this.nhh);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.c.class, this.nhk);
        a aVar = this.nhk;
        aVar.a(new e());
        aVar.a(new d());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.b());
        aVar.a(new com.tencent.mm.plugin.sns.a.a.c());
        if (gVar.ES()) {
            x.i("MicroMsg.PluginSns", "PluginSns configure");
            pin(new p(af.class));
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.sns.b.a.class, this.nhi);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.a(m.class, this.nhj);
        }
    }

    public void execute(g gVar) {
        com.tencent.mm.bg.c.Um("sns");
    }

    public String getAccSnsPath() {
        return com.tencent.mm.kernel.g.Ei().dqp + "sns/";
    }

    public String getAccSnsTmpPath() {
        return com.tencent.mm.kernel.g.Ei().dqp + "sns/temp/";
    }
}
