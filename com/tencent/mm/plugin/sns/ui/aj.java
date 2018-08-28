package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class aj {
    String iKw = "";
    long nQT = 0;
    String nQU = "";
    int nQV = 0;
    long nro = 0;
    int position = 0;

    public final boolean bCB() {
        x.i("MicroMsg.ResumeSnsControl", "resume time %d", new Object[]{Long.valueOf(bi.bI(this.nQT))});
        x.i("MicroMsg.ResumeSnsControl", "lastSnsTime %s limitSeq %s respMinSeq %s timeLastId %s position %s topy %s", new Object[]{Long.valueOf(this.nQT), this.iKw, this.nQU, Long.valueOf(this.nro), Integer.valueOf(this.position), Integer.valueOf(this.nQV)});
        if (bi.bI(this.nQT) >= 180000 || this.position <= 0) {
            return false;
        }
        x.i("MicroMsg.ResumeSnsControl", "timeLastId is %d ", new Object[]{Long.valueOf(this.nro)});
        if (this.nro == 0) {
            return false;
        }
        af.bye().z(this.nro, -1);
        return true;
    }
}
