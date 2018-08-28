package com.tencent.mm.plugin.wallet_ecard.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.model.BindCardOrder;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.a;

class WalletECardBindCardListUI$2 implements a {
    final /* synthetic */ WalletECardBindCardListUI pCn;

    WalletECardBindCardListUI$2(WalletECardBindCardListUI walletECardBindCardListUI) {
        this.pCn = walletECardBindCardListUI;
    }

    public final Intent n(int i, Bundle bundle) {
        x.i("MicroMsg.WalletECardBindCardListUI", "bind card end, resultCode: %s, feedbackData: %s", new Object[]{Integer.valueOf(i), bundle});
        if (i == -1) {
            BindCardOrder bindCardOrder = (BindCardOrder) bundle.getParcelable("key_bindcard_value_result");
            if (bindCardOrder != null) {
                ff ffVar = new ff();
                ffVar.lMV = bundle.getString("key_bind_card_type");
                ffVar.rgc = bindCardOrder.pmJ;
                ffVar.pjw = bundle.getString("key_mobile");
                if (!(bi.oW(ffVar.rgc) || bi.oW(ffVar.lMV) || bi.oW(ffVar.pjw))) {
                    this.pCn.cDL().m(new Object[]{ffVar});
                    return null;
                }
            }
        }
        WalletECardBindCardListUI.d(this.pCn);
        WalletECardBindCardListUI.e(this.pCn);
        return null;
    }
}
