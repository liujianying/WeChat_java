package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.pluginsdk.g.a.c.f.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

final class n$c extends PriorityBlockingQueue<Runnable> {
    public final /* synthetic */ boolean offer(Object obj) {
        Runnable runnable = (Runnable) obj;
        boolean offer = super.offer(runnable);
        x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "offer() | tid = %d | " + J(runnable), new Object[]{Long.valueOf(Thread.currentThread().getId())});
        return offer;
    }

    public final /* synthetic */ Object poll(long j, TimeUnit timeUnit) {
        Runnable runnable = (Runnable) super.poll(j, timeUnit);
        if (runnable != null) {
            x.d("MicroMsg.ResDownloader.NetworkWorker.BlockingQueue", "poll(long, TimeUnit) | tid = %d | " + J(runnable), new Object[]{Long.valueOf(Thread.currentThread().getId())});
        }
        return runnable;
    }

    public n$c() {
        super(11, new 1());
    }

    private static String J(Runnable runnable) {
        if (!(runnable instanceof c)) {
            return String.format("unknown runnable = %s", new Object[]{runnable});
        } else if (((c) runnable).qCX instanceof l) {
            return String.format("priority = %d, urlKey = %s", new Object[]{Integer.valueOf(((l) ((c) runnable).qCX).priority), ((c) runnable).qCX.cco()});
        } else {
            return String.format("unknown request = %s", new Object[]{((c) runnable).qCX});
        }
    }
}
