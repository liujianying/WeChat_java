package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.2;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class k implements b<j> {
    protected j oYT;
    public final b oYU;
    public final a oYV;
    public final d oYW;
    public final c oYX;

    public class a implements e<pk, c<String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            c cVar = (c) obj;
            j jVar = k.this.oYT;
            String str = (String) cVar.get(0);
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b cBF = g.cBF();
            cBF.cBE();
            x.i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", new Object[]{Integer.valueOf(intValue)});
            new a(str, intValue).KM().h(new 2(jVar, cBF));
            return null;
        }

        public final String xr() {
            return "Vending.LOGIC";
        }
    }

    public final /* bridge */ /* synthetic */ Object VT() {
        return this.oYT;
    }

    public k() {
        this(new j());
    }

    private k(j jVar) {
        this.oYU = new b(this);
        this.oYV = new a();
        this.oYW = new d(this);
        this.oYX = new c(this);
        this.oYT = jVar;
    }
}
