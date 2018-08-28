package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    public final int[] aXB() {
        return new int[]{991};
    }

    public final int Mw() {
        return 1;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            if (cVar.kpr == 0) {
                cVar.kpr = (int) System.currentTimeMillis();
            }
            au.DF().a(new i(cVar.bZR, cVar.kpQ, cVar.kpr, cVar.kps, cVar.kpt), 0);
            x.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[]{cVar.bZR, cVar.kpQ, Integer.valueOf(cVar.kpr)});
        }
    }
}
