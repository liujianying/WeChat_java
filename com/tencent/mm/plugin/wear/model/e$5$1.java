package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.g.a.ld;
import com.tencent.mm.plugin.wear.model.e.5;
import com.tencent.mm.plugin.wear.model.f.i;
import com.tencent.mm.protocal.c.cec;
import java.util.ArrayList;

class e$5$1 implements Runnable {
    final /* synthetic */ ld pJq;
    final /* synthetic */ 5 pJr;

    e$5$1(5 5, ld ldVar) {
        this.pJr = 5;
        this.pJq = ldVar;
    }

    public final void run() {
        a.bSl().pIO.PL(this.pJq.bVw.talker);
        f PK = a.bSl().pIO.PK(this.pJq.bVw.talker);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(PK.id));
        a.bSl().pIS.a(new i(arrayList));
        if (this.pJq.bVw.talker.equals("gh_43f2581f6fd6")) {
            cec cec = a.bSl().pIM.pJd.pJT;
            if (cec != null) {
                Object obj = (cec != null && a.bSl().pIP.pIW && b.PJ(cec.szd)) ? 1 : null;
                if (obj != null) {
                    a.bSl();
                    b.a(cec);
                    return;
                }
                a.bSl().pIP.connect();
            }
        }
    }
}
