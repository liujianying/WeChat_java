package com.tencent.mm.plugin.gwallet;

import com.tencent.mm.plugin.gwallet.GWalletQueryProvider.1;
import com.tencent.mm.sdk.platformtools.ah.a;

class GWalletQueryProvider$1$1 implements a {
    final /* synthetic */ 1 kiI;

    GWalletQueryProvider$1$1(1 1) {
        this.kiI = 1;
    }

    public final boolean Kr() {
        GWalletQueryProvider.d(this.kiI.kiH);
        return true;
    }

    public final boolean Ks() {
        if (this.kiI.kiH.kiB != null) {
            this.kiI.kiH.kiB.dispose();
        }
        this.kiI.kiH.kiB = null;
        return true;
    }

    public final String toString() {
        return super.toString() + "|onIabSetupFinished";
    }
}
