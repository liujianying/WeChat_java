package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements OnClickListener {
    final /* synthetic */ b kYI;
    final /* synthetic */ int kYJ;
    final /* synthetic */ MallFunction kYK;

    b$2(b bVar, int i, MallFunction mallFunction) {
        this.kYI = bVar;
        this.kYJ = i;
        this.kYK = mallFunction;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.FunctionListAdapter", "on Click");
        if (b.c(this.kYI) != null) {
            b.c(this.kYI).a(this.kYJ, this.kYK);
        }
    }
}
