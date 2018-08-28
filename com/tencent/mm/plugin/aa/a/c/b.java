package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.a.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;
import com.tencent.mm.vending.j.d;
import java.util.List;

public class b implements com.tencent.mm.vending.c.b<a> {
    protected a eBl;
    public final a eBm;

    public class a implements e<d<List, String, Boolean>, c<Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            int i2 = 20;
            c cVar = (c) obj;
            a aVar = b.this.eBl;
            boolean booleanValue = ((Boolean) cVar.get(0)).booleanValue();
            int intValue = ((Integer) cVar.get(1)).intValue();
            if (!booleanValue || aVar.eBc <= 0) {
                i = 20;
            } else {
                i = aVar.eBc;
                aVar.eBc = 0;
                aVar.eBh = false;
            }
            if (aVar.eBi == intValue) {
                i2 = i;
            }
            aVar.eBi = intValue;
            x.i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", new Object[]{Integer.valueOf(aVar.eBc), Boolean.valueOf(booleanValue)});
            com.tencent.mm.vending.g.b cBF = g.cBF();
            cBF.cBE();
            (aVar.eBh ? new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.eBc, intValue, aVar.eBd, aVar.eBe, aVar.eBf, aVar.eBg) : new com.tencent.mm.plugin.aa.a.a.c(i2, aVar.eBc, intValue)).KM().h(new 1(aVar, cBF));
            return null;
        }

        public final String xr() {
            return "Vending.ANY";
        }
    }

    public final /* bridge */ /* synthetic */ Object VT() {
        return this.eBl;
    }

    public b() {
        this(new a());
    }

    private b(a aVar) {
        this.eBm = new a();
        this.eBl = aVar;
    }
}
