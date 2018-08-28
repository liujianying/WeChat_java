package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.dbbackup.d.9;
import com.tencent.mm.storage.x;

class d$9$1 implements b {
    final /* synthetic */ boolean hZs;
    final /* synthetic */ 9 iay;

    d$9$1(9 9, boolean z) {
        this.iay = 9;
        this.hZs = z;
    }

    public final void ov(int i) {
        this.iay.iam.hZP = false;
        au.HU();
        x DT = c.DT();
        this.iay.iam.hZT = System.currentTimeMillis();
        if (i == 0) {
            DT.setLong(237569, this.iay.iam.hZT);
            if (this.hZs) {
                this.iay.iam.hZU = this.iay.iam.hZU + 1;
            } else {
                this.iay.iam.hZU = 0;
            }
            DT.setInt(237570, this.iay.iam.hZU);
        } else if (i != 1) {
            DT.setLong(237569, this.iay.iam.hZT);
            if (this.hZs) {
                this.iay.iam.hZU = 10;
                DT.setInt(237570, this.iay.iam.hZU);
            }
        } else {
            return;
        }
        DT.lm(false);
    }
}
