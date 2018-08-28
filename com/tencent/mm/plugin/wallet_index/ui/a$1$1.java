package com.tencent.mm.plugin.wallet_index.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_index.b.a.a.a;
import com.tencent.mm.plugin.wallet_index.b.a.b;
import com.tencent.mm.plugin.wallet_index.b.a.c;
import com.tencent.mm.plugin.wallet_index.ui.a.1;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class a$1$1 implements a {
    final /* synthetic */ boolean kiM;
    final /* synthetic */ 1 pDj;

    a$1$1(1 1, boolean z) {
        this.pDj = 1;
        this.kiM = z;
    }

    public final void a(com.tencent.mm.plugin.wallet_index.c.a aVar, b bVar) {
        x.d("MicroMsg.GoogleWallet", "Query inventory finished.");
        if (aVar.isFailure() || bVar == null) {
            x.w("MicroMsg.GoogleWallet", "Failed to query inventory: " + aVar);
            return;
        }
        x.d("MicroMsg.GoogleWallet", "Query inventory was successful.");
        a.a(this.pDj.pDi, bVar);
        c b = a.b(this.pDj.pDi);
        Collection arrayList = new ArrayList(bVar.pCD.keySet());
        b.pDo.clear();
        b.pDo.addAll(arrayList);
        List<c> arrayList2 = new ArrayList(bVar.pCD.values());
        if (arrayList2.size() > 0) {
            for (c cVar : arrayList2) {
                x.i("MicroMsg.GoogleWallet", "do NetSceneVerifyPurchase. productId:" + cVar.iiv + ",billNo:" + cVar.pCI);
                g.Ek();
                g.Eh().dpP.a(a.b(this.pDj.pDi).a(cVar, true), 0);
            }
            return;
        }
        com.tencent.mm.plugin.wallet_index.c.a aN;
        x.d("MicroMsg.GoogleWallet", "purchases is null. consume null ");
        if (this.kiM) {
            x.d("MicroMsg.GoogleWallet", "result ok");
            aN = com.tencent.mm.plugin.wallet_index.c.a.aN(0, "");
        } else {
            x.d("MicroMsg.GoogleWallet", "unknown_purchase");
            aN = com.tencent.mm.plugin.wallet_index.c.a.aN(5, "");
        }
        if (a.c(this.pDj.pDi) != null) {
            a.c(this.pDj.pDi).a(aN, null);
        }
    }
}
