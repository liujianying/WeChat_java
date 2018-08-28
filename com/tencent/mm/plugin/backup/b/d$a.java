package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.bi;

class d$a {
    private long beginTime;
    final /* synthetic */ d gTg;
    private long gTh;
    boolean gTi;

    private d$a(d dVar) {
        this.gTg = dVar;
        this.gTh = -1;
        this.gTi = false;
    }

    /* synthetic */ d$a(d dVar, byte b) {
        this(dVar);
    }

    public final void begin() {
        if (d.asG().asH().dqq != null) {
            this.gTh = d.asG().asH().dqq.dO(Thread.currentThread().getId());
            this.gTi = true;
            this.beginTime = bi.VF();
        }
    }

    public final void end() {
        if (this.gTi && d.asG().asH().dqq != null) {
            d.asG().asH().dqq.gp(this.gTh);
            this.gTi = false;
        }
    }

    public final void arn() {
        if (bi.bH(this.beginTime) > 500) {
            end();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
            }
            begin();
            this.beginTime = bi.VF();
        }
    }
}
