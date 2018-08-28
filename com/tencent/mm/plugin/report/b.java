package com.tencent.mm.plugin.report;

import java.util.HashMap;
import java.util.Map.Entry;

public final class b {
    private long mDv;
    private HashMap<Integer, Long> mDw = new HashMap();
    private int mID = 463;
    private long mInterval = 300000;

    public final void g(int i, int i2, long j) {
        synchronized (this) {
            E(i, j);
            E(i2, 1);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mDv > this.mInterval) {
                for (Entry entry : this.mDw.entrySet()) {
                    f.mDy.a((long) this.mID, (long) ((Integer) entry.getKey()).intValue(), ((Long) entry.getValue()).longValue(), false);
                }
                this.mDv = currentTimeMillis;
            }
        }
    }

    private void E(int i, long j) {
        Long l = (Long) this.mDw.get(Integer.valueOf(i));
        if (l != null) {
            j += l.longValue();
        }
        this.mDw.put(Integer.valueOf(i), Long.valueOf(j));
    }
}
