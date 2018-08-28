package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public class i implements e {
    private static i jLP;
    private boolean dFt = false;

    public static i aTO() {
        if (jLP == null) {
            synchronized (i.class) {
                if (jLP == null) {
                    jLP = new i();
                }
            }
        }
        return jLP;
    }

    public final synchronized void ft(boolean z) {
        Object obj;
        if (z) {
            obj = 1;
        } else if (bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(a.sOO, Long.valueOf(0)))).longValue()) > 86400) {
            int obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            if (!this.dFt) {
                x.i("MicroMsg.GameConfigUpdater", "Game config start update. force update(%b)", new Object[]{Boolean.valueOf(z)});
                release();
                this.dFt = true;
                g.DF().a(1311, this);
                g.DF().a(new au(), 0);
            }
        }
    }

    private void release() {
        this.dFt = false;
        g.DF().b(1311, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 1311) {
            x.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            g.Ei().DT().a(a.sOO, Long.valueOf(bi.VE()));
            release();
        }
    }
}
