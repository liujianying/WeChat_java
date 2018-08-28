package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends b {
    public n gYu = new n();
    public o gYv = new o();

    public final /* bridge */ /* synthetic */ a asj() {
        return this.gYv;
    }

    public j(String str) {
        x.i("MicroMsg.BackupStartScene", "BackupStartScene, id[%s]", new Object[]{str});
        this.gYu.ID = str;
    }

    public final int getType() {
        return 3;
    }

    public final a ask() {
        return this.gYu;
    }

    public final void mI(int i) {
        x.i("MicroMsg.BackupStartScene", "onSceneEnd.");
        if (this.gYv.hcd != 0) {
            g(4, this.gYv.hcd, "BackupStartScene onSceneEnd failed");
        } else {
            g(0, this.gYv.hcd, "BackupStartScene onSceneEnd success");
        }
    }
}
