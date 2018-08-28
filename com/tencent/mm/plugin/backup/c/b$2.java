package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager;
import com.tencent.mm.sdk.platformtools.ad;

class b$2 implements Runnable {
    final /* synthetic */ b gTI;

    b$2(b bVar) {
        this.gTI = bVar;
    }

    public final void run() {
        try {
            if (b.a(this.gTI) == null) {
                b.a(this.gTI, ((PowerManager) ad.getContext().getSystemService("power")).newWakeLock(26, "BackupMove Lock"));
            }
            if (!b.a(this.gTI).isHeld()) {
                b.a(this.gTI).acquire();
            }
        } catch (Throwable th) {
        }
    }
}
