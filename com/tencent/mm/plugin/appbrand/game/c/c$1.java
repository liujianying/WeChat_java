package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.mm.sdk.platformtools.al.a;

class c$1 implements a {
    final /* synthetic */ c fBn;

    c$1(c cVar) {
        this.fBn = cVar;
    }

    public final boolean vD() {
        g agx = i.fCa.agx();
        if (agx != null) {
            c cVar = this.fBn;
            double d = agx.fBW;
            double d2 = agx.fBX;
            cVar.azu.setLength(0);
            cVar.azu.append("MinFPS[").append(Math.round(d2)).append("] RT-FPS[").append(Math.round(d)).append("]");
            cVar.setText(cVar.azu);
        }
        return true;
    }
}
