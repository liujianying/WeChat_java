package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.g.a.tb;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$1 extends c<tb> {
    final /* synthetic */ WalletBindCardResultUI ptz;

    WalletBindCardResultUI$1(WalletBindCardResultUI walletBindCardResultUI) {
        this.ptz = walletBindCardResultUI;
        this.sFo = tb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tb tbVar = (tb) bVar;
        if (!(tbVar instanceof tb)) {
            return false;
        }
        if (!tbVar.ceA.ceB.lKP) {
            x.i("MicroMsg.WalletBindCardResultUI", "block pass");
            return true;
        } else if (!"1".equals(tbVar.ceA.ceB.ced) && !"2".equals(tbVar.ceA.ceB.ced)) {
            return false;
        } else {
            RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
            realnameGuideHelper.a(tbVar.ceA.ceB.ced, tbVar.ceA.ceB.cee, tbVar.ceA.ceB.cef, tbVar.ceA.ceB.ceg, tbVar.ceA.ceB.ceh, WalletBindCardResultUI.a(this.ptz) == null ? 0 : WalletBindCardResultUI.a(this.ptz).bVY);
            x.i("MicroMsg.WalletBindCardResultUI", "receive guide");
            this.ptz.sy.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            return false;
        }
    }
}
