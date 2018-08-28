package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.plugin.ipcall.a.a.a {
    public final int[] aXB() {
        return new int[]{843};
    }

    public final int Mw() {
        return 3;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            x.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.kpo), Integer.valueOf(cVar.kpr)});
            au.DF().a(new com.tencent.mm.plugin.ipcall.a.d.a(cVar.kpo, cVar.kpp, cVar.bZR, cVar.kpQ, cVar.kpr, cVar.kpq), 0);
        }
    }
}
