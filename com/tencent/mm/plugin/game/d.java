package com.tencent.mm.plugin.game;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.model.am;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.plugin.game.model.y;
import com.tencent.mm.sdk.platformtools.x;

public final class d implements c, b {
    private com.tencent.mm.plugin.game.model.c jFN;
    private am jFO;
    private y jFP;
    private v jFQ;

    public final void onAccountInitialized(e.c cVar) {
        x.i("MicroMsg.GameService", "GameService onAccountInitialized");
        this.jFN = new com.tencent.mm.plugin.game.model.c();
        this.jFO = new am();
        this.jFP = new y();
        this.jFQ = new v();
    }

    public final void onAccountRelease() {
        x.i("MicroMsg.GameService", "GameService onAccountRelease");
        if (this.jFO != null) {
            am amVar = this.jFO;
            if (amVar.jOe != null) {
                amVar.jOe.clear();
            }
            g.DF().b(427, amVar);
        }
        if (this.jFP != null) {
            g.DF().b(1223, this.jFP);
        }
    }

    public final com.tencent.mm.plugin.game.model.c aSf() {
        g.Eg().Ds();
        if (this.jFN == null) {
            this.jFN = new com.tencent.mm.plugin.game.model.c();
        }
        return this.jFN;
    }

    public final am aSg() {
        g.Eg().Ds();
        if (this.jFO == null) {
            this.jFO = new am();
        }
        return this.jFO;
    }

    public final y aSh() {
        g.Eg().Ds();
        if (this.jFP == null) {
            this.jFP = new y();
        }
        return this.jFP;
    }

    public final v aSi() {
        g.Eg().Ds();
        if (this.jFQ == null) {
            this.jFQ = new v();
        }
        return this.jFQ;
    }
}
