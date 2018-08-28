package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;

public final class as {
    public String bNH;
    public String bSZ;
    public boolean nZw = false;
    public boolean nZx = false;
    public int scene;

    public as(String str, String str2, boolean z, boolean z2, int i) {
        this.bSZ = str;
        this.nZw = z;
        this.nZx = z2;
        this.scene = i;
        this.bNH = str2;
    }

    public final boolean bDG() {
        int i = 2;
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        b Mq = ap.Mq(this.bSZ);
        if (Mq == null || !Mq.dDR || Mq.dHC || (i & Mq.csE) == 0) {
            return false;
        }
        return true;
    }
}
