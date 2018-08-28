package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a {
    public int ksr = 1;
    public boolean kss = false;

    public final int[] aXB() {
        return new int[]{723};
    }

    public final int Mw() {
        return 4;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            x.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.kpo), Integer.valueOf(cVar.kpr)});
            au.DF().a(new n(cVar.kpo, cVar.kpp, cVar.kpq, this.ksr), 0);
        }
    }
}
