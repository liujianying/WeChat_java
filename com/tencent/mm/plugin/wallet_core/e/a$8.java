package com.tencent.mm.plugin.wallet_core.e;

import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.vending.c.a;
import java.util.List;
import java.util.Map;

class a$8 implements a<Object, Object> {
    final /* synthetic */ a pAV;
    final /* synthetic */ Map pBa;
    final /* synthetic */ a$a pBb;
    final /* synthetic */ List pgg;

    public a$8(a aVar, List list, Map map, a$a a_a) {
        this.pAV = aVar;
        this.pgg = list;
        this.pBa = map;
        this.pBb = a_a;
    }

    public final Object call(Object obj) {
        for (Bankcard bankcard : this.pgg) {
            this.pBa.put(bankcard.field_bankcardType, b.Pj(bankcard.field_bankcardType));
        }
        if (this.pBb != null) {
            this.pBb.T(this.pBa);
        }
        return uQG;
    }
}
