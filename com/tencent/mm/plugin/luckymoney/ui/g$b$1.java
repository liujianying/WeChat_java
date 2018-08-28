package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.b.ai;
import com.tencent.mm.plugin.luckymoney.ui.g.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.wallet_core.ui.e;

class g$b$1 implements OnClickListener {
    final /* synthetic */ ai kWI;
    final /* synthetic */ b kWK;
    final /* synthetic */ Context val$context;

    g$b$1(b bVar, ai aiVar, Context context) {
        this.kWK = bVar;
        this.kWI = aiVar;
        this.val$context = context;
    }

    public final void onClick(View view) {
        h.mEJ.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.kWI.kRD)});
        if (this.kWI.kRE != 1) {
            ((f) g.l(f.class)).a(this.val$context, this.kWI.content, new 1(this)).show();
        } else {
            e.ab(this.val$context, this.kWI.content);
        }
    }
}
