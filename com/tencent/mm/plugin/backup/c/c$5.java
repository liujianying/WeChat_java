package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$5 implements a {
    final /* synthetic */ c gUr;

    c$5(c cVar) {
        this.gUr = cVar;
    }

    public final boolean vD() {
        if (!c.access$300()) {
            x.e("MicroMsg.BackupMoveRecoverServer", "try connect overtime failed.");
            if (c.d(this.gUr) != null) {
                c.d(this.gUr).SO();
            }
            c.e(this.gUr);
        }
        return true;
    }
}
