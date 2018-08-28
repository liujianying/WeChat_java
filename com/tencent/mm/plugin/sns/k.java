package com.tencent.mm.plugin.sns;

import com.tencent.mm.g.a.nf;
import com.tencent.mm.plugin.sns.model.ab;
import com.tencent.mm.plugin.sns.model.ab.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends c<nf> {
    public k() {
        this.sFo = nf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nf nfVar = (nf) bVar;
        if (nfVar instanceof nf) {
            if (nfVar.bYj.state == 0) {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "start clean");
                ab.kEE = true;
                ab abVar = new ab();
                abVar.npc = System.currentTimeMillis();
                if (!abVar.npb) {
                    new a(abVar).o(new String[]{""});
                }
            } else {
                x.d("MicroMsg.RemoveSnsTaskEventListener", "stop clean");
                ab.kEE = false;
            }
            return true;
        }
        x.f("MicroMsg.RemoveSnsTaskEventListener", "mismatched event");
        return false;
    }
}
