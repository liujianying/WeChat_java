package com.tencent.mm.plugin.wallet.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ae;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class a {
    public static boolean bOh() {
        boolean z;
        k kVar = (k) g.l(k.class);
        x.i("MicroMsg.WalletUtil", "mgr==null?" + (kVar == null));
        if (kVar != null) {
            x.i("MicroMsg.WalletUtil", " mgr.isSupportAndLoadSuccess()=" + kVar.aNm());
        }
        p.bNp();
        ag bNq = p.bNq();
        ae bPw = bNq.bPw();
        String str = "MicroMsg.WalletUtil";
        StringBuilder stringBuilder = new StringBuilder("config==null?");
        if (bPw == null) {
            z = true;
        } else {
            z = false;
        }
        x.i(str, stringBuilder.append(z).toString());
        if (bPw != null) {
            x.i("MicroMsg.WalletUtil", "config.isSupportTouchPay()=" + bPw.bPl());
        }
        x.i("MicroMsg.WalletUtil", "userInfoManger.isReg()=" + bNq.bPs());
        if (kVar != null && kVar.aNm() && bPw != null && bPw.bPl() && bNq.bPs()) {
            return true;
        }
        return false;
    }

    public static boolean bOi() {
        boolean z;
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100338");
        if (!fJ.isValid()) {
            z = false;
        } else if (bi.getInt((String) fJ.ckq().get("enabled"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.WalletUtil", "isEnableSaveAndFetchBindQuery enabled: %b", new Object[]{Boolean.valueOf(z)});
        return z;
    }
}
