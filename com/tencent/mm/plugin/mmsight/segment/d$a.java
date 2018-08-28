package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class d$a {
    Lock jhz = new ReentrantLock();
    LinkedBlockingQueue<d> lkV = new LinkedBlockingQueue(4);
    private final int lkW = 4;
    private Callable<d> lkX;
    private volatile int size = 0;

    public d$a(Callable<d> callable) {
        this.lkX = callable;
    }

    public final d beP() {
        d dVar = null;
        long VG = bi.VG();
        x.d("FetcherPool", "acquireFetcher");
        if (this.lkV == null) {
            x.d("FetcherPool", "acquireFetcher no pool directly return null");
        } else {
            this.jhz.lock();
            x.d("FetcherPool", "pool.size() %d, size %d, maxFetcherSize %d", new Object[]{Integer.valueOf(this.lkV.size()), Integer.valueOf(this.size), Integer.valueOf(this.lkW)});
            if (this.lkV == null) {
                this.jhz.unlock();
            } else {
                if (!this.lkV.isEmpty() || this.size >= this.lkW) {
                    x.d("FetcherPool", "waiting fetcher");
                    this.jhz.unlock();
                    dVar = (d) this.lkV.poll(5, TimeUnit.SECONDS);
                } else {
                    x.d("FetcherPool", "new fetcher");
                    this.size++;
                    this.jhz.unlock();
                    dVar = beQ();
                }
                x.d("FetcherPool", "time flee, acquireFetcher cost time %d", new Object[]{Long.valueOf(bi.bI(VG))});
            }
        }
        return dVar;
    }

    private d beQ() {
        if (this.lkX == null) {
            throw new IllegalStateException("fetcher generator can not be null.");
        }
        try {
            d dVar = (d) this.lkX.call();
            x.d("FetcherPool", "time flee, construct fetcher instance cost %d", new Object[]{Long.valueOf(bi.bI(bi.VG()))});
            return dVar;
        } catch (Throwable e) {
            x.printErrStackTrace("FetcherPool", e, " fetcher generater call error %s", new Object[]{e.getMessage()});
            throw e;
        }
    }

    public final void a(d dVar) {
        x.d("FetcherPool", "reuseFetcher");
        if (dVar == null) {
            x.e("FetcherPool", "Null object can not be reused.");
        } else if (this.lkV == null) {
            dVar.release();
        } else if (this.lkV.contains(dVar)) {
            throw new IllegalStateException("fetcher already in pool");
        } else {
            this.lkV.offer(dVar);
        }
    }
}
