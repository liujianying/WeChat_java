package com.tencent.mm.plugin.hp;

import com.tencent.mm.g.a.be;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<be> {
    final /* synthetic */ a kmt;

    a$1(a aVar) {
        this.kmt = aVar;
        this.sFo = be.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        be beVar = (be) bVar;
        if (29 == beVar.bIK.bIC && beVar.bIK.bIH == 0) {
            x.d("Tinker.HotPatchApplication", "hp_res received new hotpatch cache request");
            com.tencent.mm.plugin.hp.b.b.rl(0);
        }
        return false;
    }
}
