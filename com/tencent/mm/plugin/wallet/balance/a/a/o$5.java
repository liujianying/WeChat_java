package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bbl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class o$5 implements a<Void, bbl> {
    final /* synthetic */ o oZs;

    o$5(o oVar) {
        this.oZs = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "pre redeem finish: %s", new Object[]{(bbl) obj});
        o.a(this.oZs).bNd();
        o.a(this.oZs, g.cBF());
        o.c(this.oZs).cBE();
        o.b(this.oZs, r9.sdF);
        Intent intent = new Intent(o.a(this.oZs), WalletLqtCheckPwdInputDialogUI.class);
        intent.putExtra("lqt_fetch_pwd_title", o.a(this.oZs).getString(i.wallet_lqt_fetch_pwd_dialog_wording));
        intent.putExtra("lqt_fetch_pwd_money", (((double) o.d(this.oZs)) / 100.0d));
        o.a(this.oZs).startActivityForResult(intent, o.bMR());
        return uQG;
    }
}
