package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends a {
    public final int[] aXB() {
        return new int[]{227};
    }

    public final int Mw() {
        return 7;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            au.DF().a(new l(cVar.kpo, cVar.kpq, cVar.kpT), 0);
            x.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[]{Integer.valueOf(cVar.kpo), Long.valueOf(cVar.kpq), Boolean.valueOf(cVar.kpT)});
        }
    }
}
