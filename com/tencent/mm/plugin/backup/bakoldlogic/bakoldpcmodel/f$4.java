package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.5;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class f$4 extends a {
    final /* synthetic */ f haj;

    f$4(f fVar) {
        this.haj = fVar;
    }

    public final void run() {
        f fVar = this.haj;
        int au = f.au(fVar.hac);
        x.i("MicroMsg.RecoverPCServer", "all msg item Count : " + au);
        x.d("MicroMsg.RecoverPCServer", "readFromSdcard start");
        e.d(new 5(fVar, au), "RecoverPCServer_recoverFromSdcard", 1).start();
    }
}
