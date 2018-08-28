package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.ui.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.f;
import com.tencent.mm.wallet_core.ui.e;

class g$a$1 implements OnClickListener {
    final /* synthetic */ ai kWI;
    final /* synthetic */ a kWJ;
    final /* synthetic */ Context val$context;

    g$a$1(a aVar, ai aiVar, Context context) {
        this.kWJ = aVar;
        this.kWI = aiVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.kWI.kRD)});
        if (this.kWJ.kWH != null) {
            f.eA(this.kWJ.kWH.kWN, 1);
        }
        e.l(this.val$context, this.kWI.content, true);
    }
}
