package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.q.a;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;

public final class f {
    public static a a(q qVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        return a(qVar, bundle);
    }

    private static a a(q qVar, Bundle bundle) {
        if (qVar == null) {
            return null;
        }
        if (((e) qVar.dJM.Id()).qWn.srN == null) {
            return null;
        }
        bnp bnp = ((e) qVar.dJM.Id()).qWn.srN.reD;
        if (!(bnp == null || bnp.slI == null || bnp.slI.size() <= 0)) {
            a aVar = new a();
            Iterator it = bnp.slI.iterator();
            while (it.hasNext()) {
                brj brj = (brj) it.next();
                if (brj.mEb == 19) {
                    aVar.bLe = brj.spx;
                } else if (brj.mEb == 20) {
                    aVar.efV = brj.spx;
                } else if (brj.mEb == 21) {
                    aVar.bSc = brj.spx;
                }
            }
            aVar.efW = bundle;
            aVar.type = 0;
            if (!bi.oW(aVar.bLe)) {
                aVar.username = ((d) qVar.dJM.KV()).qWk.rUY.hbL;
                return aVar;
            }
        }
        return null;
    }
}
