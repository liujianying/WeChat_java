package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class RechargeUI$15 implements OnClickListener {
    final /* synthetic */ RechargeUI mqE;

    RechargeUI$15(RechargeUI rechargeUI) {
        this.mqE = rechargeUI;
    }

    public final void onClick(View view) {
        c bPK = c.bPK();
        String str = RechargeUI.h(this.mqE).moy;
        x.d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : " + str);
        if (!bi.oW(str) && bPK.psm.containsKey(str)) {
            MallNews mallNews = (MallNews) bPK.psm.get(str);
            if ("1".equals(mallNews.psa)) {
                mallNews.psa = "2";
                bPK.bna();
            }
        }
        RechargeUI.i(this.mqE).setVisibility(8);
    }
}
