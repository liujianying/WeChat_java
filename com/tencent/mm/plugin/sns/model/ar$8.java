package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;

class ar$8 implements Runnable {
    final /* synthetic */ ar nrO;

    ar$8(ar arVar) {
        this.nrO = arVar;
    }

    public final void run() {
        if (this.nrO.nrJ != null) {
            x.i("MicroMsg.SnsVideoService", "download video finish cdnmediaId %s", new Object[]{this.nrO.nrJ.elz});
            this.nrO.nrL.remove(this.nrO.nrJ.elz);
        }
        this.nrO.nrJ = null;
        this.nrO.byU();
    }
}
