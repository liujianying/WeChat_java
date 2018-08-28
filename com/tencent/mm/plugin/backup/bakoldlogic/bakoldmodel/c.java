package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public long dDj = 0;
    private long gTh = -1;
    boolean gTi = false;

    public final void begin() {
        x.d("MicroMsg.Recoverfaster", "begin");
        if (b.atl().atm().dqq != null) {
            this.gTh = b.atl().atm().dqq.dO(Thread.currentThread().getId());
            this.gTi = true;
        }
        this.dDj = bi.VF();
    }

    public final void end() {
        if (this.gTi && b.atl().atm().dqq != null) {
            b.atl().atm().dqq.gp(this.gTh);
            this.gTi = false;
        }
    }
}
