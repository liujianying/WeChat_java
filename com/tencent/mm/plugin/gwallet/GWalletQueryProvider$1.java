package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.platformtools.x;

class GWalletQueryProvider$1 implements a {
    final /* synthetic */ GWalletQueryProvider kiH;

    GWalletQueryProvider$1(GWalletQueryProvider gWalletQueryProvider) {
        this.kiH = gWalletQueryProvider;
    }

    public final void a(c cVar) {
        x.d("MicroMsg.GWalletQueryProvider", "Setup finished.");
        if (cVar.isSuccess()) {
            g.Em().a(new 1(this));
            return;
        }
        x.e("MicroMsg.GWalletQueryProvider", "Problem setting up in-app billing: " + cVar);
        GWalletQueryProvider.a(this.kiH);
        if (GWalletQueryProvider.b(this.kiH) != null) {
            GWalletQueryProvider.b(this.kiH).dispose();
        }
        GWalletQueryProvider.c(this.kiH);
    }
}
