package com.tencent.mm.pluginsdk.d.a;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class b {
    private CountDownLatch qyz = null;

    public final void countDown() {
        if (this.qyz != null) {
            this.qyz.countDown();
            this.qyz = null;
        }
    }

    public final void b(long j, Runnable runnable) {
        x.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.qyz == null) {
            this.qyz = new CountDownLatch(1);
        }
        ah.A(runnable);
        x.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.qyz != null) {
            try {
                this.qyz.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                x.w("MicroMsg.SyncJob", e.getMessage());
                x.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
    }
}
