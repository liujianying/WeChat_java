package com.tencent.mm.plugin.bbom;

import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.app.r;
import com.tencent.mm.app.s;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.bbom.a.a;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.fav.a.v;
import com.tencent.mm.plugin.i.e;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.welab.a.a.d;
import com.tencent.mm.plugin.welab.b.b;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.n$a;

public class PluginBigBallOfMudAsync extends f implements a {
    public String toString() {
        return "plugin-big-ball-of-mud-async";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
        dependsOn(PluginBigBallOfMud.class);
        dependsOn(com.tencent.mm.plugin.notification.b.a.class);
    }

    public void configure(g gVar) {
        if (gVar.ES() && ((h) gVar).mProfileCompat != null) {
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.notification.b.a.class)).setNotification(((WorkerProfile) ((h) gVar).mProfileCompat).getNotification());
        }
        t.a.qJO = new 1(this);
        n$a.a(new 2(this));
        c.a.qPG = new 3(this);
        com.tencent.mm.plugin.webview.ui.tools.widget.f.a.qkE = new 4(this);
        com.tencent.mm.plugin.webview.ui.tools.widget.c.a.qkD = new 5(this);
        com.tencent.mm.plugin.webview.ui.tools.widget.a.a.qkC = new 6(this);
        com.tencent.mm.kernel.g.a(ad.class, new com.tencent.mm.pluginsdk.model.f());
        com.tencent.mm.kernel.g.a(v.class, new com.tencent.mm.pluginsdk.model.c());
        if (((h) gVar).mProfileCompat != null && gVar.ES()) {
            WorkerProfile workerProfile = (WorkerProfile) ((h) gVar).mProfileCompat;
            s sVar = workerProfile.bzM;
            r rVar = workerProfile.bzN;
            com.tencent.mm.bg.c.qUZ = sVar;
            com.tencent.mm.bg.c.qVa = rVar;
            new e(workerProfile).before(this).after(com.tencent.mm.kernel.g.n(o.class));
        }
        if (gVar.ES()) {
            ((o) com.tencent.mm.kernel.g.n(o.class)).setIDataTransferFactoryDelegate(new 7(this));
        }
    }

    public void execute(g gVar) {
        if (((h) gVar).mProfileCompat != null && gVar.ES()) {
            x.i("MicroMsg.PluginBigBallOfMudAsync", "before WorkerProfile oncreate.");
            ((h) gVar).mProfileCompat.onCreate();
        }
        if (gVar.ES()) {
            ((d) com.tencent.mm.kernel.g.l(d.class)).a("labs1de6f3", new b());
            ((d) com.tencent.mm.kernel.g.l(d.class)).a(new com.tencent.mm.plugin.welab.d.a());
            ((d) com.tencent.mm.kernel.g.l(d.class)).a("labs_browse", new com.tencent.mm.plugin.welab.b.a());
        }
    }
}
