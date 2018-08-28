package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletChangeBankcardUI$1 extends c<tk> {
    final /* synthetic */ WalletChangeBankcardUI pfC;

    WalletChangeBankcardUI$1(WalletChangeBankcardUI walletChangeBankcardUI) {
        this.pfC = walletChangeBankcardUI;
        this.sFo = tk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tk tkVar = (tk) bVar;
        x.i("MicroMsg.WalletChangeBankcardUI", "realnameNotifyListener %s", new Object[]{Integer.valueOf(tkVar.ceX.result)});
        sz szVar = new sz();
        if (tkVar.ceX.result == -1) {
            szVar.cdR.scene = 17;
        } else if (tkVar.ceX.result == 0) {
            szVar.cdR.scene = 18;
        } else {
            szVar.cdR.scene = 0;
        }
        szVar.cdS.cdN = new 1(this, tkVar);
        a.sFg.m(szVar);
        return false;
    }
}
