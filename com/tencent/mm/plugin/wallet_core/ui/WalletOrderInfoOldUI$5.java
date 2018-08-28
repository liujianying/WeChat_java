package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoOldUI$5 extends c<tb> {
    final /* synthetic */ WalletOrderInfoOldUI pwD;

    WalletOrderInfoOldUI$5(WalletOrderInfoOldUI walletOrderInfoOldUI) {
        this.pwD = walletOrderInfoOldUI;
        this.sFo = tb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tb tbVar = (tb) bVar;
        if (!(tbVar instanceof tb)) {
            return false;
        }
        if (!tbVar.ceA.ceB.lKP) {
            x.i("MicroMsg.WalletOrderInfoOldUI", "block pass");
            return true;
        } else if (!"1".equals(tbVar.ceA.ceB.ced) && !"2".equals(tbVar.ceA.ceB.ced)) {
            return false;
        } else {
            RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
            realnameGuideHelper.a(tbVar.ceA.ceB.ced, tbVar.ceA.ceB.cee, tbVar.ceA.ceB.cef, tbVar.ceA.ceB.ceg, tbVar.ceA.ceB.ceh, this.pwD.mCn == null ? 0 : this.pwD.mCn.bVY);
            x.i("MicroMsg.WalletOrderInfoOldUI", "receive guide");
            this.pwD.sy.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            return false;
        }
    }
}
