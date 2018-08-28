package com.tencent.mm.plugin.wear.model.e;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.protocal.c.ced;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public cec pJT;

    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11002));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        if (i != 11002) {
            return null;
        }
        a.ee(1, 0);
        a.zC(0);
        tp tpVar = new tp();
        tpVar.cfo.cfp = ad.getContext().getResources().getStringArray(R.c.emoji_product_id_list);
        tpVar.cfo.bIH = 1;
        com.tencent.mm.sdk.b.a.sFg.m(tpVar);
        byte[] bb = com.tencent.mm.plugin.wear.model.a.bSl().pIM.bb(bArr);
        if (bb == null) {
            return null;
        }
        try {
            cec cec = new cec();
            cec.aG(bb);
            ced ced = new ced();
            int i2 = 20;
            String str = null;
            while (i2 > 0) {
                str = q.GF();
                if (bi.oW(str)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    i2--;
                }
            }
            if (bi.oW(str)) {
                return null;
            }
            ced.rdS = str;
            str = w.e(ad.getContext().getSharedPreferences(ad.chY(), 0));
            String chP = w.chP();
            if (str.equals("language_default")) {
                ced.iwP = chP;
            } else {
                ced.iwP = str;
            }
            bb = com.tencent.mm.plugin.wear.model.a.bSl().pIM.bc(ced.toByteArray());
            if (bb == null) {
                return null;
            }
            this.pJT = cec;
            b tqVar = new tq();
            tqVar.cfq.bIH = 9;
            com.tencent.mm.sdk.b.a.sFg.a(tqVar, Looper.getMainLooper());
            return bb;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
            return null;
        }
    }
}
