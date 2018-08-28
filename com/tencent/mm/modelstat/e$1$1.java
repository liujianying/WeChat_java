package com.tencent.mm.modelstat;

import com.tencent.mm.modelstat.e.1;
import com.tencent.mm.modelstat.e.b;
import com.tencent.mm.modelstat.e.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements a {
    boolean ejf = false;
    final /* synthetic */ b ejg;
    final /* synthetic */ c ejh;
    final /* synthetic */ String eji;
    final /* synthetic */ String ejj;
    final /* synthetic */ 1 ejk;

    e$1$1(1 1, b bVar, c cVar, String str, String str2) {
        this.ejk = 1;
        this.ejg = bVar;
        this.ejh = cVar;
        this.eji = str;
        this.ejj = str2;
    }

    public final boolean vD() {
        boolean dE = l.dE(ad.getContext());
        long VF = bi.VF();
        long a = VF - e.a(this.ejk.eje);
        if (a <= ((long) e.g(this.ejk.eje))) {
            if (dE) {
                this.ejf = false;
                return true;
            } else if (!this.ejf) {
                this.ejf = true;
                return true;
            }
        }
        x.i("MicroMsg.IndoorReporter", "Stop Now goingbg:%b fg:%b runtime:%d", new Object[]{Boolean.valueOf(this.ejf), Boolean.valueOf(dE), Long.valueOf(a)});
        e.a(this.ejk.eje, 0);
        String RX = this.ejg.RX();
        String RX2 = this.ejh.RX();
        try {
            if (bi.oW(RX) || bi.oW(RX2)) {
                x.e("MicroMsg.IndoorReporter", "get Res Failed [%s][%s]", new Object[]{RX, RX2});
                h.mEJ.k(13381, this.eji + this.ejj + (!bi.oW(RX) ? ",-10011,ERROR:StopFailed." : ",-10012,ERROR:StopFailed."));
                return false;
            }
            String str = RX + RX2;
            int ceil = (int) Math.ceil(((double) str.length()) / 5400.0d);
            for (int i = 0; i < ceil; i++) {
                x.i("MicroMsg.IndoorReporter", "reportKV [%d/%d] res:%d kv:%d [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(ceil), Integer.valueOf(str.length()), Integer.valueOf((this.eji + this.ejj + "_" + VF + "_" + ceil + "_" + (a > ((long) e.g(this.ejk.eje)) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))).length()), this.eji + this.ejj + "_" + VF + "_" + ceil + "_" + (a > ((long) e.g(this.ejk.eje)) ? "1" : "2") + "," + (i + 1) + "," + str.substring(i * 5400, Math.min((i + 1) * 5400, str.length()))});
                h.mEJ.k(13381, RX);
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.IndoorReporter", "reprot Stop exception:%s", new Object[]{e.getMessage()});
        }
    }
}
