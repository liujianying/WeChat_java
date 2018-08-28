package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class g$1 implements a {
    final /* synthetic */ g gYh;

    g$1(g gVar) {
        this.gYh = gVar;
    }

    public final boolean vD() {
        if (g.a(this.gYh)) {
            x.e("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler stopped is true, index[%d]", new Object[]{Integer.valueOf(g.KD())});
            this.gYh.gYe = 0;
        } else {
            x.i("MicroMsg.BackupReconnectHandler", "backupReconnectTimeHandler start reconnect, index[%d]", new Object[]{Integer.valueOf(g.KD())});
            if (g.KD() < g.b(this.gYh).length) {
                g.c(this.gYh).asc();
                g.d(this.gYh).J((long) g.b(this.gYh)[g.KD()], (long) g.b(this.gYh)[g.KD()]);
                g.KF();
            } else {
                g.e(this.gYh);
                this.gYh.gYe = 0;
                g.c(this.gYh).asd();
            }
        }
        return false;
    }
}
