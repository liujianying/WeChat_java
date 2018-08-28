package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.sdk.platformtools.bd;

class g$1 extends bd<Integer> {
    final /* synthetic */ g ovy;

    g$1(g gVar, Integer num) {
        this.ovy = gVar;
        super(3000, num, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return Integer.valueOf(g.a(this.ovy).uninitLive());
    }
}
