package com.tencent.mm.ar;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e {
    private static c ecx;
    private boolean dFt = false;
    private int ecw = 3;

    public static c Qj() {
        if (ecx == null) {
            ecx = new c();
        }
        return ecx;
    }

    public final void update() {
        x.i("MicroMsg.ConfigListUpdater", "isUpdateing : " + this.dFt);
        x.i("MicroMsg.ConfigListUpdater", "isSDCardAvailable : " + g.Ei().isSDCardAvailable());
        if (!this.dFt && g.Ei().isSDCardAvailable()) {
            release();
            this.dFt = true;
            g.Eh().dpP.a(159, this);
            g.Eh().dpP.a(new k(7), 0);
        }
    }

    private void release() {
        this.dFt = false;
        g.Eh().dpP.b(159, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 159) {
            x.i("MicroMsg.ConfigListUpdater", "getPackageList sceneEnd, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i == 0 && i2 == 0) {
                g.Ei().DT().set(81938, Long.valueOf(bi.VE()));
            } else {
                int i3 = this.ecw - 1;
                this.ecw = i3;
                if (i3 < 0) {
                    g.Ei().DT().set(81938, Long.valueOf(((bi.VF() - 86400000) + 3600000) / 1000));
                    this.ecw = 3;
                }
            }
            release();
        }
    }
}
