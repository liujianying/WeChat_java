package com.tencent.mm.plugin.messenger;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.a.e.b;
import com.tencent.mm.plugin.messenger.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;

public class PluginMessenger extends f implements c, com.tencent.mm.plugin.messenger.a.c {
    a lbB = new a();
    private a lbC = new a();
    private b lbD = new 1(this);
    private e.a lbE = new 2(this);
    private e.a lbF = new 3(this);
    private e.a lbG = new 4(this);
    private e.a lbH = new 5(this);

    public void installed() {
        alias(com.tencent.mm.plugin.messenger.a.c.class);
    }

    public void dependency() {
        dependsOn(com.tencent.mm.plugin.comm.a.a.class);
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.a.b.class, this.lbB);
            com.tencent.mm.kernel.g.a(e.class, this.lbC);
        }
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            pin(com.tencent.mm.plugin.ag.a.bqO());
        }
    }

    public String toString() {
        return "plugin-messenger";
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("sysmsgtemplate", this.lbC.lcM);
        ((e) com.tencent.mm.kernel.g.l(e.class)).a("link_plain", this.lbD);
        ((e) com.tencent.mm.kernel.g.l(e.class)).a("link_plain", this.lbE);
        ((e) com.tencent.mm.kernel.g.l(e.class)).a("link_revoke", this.lbF);
        ((e) com.tencent.mm.kernel.g.l(e.class)).a("link_revoke_qrcode", this.lbG);
        ((e) com.tencent.mm.kernel.g.l(e.class)).a("link_profile", this.lbH);
    }

    public void onAccountRelease() {
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("sysmsgtemplate", this.lbC.lcM);
        ((e) com.tencent.mm.kernel.g.l(e.class)).Gs("link_plain");
        ((e) com.tencent.mm.kernel.g.l(e.class)).Gt("link_plain");
        ((e) com.tencent.mm.kernel.g.l(e.class)).Gt("link_revoke");
        ((e) com.tencent.mm.kernel.g.l(e.class)).Gt("link_revoke_qrcode");
        ((e) com.tencent.mm.kernel.g.l(e.class)).Gt("link_profile");
    }
}
