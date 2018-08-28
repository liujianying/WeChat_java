package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arh;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class ag$1 implements a {
    final /* synthetic */ arh eLh;
    final /* synthetic */ ag eLi;

    ag$1(ag agVar, arh arh) {
        this.eLi = agVar;
        this.eLh = arh;
    }

    public final boolean Ks() {
        return false;
    }

    public final boolean Kr() {
        if (this.eLh != null && this.eLh.rTD.size() > 0) {
            Iterator it = this.eLh.rTD.iterator();
            while (it.hasNext()) {
                arf arf = (arf) it.next();
                if (arf.hcd == 1) {
                    j jVar = new j();
                    jVar.username = arf.hbL;
                    jVar.dHR = arf.rqZ;
                    jVar.dHQ = arf.rra;
                    jVar.bWA = -1;
                    x.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", new Object[]{jVar.getUsername(), jVar.Kx(), jVar.Ky()});
                    jVar.csA = 3;
                    jVar.by(true);
                    q.KH().a(jVar);
                }
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|onGYNetEnd";
    }
}
