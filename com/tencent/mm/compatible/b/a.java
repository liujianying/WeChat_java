package com.tencent.mm.compatible.b;

import java.util.concurrent.locks.Lock;

public final class a {
    public int daE = 0;
    public int daF = 0;
    public byte[] daG = null;
    public int daH = 0;
    public int daI = 0;
    public boolean daJ = false;
    public Lock daK = null;

    public final int yx() {
        if (this.daJ) {
            this.daK.lock();
        }
        if (this.daH == this.daI) {
            return 0;
        }
        if (this.daH < this.daI) {
            this.daF = this.daI - this.daH;
        } else if (this.daH > this.daI) {
            this.daF = (this.daI + this.daE) - this.daH;
        }
        if (this.daJ) {
            this.daK.unlock();
        }
        return this.daF;
    }
}
