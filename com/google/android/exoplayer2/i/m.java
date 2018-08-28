package com.google.android.exoplayer2.i;

import java.util.PriorityQueue;

public final class m {
    public final PriorityQueue<Integer> aCs;
    public int aCt;
    public final Object lock;

    public final void mo() {
        synchronized (this.lock) {
            this.aCs.remove(Integer.valueOf(0));
            this.aCt = this.aCs.isEmpty() ? Integer.MIN_VALUE : ((Integer) this.aCs.peek()).intValue();
            this.lock.notifyAll();
        }
    }
}
