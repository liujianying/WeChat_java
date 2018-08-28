package com.tencent.mm.plugin.ext.provider;

import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.d.a.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

class ExtControlProviderMsg$2 implements Runnable {
    final /* synthetic */ String[] dhB;
    final /* synthetic */ b heb;
    final /* synthetic */ ExtControlProviderMsg iKf;
    final /* synthetic */ ab iKg;

    ExtControlProviderMsg$2(ExtControlProviderMsg extControlProviderMsg, ab abVar, String[] strArr, b bVar) {
        this.iKf = extControlProviderMsg;
        this.iKg = abVar;
        this.dhB = strArr;
        this.heb = bVar;
    }

    public final void run() {
        fa faVar = new fa();
        faVar.bNd.toUserName = this.iKg.field_username;
        faVar.bNd.content = this.dhB[1];
        faVar.bNd.type = s.hQ(this.iKg.field_username);
        faVar.bNd.flags = 0;
        if (a.sFg.m(faVar)) {
            l lVar = faVar.bNe.bNf;
            try {
                au.DF().a(522, new 1(this, com.tencent.mm.plugin.ext.a.a.dc(faVar.bNe.bJC)));
                au.DF().a(lVar, 0);
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                x.printErrStackTrace("MicroMsg.ExtControlProviderMsg", e, "", new Object[0]);
                this.iKf.pr(4);
                this.heb.countDown();
                return;
            }
        }
        this.iKf.pr(4);
        this.heb.countDown();
    }
}
