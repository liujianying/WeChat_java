package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.compatible.e.w;
import com.tencent.mm.pluginsdk.g.a.c.f.a;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class n extends f<l> {
    private final a qDl;
    public final c qDm;

    public n(u uVar, c cVar) {
        this(uVar, cVar, (byte) 0);
    }

    private n(u uVar, c cVar, byte b) {
        this.qDl = new a(this, 4, 4, 3000, TimeUnit.MILLISECONDS, new c(), uVar);
        this.qDl.setKeepAliveTime(30000, TimeUnit.MILLISECONDS);
        this.qDl.allowCoreThreadTimeOut(true);
        this.qDm = cVar;
    }

    public int b(l lVar) {
        int i = 0;
        if (Tl(lVar.qBy) || isDownloading(lVar.qBy)) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s is already queueing, skip repeated task", new Object[]{lVar.qBy});
            return 0;
        }
        int zQ = w.zQ();
        x.i("MicroMsg.ResDownloader.NetworkWorker", "currentNetType(%d), requestNetType(%d)", new Object[]{Integer.valueOf(zQ), Integer.valueOf(lVar.networkType)});
        if (zQ != 0) {
            if (2 == lVar.networkType) {
                zQ = 1;
            } else if (zQ == 1) {
                zQ = 1;
            }
            if (zQ != 0) {
                x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[]{lVar.qBy});
                return 1;
            }
            if (this.qDl.isShutdown() || this.qDl.isTerminated() || this.qDl.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                return 4;
            }
            super.b(lVar);
            return 2;
        }
        zQ = 0;
        if (zQ != 0) {
            if (this.qDl.isShutdown() || this.qDl.isTerminated() || this.qDl.isTerminating()) {
                i = 1;
            }
            if (i != 0) {
                return 4;
            }
            super.b(lVar);
            return 2;
        }
        x.i("MicroMsg.ResDownloader.NetworkWorker", "urlKey = %s, mismatch networkType , skip task", new Object[]{lVar.qBy});
        return 1;
    }

    public final boolean isDownloading(String str) {
        return this.qCV.containsKey(str);
    }

    protected final a ccv() {
        return this.qDl;
    }

    public d a(l lVar) {
        x.i("MicroMsg.ResDownloader.NetworkWorker", "request.class = " + lVar.getClass().getSimpleName());
        q.a.ccH();
        a c = q.c(lVar);
        if (c == null) {
            x.i("MicroMsg.ResDownloader.NetworkWorker", "get null handler from plugin, use default handler");
            c = new b(lVar);
        }
        c.qDp = this.qDm;
        return c;
    }

    public void shutdown() {
        this.qDl.shutdownNow();
        for (String str : this.qCV.keySet()) {
            Future future = (Future) this.qCV.get(str);
            if (future != null) {
                future.cancel(true);
            }
        }
        this.qCU.clear();
        this.qCV.clear();
    }
}
