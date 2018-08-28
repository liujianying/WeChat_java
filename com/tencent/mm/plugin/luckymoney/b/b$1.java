package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class b$1 extends c<bc> {
    b$1() {
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB != null && bcVar.bIB.bIC == 53) {
            x.i("MicroMsg.LuckMoneyEffectResourceMgr", "luckyMoney resource file update, type: %s, subType: %s, filePath: %s", Integer.valueOf(bcVar.bIB.bIC), Integer.valueOf(bcVar.bIB.bID), bcVar.bIB.filePath);
            if (!bi.oW(bcVar.bIB.filePath) && FileOp.cn(bcVar.bIB.filePath)) {
                b.V(bcVar.bIB.filePath, bcVar.bIB.bIC, bcVar.bIB.bID);
            }
        }
        return false;
    }
}
