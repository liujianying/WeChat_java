package com.tencent.mm.plugin.topstory;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.os;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class b$2 implements e {
    final /* synthetic */ b oyG;

    b$2(b bVar) {
        this.oyG = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.equals(this.oyG.oyF)) {
            g.DF().b(this.oyG.oyF.getType(), this);
            this.oyG.oyF = null;
        }
        a aVar = (a) lVar;
        if (i == 0 && i2 == 0) {
            g.Ei().DT().a(aa.a.tac, aVar.bHD().rjK);
            com.tencent.mm.sdk.b.a.sFg.m(new os());
            return;
        }
        x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "netscene topstory error");
    }
}
