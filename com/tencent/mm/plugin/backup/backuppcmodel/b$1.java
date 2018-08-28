package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager;
import com.tencent.mm.sdk.platformtools.ad;

class b$1 implements Runnable {
    final /* synthetic */ b gWv;

    b$1(b bVar) {
        this.gWv = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.gWv) == null) {
                b.a(this.gWv, ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(26, "BackupPc Lock"));
            }
            if (!b.a(this.gWv).isHeld()) {
                b.a(this.gWv).acquire();
            }
        } catch (Throwable th) {
        }
    }
}
