package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    ag giD;
    HandlerThread handlerThread;

    private class a extends ag {
        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                } catch (Exception e) {
                    x.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", new Object[]{dVar.getName()});
                }
            }
        }
    }

    public j() {
        if (com.tencent.mm.compatible.util.d.fT(18)) {
            this.handlerThread = e.Xs("WearWorker_worker_thread");
            this.handlerThread.start();
            this.giD = new a(this.handlerThread.getLooper());
            x.i("MicroMsg.Wear.WearWorker", "start worker %d", new Object[]{Integer.valueOf(this.handlerThread.getThreadId())});
        }
    }

    public final void a(d dVar) {
        if (this.giD != null) {
            this.giD.sendMessage(this.giD.obtainMessage(0, dVar));
        }
    }
}
