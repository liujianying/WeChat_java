package com.tencent.mm.plugin.account;

import com.tencent.mm.g.a.ho;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.protocal.c.afh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$5 extends c<ho> {
    final /* synthetic */ b eEO;

    b$5(b bVar) {
        this.eEO = bVar;
        this.sFo = ho.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ho hoVar = (ho) bVar;
        if (hoVar instanceof ho) {
            int i = hoVar.bQU.scene;
            ab abVar = new ab();
            ((afh) abVar.diG.dID.dIL).otY = i;
            g.DF().a(abVar, 0);
        }
        return false;
    }
}
