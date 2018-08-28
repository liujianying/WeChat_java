package com.tencent.mm.plugin.game.model;

import android.os.Build.VERSION;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.aw;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class au extends l implements k {
    private e diJ;
    private final b ivx;

    public au() {
        a aVar = new a();
        aVar.dIG = new aw();
        aVar.dIH = new ax();
        aVar.uri = "/cgi-bin/mmgame-bin/getgamecenterglobalsetting";
        aVar.dIF = 1311;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        aw awVar = (aw) this.ivx.dID.dIL;
        awVar.jRj = w.chP();
        String dz = f.dz(ad.getContext());
        if (bi.oW(dz)) {
            dz = bi.fS(ad.getContext());
        }
        awVar.eJQ = dz;
        awVar.jRk = com.tencent.mm.sdk.platformtools.e.bxk;
        awVar.jRl = new d();
        awVar.jRl.jPa = VERSION.SDK_INT;
        awVar.jRl.jPb = com.b.a.a.b.V(ad.getContext());
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "lang=%s, country=%s, releaseChannel=%s, osVersion = %d, deviceLevel = %d", new Object[]{awVar.jRj, awVar.eJQ, Integer.valueOf(awVar.jRk), Integer.valueOf(awVar.jRl.jPa), Integer.valueOf(awVar.jRl.jPb)});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameGlobalConfig", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 == 0 && i3 == 0) {
            ax axVar = (ax) ((b) qVar).dIE.dIL;
            if (axVar == null) {
                this.diJ.a(i2, i3, str, this);
                return;
            }
            ((c) g.l(c.class)).aSk().a("pb_game_global_config", axVar);
            h.aTL().Zy();
            this.diJ.a(i2, i3, str, this);
            return;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1311;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }
}
