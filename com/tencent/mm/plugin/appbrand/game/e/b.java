package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static final long fDi = 100000000;
    private static final long fDj = 16666666;
    public long fDk = 16666666;
    private long fDl = -1;
    private boolean fDm = false;

    public static long kv(int i) {
        return 1000000000 / ((long) i);
    }

    public final void ahm() {
        if (this.fDl == -1) {
            this.fDl = System.nanoTime();
        }
    }

    public final void cH(boolean z) {
        if (this.fDk > fDj || !z || this.fDm) {
            this.fDm = true;
            if (this.fDl != -1) {
                long nanoTime = System.nanoTime() - this.fDl;
                if (nanoTime < this.fDk) {
                    nanoTime = this.fDk - nanoTime;
                    try {
                        Thread.sleep(nanoTime / 1000000, (int) (nanoTime % 1000000));
                    } catch (InterruptedException e) {
                        x.e("MicroMsg.WAGameFrameRateController", "Sleep unsuccessfully.");
                    }
                }
            }
            this.fDl = System.nanoTime();
        }
    }
}
