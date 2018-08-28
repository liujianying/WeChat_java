package com.tencent.mm.memory;

import com.tencent.mm.sdk.platformtools.x;
import java.util.NavigableMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;

public abstract class e<T, S extends Comparable> {
    protected NavigableMap<S, d<T, S>> duW = new ConcurrentSkipListMap();
    private Vector<a> duX = new Vector();
    protected long duY = 0;

    public abstract long Fk();

    public abstract long Fl();

    public abstract long aR(T t);

    public abstract S aS(T t);

    public abstract S b(S s);

    public abstract d<T, S> c(S s);

    public abstract T d(S s);

    public final void a(a aVar) {
        this.duX.add(aVar);
        x.i("MicroMsg.BucketPool", "%s addPreload: %s", new Object[]{this, aVar});
        Fo();
    }

    public final void Fo() {
        if (this.duX.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new 1(this), "BucketPool_preload");
        }
    }

    public synchronized T a(S s) {
        T t;
        d dVar = (d) this.duW.get(s);
        if (dVar == null || dVar.size() <= 0) {
            x.d("MicroMsg.BucketPool", "BucketPool get cannot get %s size", new Object[]{s});
            t = null;
        } else {
            T pop = dVar.pop();
            this.duW.put(dVar.Fn(), dVar);
            aS(aR((Object) pop));
            t = pop;
        }
        return t;
    }

    public synchronized void aQ(T t) {
        if (t != null) {
            Comparable aS = aS((Object) t);
            long aR = aR((Object) t);
            if (aR > Fl()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum element size: %s, ignore this", new Object[]{Long.valueOf(aR)});
            } else if (this.duY + aR > Fk()) {
                x.e("MicroMsg.BucketPool", "release, reach maximum size, just ignore %s %s", new Object[]{Long.valueOf(aR), Long.valueOf(this.duY)});
            } else {
                d dVar = (d) this.duW.get(aS);
                if (dVar == null) {
                    dVar = c(aS);
                }
                dVar.put(t);
                this.duW.put(aS, dVar);
                aR(aR);
            }
        }
    }

    private synchronized void aR(long j) {
        this.duY += j;
    }

    protected final synchronized void aS(long j) {
        this.duY -= j;
    }

    public void Fm() {
        x.i("MicroMsg.BucketPool", "freeAll: %s", new Object[]{getClass().getName()});
        this.duW.clear();
        this.duY = 0;
    }
}
