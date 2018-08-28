package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends g {
    public final boolean h(b bVar) {
        if (this.htQ == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else {
            String str = this.htQ.awn().code;
            String str2 = bVar.awn().code;
            if (bi.oW(str) || bi.oW(str2) || str.equals(str2)) {
                return false;
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        return this.htQ.awn().code;
    }

    public final ab azN() {
        return new v(this, this.gKS);
    }

    public final ab azO() {
        return new f(this, this.gKS);
    }

    public final ab azP() {
        return new t(this, this.gKS);
    }
}
