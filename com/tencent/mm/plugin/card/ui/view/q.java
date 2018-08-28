package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends g {
    public String hGn = "";

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
                pr prVar = this.htQ.awm().rok;
                pr prVar2 = bVar.awm().rok;
                if ((prVar == null && prVar2 != null) || (prVar != null && prVar2 == null)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (prVar != null && prVar2 != null && prVar.title != null && prVar2.title != null && !prVar.title.equals(prVar2.title)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (prVar != null && prVar2 != null && prVar.huY != null && prVar2.huY != null && !prVar.huY.equals(prVar2.huY)) {
                    x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                } else if (!this.htQ.awg() || bi.oW(this.hGn)) {
                    return false;
                } else {
                    x.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    return true;
                }
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        if (!bi.oW(this.htQ.awn().rnp)) {
            return this.htQ.awn().rnp;
        }
        if (!this.htQ.awg() || bi.oW(this.hGn)) {
            return this.htQ.awn().code;
        }
        return this.hGn;
    }

    public final ab azN() {
        return new s(this, this.gKS);
    }

    public final ab azO() {
        return new p(this, this.gKS);
    }

    public final ab azP() {
        return new r(this, this.gKS);
    }
}
