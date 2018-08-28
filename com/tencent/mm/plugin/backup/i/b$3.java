package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.ae;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<ad> {
    final /* synthetic */ b hdp;

    b$3(b bVar) {
        this.hdp = bVar;
        this.sFo = ad.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ad adVar = (ad) bVar;
        x.i("MicroMsg.BackupEventListener", "receive BannerOnInitEvent.");
        ae aeVar = new ae();
        aeVar.bHl.bHn = new a(adVar.bHk.activity);
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        aeVar = new ae();
        aeVar.bHl.bHn = new com.tencent.mm.plugin.backup.backupui.a(adVar.bHk.activity);
        com.tencent.mm.sdk.b.a.sFg.m(aeVar);
        return false;
    }
}
