package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<ri> {
    private ag mHandler;

    public d() {
        this.mHandler = new ag(Looper.getMainLooper());
        this.sFo = ri.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ri riVar = (ri) bVar;
        if (g.Eg().Dx() && (riVar instanceof ri)) {
            x.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = riVar.ccb.ccc;
            boolean z2 = riVar.ccb.scene == 1;
            if (z2) {
                h.mEJ.a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new 1(this, riVar, z2), 10000);
            } else if (riVar.ccb.ccd) {
                k.bkO();
                i bkR = k.bkR();
                int i = riVar.ccb.cce;
                bkR.df(i, i);
            } else {
                k.bkO();
                k.bkR().gW(z2);
            }
        }
        return false;
    }
}
