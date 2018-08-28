package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.g.a.x;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$2 extends c<x> {
    final /* synthetic */ a hdj;

    a$2(a aVar) {
        this.hdj = aVar;
        this.sFo = x.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x xVar = (x) bVar;
        if (xVar != null && (xVar instanceof x)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.BackupCore", "receive BackupGetA8keyRedirectEvent.");
            String str = xVar.bHf.url;
            c.mV(2).l(str);
        }
        return false;
    }
}
