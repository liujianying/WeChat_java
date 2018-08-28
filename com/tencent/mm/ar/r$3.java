package com.tencent.mm.ar;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class r$3 extends c<bc> {
    final /* synthetic */ r edd;

    r$3(r rVar) {
        this.edd = rVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 47 && bcVar.bIB.bID == 1) {
            x.i("MicroMsg.SubCorePacakge", "going to update region code.");
            r.a(this.edd, bcVar.bIB.filePath);
        }
        return false;
    }
}
