package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.g.a.cs;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class BKGLoaderManager$3 extends c<cs> {
    final /* synthetic */ BKGLoaderManager ijK;

    BKGLoaderManager$3(BKGLoaderManager bKGLoaderManager) {
        this.ijK = bKGLoaderManager;
        this.sFo = cs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cs csVar = (cs) bVar;
        if ((csVar instanceof cs) && !bi.oW(csVar.bKf.bKg)) {
            this.ijK.j(csVar.bKf.bKg, csVar.bKf.bIH, csVar.bKf.success);
        }
        return false;
    }
}
