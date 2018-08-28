package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.ji;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$8 extends c<ji> {
    final /* synthetic */ c jFM;

    c$8(c cVar) {
        this.jFM = cVar;
        this.sFo = ji.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.GameEventListener", "manual force login");
        i.aTO().ft(true);
        return false;
    }
}
