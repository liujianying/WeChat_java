package com.tencent.mm.plugin.offline;

import com.tencent.mm.sdk.platformtools.x;

class i$b implements Runnable {
    final /* synthetic */ i lJo;

    private i$b(i iVar) {
        this.lJo = iVar;
    }

    /* synthetic */ i$b(i iVar, byte b) {
        this(iVar);
    }

    public final void run() {
        x.i("MicroMsg.OfflineTokensMgr", "mUpdateTokenRunnable, do doNetSceneToken");
        this.lJo.dg(6, 6);
    }
}
