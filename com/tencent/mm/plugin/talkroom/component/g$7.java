package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.sdk.platformtools.bd;

class g$7 extends bd<e> {
    final /* synthetic */ c ovI;
    final /* synthetic */ g ovy;

    g$7(g gVar, c cVar) {
        this.ovy = gVar;
        this.ovI = cVar;
        super(3000, null, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return new h(g.a(this.ovy), this.ovI);
    }
}
