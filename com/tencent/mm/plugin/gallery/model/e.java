package com.tencent.mm.plugin.gallery.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    private ag dvh;
    HandlerThread jAK = new HandlerThread("galleryDecodeHanlderThread", 10);
    HandlerThread jAL;
    HandlerThread jAM;
    ag jAN = null;
    ag jAO;
    ag jAP;

    public e() {
        x.d("MicroMsg.GalleryHandlerThread", "galleryhandlerthread init");
        this.jAK.start();
        this.jAL = new HandlerThread("galleryQueryHandlerThread", 1);
        this.jAO = null;
        this.jAL.start();
        this.jAM = new HandlerThread("galleryAfterTakePicThreadThread", 0);
        this.jAP = null;
        this.jAM.start();
    }

    public final ag aRs() {
        if (this.jAN == null && this.jAK != null) {
            this.jAN = new ag(this.jAK.getLooper());
        }
        return this.jAN;
    }

    public final void qs(int i) {
        try {
            Process.setThreadPriority(this.jAM.getThreadId(), i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryHandlerThread", e, "", new Object[0]);
        }
    }

    public final ag aRt() {
        if (this.jAO == null) {
            this.jAO = new ag(this.jAL.getLooper());
        }
        return this.jAO;
    }

    public final ag aRu() {
        if (this.dvh == null) {
            this.dvh = new ag(Looper.getMainLooper());
        }
        return this.dvh;
    }

    public final void z(Runnable runnable) {
        ag aRs = aRs();
        if (aRs == null) {
            x.e("MicroMsg.GalleryHandlerThread", "post to decode worker, but decode handler is null");
        } else {
            aRs.post(runnable);
        }
    }

    public final void aRv() {
        ag aRs = aRs();
        if (aRs == null) {
            x.e("MicroMsg.GalleryHandlerThread", "remove all work handler callbacks, but decode handler is null");
        } else {
            aRs.removeCallbacksAndMessages(null);
        }
    }

    public final void A(Runnable runnable) {
        aRu().post(runnable);
    }
}
