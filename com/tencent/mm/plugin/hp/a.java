package com.tencent.mm.plugin.hp;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.g.a.be;
import com.tencent.mm.plugin.hp.b.c;
import com.tencent.mm.plugin.hp.tinker.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements n {
    private c kmq = new c();
    private com.tencent.mm.sdk.b.c<be> kmr = new 1(this);
    private com.tencent.mm.sdk.b.c<bc> kms = new com.tencent.mm.sdk.b.c<bc>() {
        {
            this.sFo = bc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bc bcVar = (bc) bVar;
            if (29 == bcVar.bIB.bIC && bcVar.bIB.bIF) {
                x.d("Tinker.HotPatchApplication", "hp_res received new/updated download resource, path=%s", new Object[]{bcVar.bIB.filePath});
                com.tencent.mm.plugin.hp.b.b.rm(0);
                c.EG(bcVar.bIB.filePath);
            }
            return false;
        }
    };

    public a() {
        d.aWs();
        d.b(com.tencent.mm.app.b.applicationLike);
        com.tencent.mm.sdk.b.a.sFg.b(this.kmq);
        com.tencent.mm.sdk.b.a.sFg.b(this.kms);
        com.tencent.mm.sdk.b.a.sFg.b(this.kmr);
    }

    public final void a(m mVar) {
    }

    public final void a(l lVar) {
    }
}
