package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.nv;
import com.tencent.mm.plugin.sns.model.af.35;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Iterator;

class af$35$1 implements Runnable {
    final /* synthetic */ ArrayList nqY;
    final /* synthetic */ String nqZ;
    final /* synthetic */ 35 nra;

    af$35$1(35 35, ArrayList arrayList, String str) {
        this.nra = 35;
        this.nqY = arrayList;
        this.nqZ = str;
    }

    public final void run() {
        ArrayList arrayList = this.nqY;
        String str = this.nqZ;
        if (arrayList != null && arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int i = bi.getInt((String) it.next(), 0);
                if (i != 0) {
                    n xd = af.byo().xd(i);
                    if (xd != null) {
                        bsu bAJ = xd.bAJ();
                        if (!(bAJ == null || bAJ.sqc == null || bAJ.sqc.ruz != 26)) {
                            bAJ.sqc.ruC = str;
                            af.byo().b(i, xd);
                            nv nvVar = new nv();
                            nvVar.bYQ.bYR = i;
                            a.sFg.m(nvVar);
                        }
                    }
                }
            }
        }
    }
}
