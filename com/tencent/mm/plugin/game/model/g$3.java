package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class g$3 implements c {
    final /* synthetic */ atl jLJ;
    final /* synthetic */ List jLK;
    final /* synthetic */ g$a jLL;

    g$3(atl atl, List list, g$a g_a) {
        this.jLJ = atl;
        this.jLK = list;
        this.jLL = g_a;
    }

    public final void a(boolean z, Object... objArr) {
        if (z) {
            x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download success! thumburl:%s", new Object[]{this.jLJ.lPl});
            g.b(this.jLK, this.jLL);
        }
    }
}
