package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.g.a.jp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$4 extends c<jp> {
    final /* synthetic */ a hdj;

    a$4(a aVar) {
        this.hdj = aVar;
        this.sFo = jp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jp jpVar = (jp) bVar;
        if (jpVar != null && (jpVar instanceof jp)) {
            x.i("MicroMsg.BackupCore", "receive MsgSynchronizeABTestEvent.");
            com.tencent.mm.plugin.z.b.bfD();
            jpVar.bTl.bTm = com.tencent.mm.plugin.z.b.lst;
            jpVar.bTl.bTn = com.tencent.mm.plugin.z.b.lsu;
            jpVar.bTl.bTo = com.tencent.mm.plugin.z.b.lsv;
        }
        return false;
    }
}
