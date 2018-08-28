package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.ui.g.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.x;

class g$e$1 implements OnClickListener {
    final /* synthetic */ ai kWI;
    final /* synthetic */ e kWO;
    final /* synthetic */ Context val$context;

    g$e$1(e eVar, ai aiVar, Context context) {
        this.kWO = eVar;
        this.kWI = aiVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.kWI.kRD));
        if (this.kWO.kWH != null) {
            f.eA(this.kWO.kWH.kWN, 1);
        }
        if (this.kWO.kWH != null && this.kWO.kWH.kWM) {
            h.mEJ.h(13051, Integer.valueOf(this.kWO.kWH.kWN), Integer.valueOf(2), "", "", "", this.kWI.content, this.kWI.type, "", "", Integer.valueOf(this.kWO.kWH.resourceId));
        }
        if (this.kWI.type.equals("Native")) {
            x.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + this.kWI.content);
            if ("weixin://festival/gotoshake".equalsIgnoreCase(this.kWI.content)) {
                x.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                return;
            }
            return;
        }
        com.tencent.mm.wallet_core.ui.e.l(this.val$context, this.kWI.content, true);
    }
}
