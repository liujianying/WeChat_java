package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.j;
import com.tencent.mm.ab.l;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private q dJM = new a();
    private e diJ;

    public static class a extends j {
        private final com.tencent.mm.protocal.l.a eeV = new com.tencent.mm.protocal.l.a();
        private final b eeW = new b();

        protected final d Ic() {
            return this.eeV;
        }

        public final com.tencent.mm.protocal.k.e Id() {
            return this.eeW;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    public static void bN(boolean z) {
        x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", new Object[]{Boolean.valueOf(z), Boolean.valueOf(au.HX()), bi.cjd()});
        if (!au.HX()) {
            return;
        }
        if (au.DF() == null || au.DF().dJs == null || au.DF().dJs.Lr() == null) {
            x.i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            return;
        }
        au.DF().dJs.Lr().bB(z);
        if (z) {
            au.DF().a(new c(true), 0);
            return;
        }
        au.DF().a(new c(QK()), 0);
    }

    private static boolean QK() {
        int i;
        if (af.exS != -1) {
            i = af.exS;
        } else {
            try {
                i = bi.getInt(g.AT().getValue("MuteRoomDisable"), 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i = 0;
            }
        }
        x.i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", new Object[]{Integer.valueOf(1), Integer.valueOf(af.exS), Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground)});
        if ((i & 1) != 0) {
            return true;
        }
        return r3;
    }

    private c(boolean z) {
        com.tencent.mm.protocal.l.a aVar = (com.tencent.mm.protocal.l.a) this.dJM.KV();
        aVar.netType = com.tencent.mm.protocal.l.getNetType(ad.getContext());
        aVar.qWE = z ? 1 : 2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBgFg", " ret[%d]", new Object[]{Integer.valueOf(((b) qVar.Id()).qWF.hUm)});
        this.diJ.a(i2, i3, str, this);
    }
}
