package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ak.a.c.c;
import com.tencent.mm.plugin.game.model.aq.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class aq$3 implements c {
    final /* synthetic */ String igt;
    final /* synthetic */ List jOA;
    final /* synthetic */ b jOB;

    aq$3(String str, List list, b bVar) {
        this.igt = str;
        this.jOA = list;
        this.jOB = bVar;
    }

    public final void a(boolean z, Object... objArr) {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download %b! thumburl:%s", new Object[]{Boolean.valueOf(z), this.igt});
        aq.b(this.jOA, this.jOB);
    }
}
