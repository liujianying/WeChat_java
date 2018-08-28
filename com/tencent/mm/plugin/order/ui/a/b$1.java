package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.ui.e;

class b$1 implements OnClickListener {
    final /* synthetic */ MallTransactionObject lNC;
    final /* synthetic */ b lQi;
    final /* synthetic */ Context val$context;

    b$1(b bVar, MallTransactionObject mallTransactionObject, Context context) {
        this.lQi = bVar;
        this.lNC = mallTransactionObject;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.lNC.lNW)) {
            e.ab(this.val$context, this.lNC.lNW);
        }
    }
}
