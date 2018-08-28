package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class am implements e {
    public ArrayList<a> jOe;
    private boolean jOf = false;

    public am() {
        g.DF().a(427, this);
        this.jOe = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.jOe.contains(aVar)) {
            this.jOe.add(aVar);
        }
        aUz();
    }

    private void aUz() {
        while (!this.jOf) {
            if (this.jOe == null || this.jOe.size() == 0) {
                x.d("MicroMsg.AppReportService", "report queue is null, no need do scnene");
                return;
            }
            a aVar = (a) this.jOe.remove(0);
            if (aVar != null) {
                this.jOf = true;
                g.DF().a(new com.tencent.mm.pluginsdk.model.app.am(aVar.eiF, aVar.jOg), 0);
                return;
            }
        }
        x.i("MicroMsg.AppReportService", "is doing scene, wait for a minite");
    }

    public final void a(int i, int i2, String str, l lVar) {
        this.jOf = false;
        aUz();
    }
}
