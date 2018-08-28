package com.tencent.mm.ac;

import com.tencent.mm.ac.m.a;
import com.tencent.mm.ac.m.b;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class m$1 implements Runnable {
    final /* synthetic */ String dMv;
    final /* synthetic */ String dMw;

    m$1(String str, String str2) {
        this.dMv = str;
        this.dMw = str2;
    }

    public final void run() {
        a Ni = z.Ni();
        String str = this.dMv;
        String str2 = this.dMw;
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.BrandLogic", "pushing for brand " + str + ", url " + str2);
        } else if (bi.bG((long) bi.f((Integer) Ni.dMy.get(str))) < 300) {
            x.i("MicroMsg.BrandLogic", "downloading interval less than 5 mins for " + str);
        } else {
            Ni.dMy.put(str, Integer.valueOf((int) bi.VE()));
            if (Ni.dMA == null || Ni.dMA.ciz()) {
                Ni.dMA = new at(1, "brand-logic");
            }
            Ni.dMA.c(new b(str, m.ai(str, str2)));
        }
    }
}
