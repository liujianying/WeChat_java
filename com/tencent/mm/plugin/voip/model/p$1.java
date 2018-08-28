package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements a {
    final /* synthetic */ p oMX;

    p$1(p pVar) {
        this.oMX = pVar;
    }

    public final boolean vD() {
        if (!this.oMX.oMR) {
            return false;
        }
        int i;
        byte[] bArr = new byte[4];
        if (this.oMX.oMN.setAppCmd(10, bArr, 4) < 0) {
            x.d("MicroMsg.VoipNetStatusChecker", "get netStatus failed");
            i = -1;
        } else {
            i = bi.aH(bArr);
            x.d("MicroMsg.VoipNetStatusChecker", "netStatus: %d", new Object[]{Integer.valueOf(i)});
        }
        if (i != -1) {
            this.oMX.oMQ = i;
            this.oMX.oMT = this.oMX.oMQ + this.oMX.oMT;
            p pVar = this.oMX;
            pVar.oMU++;
            pVar = this.oMX;
            if (pVar.oMQ < 5) {
                pVar.oMS = 0;
                if (!pVar.oMO) {
                    pVar.oMO = true;
                    x.d("MicroMsg.VoipNetStatusChecker", "go to bad net status");
                    if (pVar.oMP != null) {
                        pVar.oMP.aWP();
                    }
                }
            } else if (pVar.oMO) {
                if (pVar.oMS <= 0) {
                    x.d("MicroMsg.VoipNetStatusChecker", "ignore this good net status");
                    pVar.oMS++;
                } else {
                    pVar.oMO = false;
                    x.d("MicroMsg.VoipNetStatusChecker", "go to good net status");
                    if (pVar.oMP != null) {
                        pVar.oMP.aWQ();
                    }
                }
            }
        }
        return true;
    }
}
