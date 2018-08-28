package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends c<bc> {
    c$1() {
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 46 && bcVar.bIB.bID == 0) {
            x.i("MicroMsg.ExtQbarDataManager", "hy: got ext qrcode config. trigger copy");
            c.eE(bcVar.bIB.filePath);
            c.access$100();
        }
        return false;
    }
}
