package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;

class ar$7 implements Runnable {
    final /* synthetic */ ar nrO;

    ar$7(ar arVar) {
        this.nrO = arVar;
    }

    public final void run() {
        boolean z = true;
        if (this.nrO.nrK.isEmpty()) {
            x.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
            return;
        }
        ay ayVar = (ay) this.nrO.nrK.poll();
        if (ayVar == null) {
            x.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[]{Integer.valueOf(this.nrO.nrK.size())});
            return;
        }
        if (this.nrO.nrJ == null || !ayVar.elz.equals(this.nrO.nrJ.elz)) {
            z = false;
        }
        this.nrO.a(ayVar, z);
    }
}
