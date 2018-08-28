package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

class MallIndexUI$8 implements OnClickListener {
    final /* synthetic */ MallIndexUI lab;
    final /* synthetic */ View lae;

    MallIndexUI$8(MallIndexUI mallIndexUI, View view) {
        this.lab = mallIndexUI;
        this.lae = view;
    }

    public final void onClick(View view) {
        g.Ek();
        g.Ei().DT().a(a.sXN, Integer.valueOf(-1));
        this.lae.findViewById(f.balance_red_dot).setVisibility(8);
        Intent intent;
        if (q.GS()) {
            intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            d.b(this.lab, "wallet_payu", ".balance.ui.WalletPayUBalanceManagerUI", intent);
        } else {
            intent = new Intent();
            intent.putExtra("key_scene_balance_manager", 2);
            if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(MallIndexUI.b(this.lab)) && MallIndexUI.c(this.lab)) {
                x.i("MicorMsg.MallIndexUI", "set quota info");
                intent.putExtra("key_inc_bal_amt_flag", MallIndexUI.b(this.lab));
                intent.putExtra("key_ecard_info", MallIndexUI.d(this.lab));
            }
            d.b(this.lab, "wallet", ".balance.ui.WalletBalanceManagerUI", intent);
        }
        e.He(11);
        h.mEJ.h(14419, new Object[]{this.lab.fMk, Integer.valueOf(2)});
    }
}
